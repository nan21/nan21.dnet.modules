/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;

import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentAmount;

public interface IPaymentAmountService extends IEntityService<PaymentAmount> {

    public List<PaymentAmount> findByPayment(Payment payment);

    public List<PaymentAmount> findByPaymentId(Long paymentId);

}
