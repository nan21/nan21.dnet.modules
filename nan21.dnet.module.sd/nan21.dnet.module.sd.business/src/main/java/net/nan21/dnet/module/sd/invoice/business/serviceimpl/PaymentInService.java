/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;

public class PaymentInService extends AbstractEntityService<PaymentIn>
        implements IPaymentInService {

    public PaymentInService() {
        super();
    }

    public PaymentInService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PaymentIn> getEntityClass() {
        return PaymentIn.class;
    }

}
