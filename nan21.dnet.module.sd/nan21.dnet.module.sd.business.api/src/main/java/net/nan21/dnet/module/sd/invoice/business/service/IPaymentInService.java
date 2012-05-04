/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;

public interface IPaymentInService extends IEntityService<PaymentIn> {

    public void doPost(PaymentIn payment) throws Exception;

    public void doUnPost(PaymentIn payment) throws Exception;

}
