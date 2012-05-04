package net.nan21.dnet.module.sc._businessdelegates.invoice;

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
import net.nan21.dnet.module.md.bp.business.service.IVendorGroupAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountAcctService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountGroupAcctService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;

public class PurchaseInvoiceToAccDocBD extends AbstractBusinessDelegate {

	public void unPostInvoice(PurchaseInvoice invoice) throws Exception {
		this.em.createQuery(
				"delete from AccDoc t " + " where t.docUuid = :invoiceUuid")
				.setParameter("invoiceUuid", invoice.getUuid()).executeUpdate();
		invoice.setPosted(false);
		this.em.merge(invoice);
	}

	public List<AccDoc> postInvoice(PurchaseInvoice invoice) throws Exception {
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

	protected AccDoc generateAccDoc(PurchaseInvoice invoice, AccSchema schema)
			throws Exception {
		Float totalCrAmount = 0F;
		Float totalDbAmount = 0F;

		AccDoc accDoc = new AccDoc();
		accDoc.setDocDate(invoice.getDocDate());
		accDoc.setOrg(invoice.getCustomer());
		accDoc.setAccSchema(schema);
		accDoc.setDocUuid(invoice.getUuid());
		accDoc.setDocType(invoice.getDocType());
		// vendor liability
		AccDocLine line = new AccDocLine();
		line.setAccDoc(accDoc);
		line.setCrAmount(invoice.getTotalAmount());

		Account crAccount = null;
		try {
			crAccount = this.getPurchaseAccount(invoice.getSupplier().getId(),
					invoice.getCustomer().getId(), schema.getId());
			if (crAccount == null) {
				throw new NoResultException();
			}
		} catch (NoResultException e) {
			throw new RuntimeException(
					"No purchase account found for business partner "
							+ invoice.getSupplier().getName()
							+ " for accounting schema "
							+ schema.getCode()
							+ ". Specify accounting settings at business partner account level or vendor group level.");
		}
		line.setCrAccount(crAccount.getCode());
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

			itemLine.setDbAccount(dbAccount.getCode());
			itemLine.setDbAmount(tax.getTaxAmount());
			accDoc.addToLines(itemLine);
			totalDbAmount += itemLine.getDbAmount();
		}

		// product expense
		for (PurchaseInvoiceItem item : invoice.getLines()) {

			Account dbAccount = null;
			try {
				dbAccount = getExpenseAccount(item.getProduct().getId(),
						invoice.getCustomer().getId(), schema.getId());
				if (dbAccount == null) {
					throw new NoResultException();
				}
			} catch (NoResultException e) {
				throw new RuntimeException(
						"No expense account found for product "
								+ item.getProduct().getCode()
								+ " for accounting schema "
								+ schema.getCode()
								+ ". Specify accounting settings at product account level or product account group level.");
			}

			AccDocLine itemLine = new AccDocLine();
			itemLine.setAccDoc(accDoc);

			itemLine.setDbAccount(dbAccount.getCode());
			itemLine.setDbAmount(item.getNetAmount());
			accDoc.addToLines(itemLine);
			totalDbAmount += itemLine.getDbAmount();
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

		return acct.getPurchaseAccount();
	}

	private Account getPurchaseAccount(Long businessPartnerId,
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

			if (acct.getVendorPurchaseAccount() != null) {
				return acct.getVendorPurchaseAccount();
			}
		} catch (NoResultException e) {
			// Ignore , no accounting data at account level , try at vendor
			// group level
		}

		// try to get from the vendor group
		VendorGroup group = account.getVendGroup();
		IVendorGroupAcctService groupAcctService = (IVendorGroupAcctService) this
				.findEntityService(VendorGroupAcct.class);
		VendorGroupAcct groupAcct = groupAcctService.findByGroup_schema(group
				.getId(), accSchemaId);
		return groupAcct.getPurchaseAccount();

	}

	private Account getExpenseAccount(Long productId, Long organizationId,
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

		if (acct.getExpenseAccount() != null) {
			return acct.getExpenseAccount();
		}
		// try to get from the vendor group
		ProductAccountGroup group = account.getGroup();

		IProductAccountGroupAcctService groupAcctService = (IProductAccountGroupAcctService) this
				.findEntityService(ProductAccountGroupAcct.class);

		ProductAccountGroupAcct groupAcct = groupAcctService
				.findByGroup_schema(group.getId(), accSchemaId);

		return groupAcct.getExpenseAccount();

	}

}