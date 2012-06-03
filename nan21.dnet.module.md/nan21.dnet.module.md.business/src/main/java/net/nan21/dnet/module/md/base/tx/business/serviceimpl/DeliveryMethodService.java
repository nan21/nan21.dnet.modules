/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.business.service.IDeliveryMethodService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;

public class DeliveryMethodService extends
        AbstractEntityService<DeliveryMethod> implements IDeliveryMethodService {

    public DeliveryMethodService() {
        super();
    }

    public DeliveryMethodService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<DeliveryMethod> getEntityClass() {
        return DeliveryMethod.class;
    }

    public DeliveryMethod findByName(String name) {
        return (DeliveryMethod) this.em
                .createNamedQuery(DeliveryMethod.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
