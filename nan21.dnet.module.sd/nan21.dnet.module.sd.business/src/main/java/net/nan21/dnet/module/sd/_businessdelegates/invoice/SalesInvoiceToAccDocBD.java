package net.nan21.dnet.module.sd._businessdelegates.invoice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;

import net.nan21.dnet.module.md.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalPeriodService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.tax.business.service.ITaxAcctService;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxAcct;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;

public class SalesInvoiceToAccDocBD extends AbstractBusinessDelegate {

	IBusinessPartnerService bpService;
	IFiscalPeriodService periodService;
	IProductService prodService;

	public void unPost(SalesInvoice invoice) throws Exception {
		try {
			this.em
					.createQuery(
							"delete from AccDoc t "
									+ " where t.docUuid = :invoiceUuid")
					.setParameter("invoiceUuid", invoice.getUuid())
					.executeUpdate();
			invoice.setPosted(false);
			this.em.merge(invoice);
		} catch (Exception e) {
			if (e.getCause() != null
					&& e.getCause() instanceof SQLIntegrityConstraintViolationException) {
				throw new RuntimeException(
						"Cannot unpost document `"
								+ invoice.getCode()
								+ "`. The corresponding accounting document is already posted to great ledger.");
			} else {
				throw e;
			}
		}

	}

	public List<AccDoc> post(SalesInvoice invoice) throws Exception {
		List<AccDoc> result = new ArrayList<AccDoc>();
		// get org schemas , for each schema generate an acc-doc
		IAccSchemaService srv = (IAccSchemaService) this
				.findEntityService(AccSchema.class);
		List<AccSchema> schemas = srv.findAll();
		for (AccSchema schema : schemas) {
			AccDoc doc = this.generateAccDoc(invoice, schema);
			result.add(doc);
			this.em.persist(doc);
		}
		invoice.setPosted(true);
		this.em.merge(invoice);
		return result;
	}

	protected AccDoc generateAccDoc(SalesInvoice invoice, AccSchema schema)
			throws Exception {

		Float totalCrAmount = 0F;
		Float totalDbAmount = 0F;

		AccDoc accDoc = new AccDoc();
		accDoc.setPeriod(getPeriodService().getPostingPeriod(
				invoice.getDocDate(), invoice.getSupplier()));
		accDoc.setDocDate(invoice.getDocDate());
		if (invoice.getDocNo() != null) {
			accDoc.setDocNo(invoice.getDocNo());
		} else {
			accDoc.setDocNo(invoice.getCode());
		}
		accDoc.setOrg(invoice.getSupplier());
		accDoc.setAccSchema(schema);
		accDoc.setDocUuid(invoice.getUuid());
		accDoc.setDocType(invoice.getDocType());
		accDoc.setJournal(invoice.getDocType().getJournal());
		accDoc.setBpartner(invoice.getCustomer());

		accDoc.setDocCurrency(invoice.getCurrency());
		accDoc.setDocAmount(invoice.getTotalAmount());
		accDoc.setDocNetAmount(invoice.getTotalNetAmount());
		accDoc.setDocTaxAmount(invoice.getTotalTaxAmount());

		// get period

		// customer revenue
		String dbAccount = getBpService().getPostingCustomerAcct(
				invoice.getCustomer(), invoice.getSupplier(), schema);

		int i = 1;
		AccDocLine line = new AccDocLine();

		line.setAccDoc(accDoc);
		line.setSequenceNo(i++);
		line.setHeaderLine(true);
		line.setDbAccount(dbAccount);
		line.setDbAmount(invoice.getTotalAmount());

		accDoc.addToLines(line);

		totalDbAmount += line.getDbAmount();

		// tax
		for (SalesInvoiceTax tax : invoice.getTaxes()) {
			Account crAccount = null;
			try {
				crAccount = this.getTaxAccount(tax.getTax().getId(), invoice
						.getSupplier().getId(), schema.getId());
				if (crAccount == null) {
					throw new NoResultException();
				}
			} catch (NoResultException e) {
				throw new RuntimeException("No posting account found for tax "
						+ tax.getTax().getName() + " for accounting schema "
						+ schema.getCode());
			}
			AccDocLine itemLine = new AccDocLine();
			itemLine.setAccDoc(accDoc);
			itemLine.setSequenceNo(i++);
			itemLine.setCrAccount(crAccount.getCode());
			itemLine.setCrAmount(tax.getTaxAmount());
			accDoc.addToLines(itemLine);

			totalCrAmount += itemLine.getCrAmount();
		}

		// product revenue

		for (SalesInvoiceItem item : invoice.getLines()) {
			String crAccount = this.getProdService().getRevenueAcct(
					item.getProduct(), invoice.getSupplier(), schema);

			AccDocLine itemLine = new AccDocLine();
			itemLine.setAccDoc(accDoc);
			itemLine.setSequenceNo(i++);
			itemLine.setCrAccount(crAccount);
			itemLine.setCrAmount(item.getNetAmount());

			accDoc.addToLines(itemLine);
			totalCrAmount += itemLine.getCrAmount();
		}

		accDoc.setCrAmount(totalCrAmount);
		accDoc.setDbAmount(totalDbAmount);
		accDoc.setDifference(Math.abs(accDoc.getDbAmount()
				- accDoc.getCrAmount()));
		return accDoc;
	}

	private Account getTaxAccount(Long taxId, Long organizationId,
			Long accSchemaId) throws Exception {

		ITaxAcctService acctService = (ITaxAcctService) this
				.findEntityService(TaxAcct.class);
		TaxAcct acct = acctService.findByTax_schema(taxId, accSchemaId);

		return acct.getSalesAccount();
	}

	protected IBusinessPartnerService getBpService() throws Exception {
		if (this.bpService == null) {
			this.bpService = (IBusinessPartnerService) this
					.findEntityService(BusinessPartner.class);
		}
		return this.bpService;
	}

	public IFiscalPeriodService getPeriodService() throws Exception {
		if (this.periodService == null) {
			this.periodService = (IFiscalPeriodService) this
					.findEntityService(FiscalPeriod.class);
		}
		return this.periodService;
	}

	public IProductService getProdService() throws Exception {
		if (this.prodService == null) {
			this.prodService = (IProductService) this
					.findEntityService(Product.class);
		}
		return this.prodService;
	}

}
