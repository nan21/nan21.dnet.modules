package net.nan21.dnet.module.md._businessdelegates.mm.prod;

import javax.persistence.NoResultException;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountAcctService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountGroupAcctService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAccountService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;

public class ProductExpenseAcctBD extends AbstractBusinessDelegate {

	public String getPostingAcct(Product product, Organization organization,
			AccSchema schema) throws Exception {
		IProductAccountService accountService = (IProductAccountService) this
				.findEntityService(ProductAccount.class);
		ProductAccount account = null;
		Account acct = null;
		try {
			account = accountService.findByProd_org(product.getId(),
					organization.getId());
			acct = null;
			if (account != null) {
				acct = this.findByAccount(account.getId(), schema.getId());
				if (acct == null) {
					ProductAccountGroup group = account.getGroup();
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
			if (account.getAnaliticSegment() != null
					&& !account.getAnaliticSegment().equals("")) {
				return acct.getCode() + "." + account.getAnaliticSegment();
			}
			// use a Product-level analytic segment ?
			return acct.getCode();
		}
		throw new RuntimeException(
				"No expense posting account found for product `"
						+ product.getCode()
						+ "` for accounting schema `"
						+ schema.getCode()
						+ "`. Specify accounting settings at product account level or product account group level.");

	}

	protected Account findByAccount(Long accountId, Long schemaId)
			throws Exception {
		IProductAccountAcctService acctService = (IProductAccountAcctService) this
				.findEntityService(ProductAccountAcct.class);

		ProductAccountAcct acct = null;
		try {
			acct = acctService.findByAccount_schema(accountId, schemaId);
			return acct.getExpenseAccount();
		} catch (NoResultException e) {
		}
		return null;
	}

	protected Account findByGroup(Long groupId, Long schemaId) throws Exception {
		IProductAccountGroupAcctService groupAcctService = (IProductAccountGroupAcctService) this
				.findEntityService(ProductAccountGroupAcct.class);
		ProductAccountGroupAcct groupAcct = groupAcctService
				.findByGroup_schema(groupId, schemaId);
		return groupAcct.getExpenseAccount();
	}
}
