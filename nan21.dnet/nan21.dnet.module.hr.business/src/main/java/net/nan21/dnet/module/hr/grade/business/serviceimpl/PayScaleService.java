/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IPayScaleService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

public class PayScaleService extends AbstractEntityService<PayScale> implements
        IPayScaleService {

    public PayScaleService() {
        super();
    }

    public PayScaleService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayScale> getEntityClass() {
        return PayScale.class;
    }

    public PayScale findByCode(Long clientId, String code) {
        return (PayScale) this.em.createNamedQuery(PayScale.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public PayScale findByName(Long clientId, String name) {
        return (PayScale) this.em.createNamedQuery(PayScale.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

}