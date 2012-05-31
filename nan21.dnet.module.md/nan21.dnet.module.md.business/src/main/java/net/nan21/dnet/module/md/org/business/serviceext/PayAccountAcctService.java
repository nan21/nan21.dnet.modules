/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.business.serviceext;

import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.org.business.service.IPayAccountAcctService;
import net.nan21.dnet.module.md.org.domain.entity.PayAccount;
import net.nan21.dnet.module.md.org.domain.entity.PayAccountAcct;

public class PayAccountAcctService extends
		net.nan21.dnet.module.md.org.business.serviceimpl.PayAccountAcctService
		implements IPayAccountAcctService {

	/**
	 * Get the posting account for deposit operations into the given financial
	 * account.
	 */
	public String getPostingDepositAcct(PayAccount payAccount, AccSchema schema)
			throws Exception {
		PayAccountAcct acct = this.findByAccount_schema(payAccount.getId(),
				schema.getId());
		if (acct != null && acct.getDepositAccount() != null) {
			if (payAccount.getAnaliticSegment() != null) {
				return acct.getDepositAccount().getCode() + "."
						+ payAccount.getAnaliticSegment();
			}
			return acct.getDepositAccount().getCode();
		}
		throw new RuntimeException(
				"No posting account found for financial account `"
						+ payAccount.getName()
						+ "` for accounting schema `"
						+ schema.getCode()
						+ "`. Specify accounting settings at financial account level.");
	}

	/**
	 * Get the posting account for withdrawal operations into the given
	 * financial account.
	 */
	public String getPostingWithdrawalAcct(PayAccount payAccount,
			AccSchema schema) throws Exception {
		PayAccountAcct acct = this.findByAccount_schema(payAccount.getId(),
				schema.getId());
		if (acct != null && acct.getWithdrawalAccount() != null) {
			if (payAccount.getAnaliticSegment() != null) {
				return acct.getWithdrawalAccount().getCode() + "."
						+ payAccount.getAnaliticSegment();
			}
			return acct.getWithdrawalAccount().getCode();
		}
		throw new RuntimeException(
				"No posting account found for financial account `"
						+ payAccount.getName()
						+ "` for accounting schema `"
						+ schema.getCode()
						+ "`. Specify accounting settings at financial account level.");
	}
}
