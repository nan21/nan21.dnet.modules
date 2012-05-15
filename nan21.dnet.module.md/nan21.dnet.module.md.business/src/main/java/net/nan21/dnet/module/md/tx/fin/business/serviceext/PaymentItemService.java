/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.serviceext;

import net.nan21.dnet.module.md.tx.fin.business.service.IPaymentItemService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

public class PaymentItemService extends
		net.nan21.dnet.module.md.tx.fin.business.serviceimpl.PaymentItemService
		implements IPaymentItemService {

	@Override
	protected void preInsert(PaymentItem e) throws Exception {
		// this.applyEntryModePreSave(e);
	}

	@Override
	protected void preUpdate(PaymentItem e) throws Exception {
		// this.applyEntryModePreSave(e);
	}

}
