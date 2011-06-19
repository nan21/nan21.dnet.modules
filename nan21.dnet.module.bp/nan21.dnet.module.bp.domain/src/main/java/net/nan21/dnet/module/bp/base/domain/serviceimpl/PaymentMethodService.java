/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.domain.serviceimpl;

import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bp.base.domain.service.IPaymentMethodService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.base.domain.entity.PaymentMethod;

public class PaymentMethodService extends AbstractEntityService<PaymentMethod>
        implements IPaymentMethodService {

    public PaymentMethodService() {
        super();
    }

    public PaymentMethodService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PaymentMethod> getEntityClass() {
        return PaymentMethod.class;
    }

    public PaymentMethod findByName(Long clientId, String name) {
        return (PaymentMethod) this.em
                .createNamedQuery(PaymentMethod.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}
