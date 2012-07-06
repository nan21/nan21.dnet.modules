package net.nan21.dnet.module.sc._businessdelegates.invoice;

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
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountAcctService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;

public class PurchaseInvoiceToAccDocBD extends AbstractBusinessDelegate {

	IBusinessPartnerService bpService;
	IFiscalPeriodService periodService;
	IProductService prodService;
	IFinancialAccountAcctService payAcctService;

	/**
	 * Un-post invoice. Delete linked accounting document(s).
	 * 
	 * @param invoice
	 * @throws Exception
	 */
	public void unPost(PurchaseInvoice invoice) throws Exception {
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

	/**
	 * Post purchase invoice to accounting. Generate accounting document(s).
	 * 
	 * @param invoice
	 * @return
	 * @throws Exception
	 */
	public List<AccDoc> post(PurchaseInvoice invoice) throws Exception {
		List<AccDoc> result = new ArrayList<AccDoc>();
		// get org schemas , for each schema generate an acc-doc
		IAccSchemaService srv = (IAccSchemaService) this
				.findEntityService(AccSchema.class);
		List<AccSchema> schemas = srv.findAll();
		for (AccSchema schema : schemas) {
			AccDoc doc = this.generateAccDoc(invoice, schema);
			result.add(doc);
		}
		invoice.setPosted(true);
		this.em.merge(invoice);
		return result;
	}

	protected AccDoc generateAccDoc(PurchaseInvoice invoice, AccSchema schema)
			throws Exception {
		AccDoc doc = this.generateAccDocPurchase(invoice, schema);
		this.em.persist(doc);
		if (invoice.getSelfPayed()) {
			doc = this.generateAccDocPayment(invoice, schema);
			this.em.persist(doc);
		}
		return null;
	}

	/**
	 * Create accounting document header based on invoice header data.
	 * 
	 * @param invoice
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	protected AccDoc createHeader(PurchaseInvoice invoice, AccSchema schema)
			throws Exception {
		AccDoc accDoc = new AccDoc();
		accDoc.setPeriod(getPeriodService().getPostingPeriod(
				invoice.getDocDate(), invoice.getCustomer()));
		accDoc.setDocDate(invoice.getDocDate());
		if (invoice.getDocNo() != null) {
			accDoc.setDocNo(invoice.getDocNo());
		} else {
			accDoc.setDocNo(invoice.getCode());
		}
		accDoc.setOrg(invoice.getCustomer());
		accDoc.setAccSchema(schema);
		accDoc.setDocUuid(invoice.getUuid());
		accDoc.setDocType(invoice.getDocType());

		accDoc.setBpartner(invoice.getSupplier());
		accDoc.setDocCurrency(invoice.getCurrency());
		accDoc.setDocAmount(invoice.getTotalAmount());
		accDoc.setDocNetAmount(invoice.getTotalNetAmount());
		accDoc.setDocTaxAmount(invoice.getTotalTaxAmount());
		return accDoc;
	}

	/**
	 * Generate the accounting document(s) for the document liability.
	 * 
	 * @param invoice
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	protected AccDoc generateAccDocPurchase(PurchaseInvoice invoice,
			AccSchema schema) throws Exception {

		AccDoc accDoc = this.createHeader(invoice, schema);

		accDoc.setJournal(invoice.getDocType().getJournal());

		Float totalCrAmount = 0F;
		Float totalDbAmount = 0F;

		int i = 1;
		// header line - vendor liability

		String crAccount = getBpService().getPostingVendorAcct(
				invoice.getSupplier(), invoice.getCustomer(), schema);

		AccDocLine line = new AccDocLine();

		line.setAccDoc(accDoc);
		line.setHeaderLine(true);
		line.setSequenceNo(i++);
		line.setCrAmount(invoice.getTotalAmount());
		line.setCrAccount(crAccount);
		accDoc.addToLines(line);

		totalCrAmount += line.getCrAmount();

		// tax
		for (PurchaseInvoiceTax tax : invoice.getTaxes()) {
			Account dbAccount = null;
			try {
				dbAccount = this.getTaxAccount(tax.getTax().getId(), invoice
						.getCustomer().getId(), schema.getId());
				if (dbAccount == null) {
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
			itemLine.setDbAccount(dbAccount.getCode());
			itemLine.setDbAmount(tax.getTaxAmount());
			accDoc.addToLines(itemLine);
			totalDbAmount += itemLine.getDbAmount();
		}

		// product expense

		for (PurchaseInvoiceItem item : invoice.getLines()) {
			String dbAccount = this.getProdService().getExpenseAcct(
					item.getProduct(), invoice.getCustomer(), schema);

			AccDocLine itemLine = new AccDocLine();
			itemLine.setAccDoc(accDoc);
			itemLine.setSequenceNo(i++);
			itemLine.setDbAccount(dbAccount);
			itemLine.setDbAmount(item.getNetAmount());

			accDoc.addToLines(itemLine);
			totalDbAmount += itemLine.getDbAmount();
		}

		accDoc.setCrAmount(totalCrAmount);
		accDoc.setDbAmount(totalDbAmount);
		accDoc.setDifference(Math.abs(accDoc.getDbAmount()
				- accDoc.getCrAmount()));
		return accDoc;
	}

	/**
	 * Generate the accounting document(s) for the document payment in case it
	 * is a self-payed document.
	 * 
	 * @param invoice
	 * @param schema
	 * @return
	 * @throws Exception
	 */
	protected AccDoc generateAccDocPayment(PurchaseInvoice invoice,
			AccSchema schema) throws Exception {

		AccDoc accDoc = this.createHeader(invoice, schema);

		int i = 1;

		// header line - vendor

		if (invoice.getFromAccount().getJournal() == null) {
			throw new RuntimeException(
					"Financial account `"
							+ invoice.getFromAccount().getName()
							+ "` is not linked to any journal. Cannot post the self-contained payment of purchase invoice with code `"
							+ invoice.getCode() + "`.");
		}
		accDoc.setJournal(invoice.getFromAccount().getJournal());

		String dbAccount = getBpService().getPostingVendorAcct(
				invoice.getSupplier(), invoice.getCustomer(), schema);

		AccDocLine line = new AccDocLine();

		line.setAccDoc(accDoc);
		line.setHeaderLine(true);
		line.setSequenceNo(i++);
		line.setDbAccount(dbAccount);
		line.setDbAmount(invoice.getTotalAmount());

		accDoc.setDbAmount(line.getDbAmount());
		accDoc.addToLines(line);

		// detail line - financial account

		String crAccount = this.getPayAcctService().getPostingWithdrawalAcct(
				invoice.getFromAccount(), schema);

		line = new AccDocLine();
		line.setAccDoc(accDoc);
		line.setSequenceNo(i++);
		line.setCrAccount(crAccount);
		line.setCrAmount(invoice.getTotalAmount());

		accDoc.setCrAmount(line.getCrAmount());
		accDoc.setDifference(Math.abs(accDoc.getDbAmount()
				- accDoc.getCrAmount()));
		accDoc.addToLines(line);

		return accDoc;
	}

	private Account getTaxAccount(Long taxId, Long organizationId,
			Long accSchemaId) throws Exception {

		ITaxAcctService acctService = (ITaxAcctService) this
				.findEntityService(TaxAcct.class);
		TaxAcct acct = acctService.findByTax_schema(taxId, accSchemaId);

		return acct.getPurchaseAccount();
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

	public IFinancialAccountAcctService getPayAcctService() throws Exception {
		if (this.payAcctService == null) {
			this.payAcctService = (IFinancialAccountAcctService) this
					.findEntityService(FinancialAccountAcct.class);
		}
		return this.payAcctService;
	}
}