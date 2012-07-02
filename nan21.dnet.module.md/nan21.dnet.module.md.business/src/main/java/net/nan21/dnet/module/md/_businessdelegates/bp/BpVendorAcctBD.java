package net.nan21.dnet.module.md._businessdelegates.bp;

import javax.persistence.NoResultException;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountAcctService;
import net.nan21.dnet.module.md.bp.business.service.IBpAccountService;
import net.nan21.dnet.module.md.bp.business.service.IVendorGroupAcctService;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

public class BpVendorAcctBD extends AbstractBusinessDelegate {

	public String getPostingAcct(BusinessPartner businessPartner,
			Organization organization, AccSchema schema) throws Exception {
		IBpAccountService accountService = (IBpAccountService) this
				.findEntityService(BpAccount.class);
		BpAccount account = null;
		Account acct = null;
		try {
			account = accountService.findByBp_org(businessPartner.getId(),
					organization.getId());
			acct = null;
			if (account != null) {
				acct = this.findByAccount(account.getId(), schema.getId());
				if (acct == null) {
					VendorGroup group = account.getVendGroup();
					if (group != null) {
						acct = this.findByGroup(group.getId(), schema.getId());
					}
				}
			}
		} catch (NoResultException e) {
			// ignore, we'll throw later
		}

		{
			// try to find some generic purchase account from a default
			// organization or accounting schema level defaults, etc ...
			// if nothing found raise an error or just return null (TBA)
		}
		if (acct != null && account != null) {
			if (account.getVendAnaliticSegment() != null && !account.getVendAnaliticSegment().equals("")) {
				return acct.getCode() + "." + account.getVendAnaliticSegment();
			} else if (account.getAnaliticSegment() != null && !account.getAnaliticSegment().equals("")) {
				return acct.getCode() + "." + account.getAnaliticSegment();
			}
			return acct.getCode();
		}
		throw new RuntimeException(
				"No posting account found for business partner `"
						+ businessPartner.getName()
						+ "` for accounting schema `"
						+ schema.getCode()
						+ "`. Specify accounting settings at business partner account level or vendor group level.");

	}

	/**
	 * find root posting account at business partner account level.
	 * 
	 * @param accountId
	 * @param schemaId
	 * @return
	 * @throws Exception
	 */
	protected Account findByAccount(Long accountId, Long schemaId)
			throws Exception {
		IBpAccountAcctService acctService = (IBpAccountAcctService) this
				.findEntityService(BpAccountAcct.class);
		BpAccountAcct acct = null;
		try {
			acct = acctService.findByAccount_schema(accountId, schemaId);
			return acct.getVendorPurchaseAccount();
		} catch (NoResultException e) {
		}
		return null;
	}

	/**
	 * find root posting account at group level.
	 * 
	 * @param groupId
	 * @param schemaId
	 * @return
	 * @throws Exception
	 */
	protected Account findByGroup(Long groupId, Long schemaId) throws Exception {
		IVendorGroupAcctService groupAcctService = (IVendorGroupAcctService) this
				.findEntityService(VendorGroupAcct.class);
		VendorGroupAcct groupAcct = groupAcctService.findByGroup_schema(
				groupId, schemaId);
		return groupAcct.getPurchaseAccount();
	}

}
