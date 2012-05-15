/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;
import net.nan21.dnet.module.sc._businessdelegates.invoice.PaymentOutToAccDocBD;

public class PaymentOutService extends AbstractEntityService<PaymentOut>
        implements IPaymentOutService {

    public PaymentOutService() {
        super();
    }

    public PaymentOutService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PaymentOut> getEntityClass() {
        return PaymentOut.class;
    }

    public void doPost(PaymentOut payment) throws Exception {
        this.getBusinessDelegate(PaymentOutToAccDocBD.class).post(payment);
    }

    public void doUnPost(PaymentOut payment) throws Exception {
        this.getBusinessDelegate(PaymentOutToAccDocBD.class).unPost(payment);
    }

}
