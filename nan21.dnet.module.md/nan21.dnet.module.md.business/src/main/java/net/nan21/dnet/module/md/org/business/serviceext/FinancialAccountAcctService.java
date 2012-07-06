/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceext;

import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountAcctService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

public class FinancialAccountAcctService
		extends
		net.nan21.dnet.module.md.org.business.serviceimpl.FinancialAccountAcctService
		implements IFinancialAccountAcctService {

	/**
	 * Get the posting account for deposit operations into the given financial
	 * account.
	 */
	public String getPostingDepositAcct(FinancialAccount financialAccount,
			AccSchema schema) throws Exception {
		FinancialAccountAcct acct = this.findByAccount_schema(financialAccount
				.getId(), schema.getId());
		if (acct != null && acct.getDepositAccount() != null) {
			if (financialAccount.getAnaliticSegment() != null) {
				return acct.getDepositAccount().getCode() + "."
						+ financialAccount.getAnaliticSegment();
			}
			return acct.getDepositAccount().getCode();
		}
		throw new RuntimeException(
				"No posting account found for financial account `"
						+ financialAccount.getName()
						+ "` for accounting schema `"
						+ schema.getCode()
						+ "`. Specify accounting settings at financial account level.");
	}

	/**
	 * Get the posting account for withdrawal operations from the given
	 * financial account.
	 */
	public String getPostingWithdrawalAcct(FinancialAccount financialAccount,
			AccSchema schema) throws Exception {
		FinancialAccountAcct acct = this.findByAccount_schema(financialAccount
				.getId(), schema.getId());
		if (acct != null && acct.getWithdrawalAccount() != null) {
			if (financialAccount.getAnaliticSegment() != null) {
				return acct.getWithdrawalAccount().getCode() + "."
						+ financialAccount.getAnaliticSegment();
			}
			return acct.getWithdrawalAccount().getCode();
		}
		throw new RuntimeException(
				"No posting account found for financial account `"
						+ financialAccount.getName()
						+ "` for accounting schema `"
						+ schema.getCode()
						+ "`. Specify accounting settings at financial account level.");
	}
}
