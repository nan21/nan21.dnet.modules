/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;

public interface IPaymentOutService extends IEntityService<PaymentOut> {

    public void doPost(PaymentOut payment) throws Exception;

    public void doUnPost(PaymentOut payment) throws Exception;

}
