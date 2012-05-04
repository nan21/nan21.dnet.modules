package net.nan21.dnet.module.sc._businessdelegates.invoice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.acc.business.service.IAccSchemaService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountAcctService;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountService;
import net.nan21.dnet.module.md.bp.business.service.IVendorGroupAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;
import net.nan21.dnet.module.md.org.business.service.IPayAccountAcctService;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;
import net.nan21.dnet.module.md.org.domain.entity.PayAccountAcct;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;

public class PaymentOutToAccDocBD extends AbstractBusinessDelegate {

	public void unPostInvoice(PaymentOut payment) throws Exception {
		this.em.createQuery(
				"delete from AccDoc t " + " where t.docUuid = :invoiceUuid")
				.setParameter("invoiceUuid", payment.getUuid()).executeUpdate();
		payment.setPosted(false);
		this.em.merge(payment);
	}

	public List<AccDoc> postInvoice(PaymentOut payment) throws Exception {
		List<AccDoc> result = new ArrayList<AccDoc>();
		// get org schemas , for each schema generate an acc-doc
		IAccSchemaService srv = (IAccSchemaService) this
				.findEntityService(AccSchema.class);
		List<AccSchema> schemas = srv.findAll();
		for (AccSchema schema : schemas) {
			AccDoc doc = this.generateAccDoc(payment, schema);
			result.add(doc);
			this.em.persist(doc);
		}
		payment.setPosted(true);
		this.em.merge(payment);
		return result;
	}

	protected AccDoc generateAccDoc(PaymentOut payment, AccSchema schema)
			throws Exception {

		AccDoc accDoc = new AccDoc();
		accDoc.setDocDate(payment.getDocDate());
		accDoc.setDocNo(payment.getDocNo());
		accDoc.setOrg(payment.getFromOrg());
		accDoc.setAccSchema(schema);
		accDoc.setDocUuid(payment.getUuid());
		accDoc.setDocType(payment.getPaymentMethod().getDocType());
		// vendor liability
		AccDocLine line = new AccDocLine();
		line.setAccDoc(accDoc);		 
		Account dbAccount = null;
		try {
			dbAccount = this.getPurchaseAccount(payment.getBpartner().getId(),
					payment.getFromOrg().getId(), schema.getId());
			if (dbAccount == null) {
				throw new NoResultException();
			}
		} catch (NoResultException e) {
			throw new RuntimeException(
					"No purchase account found for business partner "
							+ payment.getBpartner().getName()
							+ " for accounting schema "
							+ schema.getCode()
							+ ". Specify accounting settings at business partner account level or vendor group level.");
		}
		line.setDbAccount(dbAccount.getCode());
		line.setDbAmount(payment.getAmount());
		accDoc.setDbAmount(line.getDbAmount());
		accDoc.addToLines(line);
		
		// 
		
		line = new AccDocLine();
		
		Account crAccount = null;
		try {
			crAccount = this.getPayAccount(payment.getFromAccount(), schema
					.getId());
			if (crAccount == null) {
				throw new NoResultException();
			}
		} catch (NoResultException e) {
			throw new RuntimeException(
					"No payment account found for financial account "
							+ payment.getFromAccount().getName()
							+ " for accounting schema "
							+ schema.getCode()
							+ ". Specify accounting settings at financial account level.");
		}
		line.setCrAccount(crAccount.getCode());
		line.setCrAmount(payment.getAmount());
		accDoc.setCrAmount(line.getCrAmount());
		accDoc.addToLines(line);
		 		
		return accDoc;
	}

	private Account getPayAccount(PayAccount account, Long accSchemaId)
			throws Exception {
		IPayAccountAcctService acctService = (IPayAccountAcctService) this
				.findEntityService(PayAccountAcct.class);

		PayAccountAcct acct = acctService.findByAccount_schema(account.getId(),
				accSchemaId);
		return acct.getWithdrawalAccount();
		 
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
		if (groupAcct.getPurchaseAccount() != null) {
			return groupAcct.getPurchaseAccount();
		}
		return null;
	}

}
