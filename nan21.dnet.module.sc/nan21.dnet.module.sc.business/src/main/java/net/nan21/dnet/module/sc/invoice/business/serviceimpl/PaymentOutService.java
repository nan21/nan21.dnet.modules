/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;

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

}
