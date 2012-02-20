/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bp.base.business.service.IPaymentMethodService;

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

    public PaymentMethod findByName(String name) {
        return (PaymentMethod) this.em
                .createNamedQuery(PaymentMethod.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
