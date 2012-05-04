package net.nan21.dnet.module.sd._businessdelegates.invoice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.bd.fin.business.service.ITaxAcctService;
import net.nan21.dnet.module.bd.fin.domain.entity.TaxAcct;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountAcctService;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountService;
import net.nan21.dnet.module.md.bp.business.service.ICustomerGroupAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountAcctService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountGroupAcctService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;

public class SalesInvoiceToAccDocBD extends AbstractBusinessDelegate {

	public void unPostInvoice(SalesInvoice invoice) throws Exception {
		this.em.createQuery(
				"delete from AccDoc t " + " where t.docUuid = :invoiceUuid")
				.setParameter("invoiceUuid", invoice.getUuid()).executeUpdate();
		invoice.setPosted(false);
		this.em.merge(invoice);
	}

	public List<AccDoc> postInvoice(SalesInvoice invoice) throws Exception {
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
		accDoc.setDocDate(invoice.getDocDate());
		accDoc.setOrg(invoice.getSupplier());
		accDoc.setAccSchema(schema);
		accDoc.setDocUuid(invoice.getUuid());
		accDoc.setDocType(invoice.getDocType());
		// customer revenue
		AccDocLine line = new AccDocLine();
		line.setAccDoc(accDoc);
		line.setDbAmount(invoice.getTotalAmount());

		Account dbAccount = null;
		try {
			dbAccount = this.getSalesAccount(invoice.getCustomer().getId(),
					invoice.getSupplier().getId(), schema.getId());
			if (dbAccount == null) {
				throw new NoResultException();
			}
		} catch (NoResultException e) {
			throw new RuntimeException(
					"No sales account found for business partner "
							+ invoice.getCustomer().getName()
							+ " for accounting schema "
							+ schema.getCode()
							+ ". Specify accounting settings at business partner account level or customer group level.");
		}
		line.setDbAccount(dbAccount.getCode());
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

			itemLine.setCrAccount(crAccount.getCode());
			itemLine.setCrAmount(tax.getTaxAmount());
			accDoc.addToLines(itemLine);
			
			totalCrAmount += itemLine.getCrAmount();
		}

		// product revenue
		for (SalesInvoiceItem item : invoice.getLines()) {

			Account crAccount = null;
			try {
				crAccount = getRevenueAccount(item.getProduct().getId(),
						invoice.getSupplier().getId(), schema.getId());
				if (crAccount == null) {
					throw new NoResultException();
				}
			} catch (NoResultException e) {
				throw new RuntimeException(
						"No revenue account found for product "
								+ item.getProduct().getCode()
								+ " for accounting schema "
								+ schema.getCode()
								+ ". Specify accounting settings at product account level or product account group level.");
			}

			AccDocLine itemLine = new AccDocLine();
			itemLine.setAccDoc(accDoc);

			itemLine.setCrAccount(crAccount.getCode());
			itemLine.setCrAmount(item.getNetAmount());
			accDoc.addToLines(itemLine);
			totalCrAmount += itemLine.getCrAmount();
		}
		
		accDoc.setCrAmount(totalCrAmount);
		accDoc.setDbAmount(totalDbAmount);
		
		return accDoc;
	}

	private Account getTaxAccount(Long taxId, Long organizationId,
			Long accSchemaId) throws Exception {

		ITaxAcctService acctService = (ITaxAcctService) this
				.findEntityService(TaxAcct.class);
		TaxAcct acct = acctService.findByTax_schema(taxId, accSchemaId);

		return acct.getSalesAccount();
	}

	private Account getSalesAccount(Long businessPartnerId,
			Long organizationId, Long accSchemaId) throws Exception {
		// try to get from the account
		IBpAccountService accountService = (IBpAccountService) this
				.findEntityService(BpAccount.class);
		BpAccount account = accountService.findByBp_org(businessPartnerId,
				organizationId);

		if (account == null) {

			// try to find the account for the generic organization ...
			// if not found raise error

		}

		IBpAccountAcctService acctService = (IBpAccountAcctService) this
				.findEntityService(BpAccountAcct.class);

		try {
			BpAccountAcct acct = acctService.findByAccount_schema(account
					.getId(), accSchemaId);

			if (acct.getCustSalesAccount() != null) {
				return acct.getCustSalesAccount();
			}
		} catch (NoResultException e) {
			// Ignore , no accounting data at account level , try at vendor
			// group level
		}

		// try to get from the vendor group
		CustomerGroup group = account.getCustGroup();
		ICustomerGroupAcctService groupAcctService = (ICustomerGroupAcctService) this
				.findEntityService(CustomerGroupAcct.class);
		CustomerGroupAcct groupAcct = groupAcctService.findByGroup_schema(group
				.getId(), accSchemaId);
		 
		return groupAcct.getSalesAccount();
		 
	}

	private Account getRevenueAccount(Long productId, Long organizationId,
			Long accSchemaId) throws Exception {
		// try to get from the account
		IProductAccountService accountService = (IProductAccountService) this
				.findEntityService(ProductAccount.class);
		ProductAccount account = accountService.findByProd_org(productId,
				organizationId);

		if (account == null) {

			// try to find the account for the generic organization ...
			// if not found raise error

		}

		IProductAccountAcctService acctService = (IProductAccountAcctService) this
				.findEntityService(ProductAccountAcct.class);
		ProductAccountAcct acct = acctService.findByAccount_schema(account
				.getId(), accSchemaId);

		if (acct.getRevenueAccount() != null) {
			return acct.getRevenueAccount();
		}
		// try to get from the customer group
		ProductAccountGroup group = account.getGroup();

		IProductAccountGroupAcctService groupAcctService = (IProductAccountGroupAcctService) this
				.findEntityService(ProductAccountGroupAcct.class);

		ProductAccountGroupAcct groupAcct = groupAcctService
				.findByGroup_schema(group.getId(), accSchemaId);
		 
		return groupAcct.getRevenueAccount();
		 
	}

}
