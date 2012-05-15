/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.acc.business.serviceext;

import net.nan21.dnet.module.bd.acc.business.service.IAccItemAcctService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccItem;
import net.nan21.dnet.module.bd.acc.domain.entity.AccItemAcct;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;

public class AccItemAcctService extends
		net.nan21.dnet.module.bd.acc.business.serviceimpl.AccItemAcctService
		implements IAccItemAcctService {

	public String getDbPostingAcct(AccItem accItem, AccSchema accSchema) {
		AccItemAcct acct = this.findByItem_schema(accItem.getId(), accSchema
				.getId());
		if (acct != null && acct.getDbAccount() != null) {
			return acct.getDbAccount().getCode();
		}
		throw new RuntimeException(
				"No debit posting account found for G/L item `"
						+ accItem.getName()
						+ "` for accounting schema `"
						+ accSchema.getCode()
						+ "`. Specify accounting settings at product account level or product account group level.");

	}

	public String getCrPostingAcct(AccItem accItem, AccSchema accSchema) {
		AccItemAcct acct = this.findByItem_schema(accItem.getId(), accSchema
				.getId());
		if (acct != null && acct.getCrAccount() != null) {
			return acct.getCrAccount().getCode();
		}
		throw new RuntimeException(
				"No credit posting account found for G/L item `"
						+ accItem.getName()
						+ "` for accounting schema `"
						+ accSchema.getCode()
						+ "`. Specify accounting settings at product account level or product account group level.");

	}
}
