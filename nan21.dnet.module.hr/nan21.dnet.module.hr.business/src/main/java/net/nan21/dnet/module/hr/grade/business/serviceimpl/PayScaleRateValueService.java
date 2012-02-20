/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IPayScaleRateValueService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;

public class PayScaleRateValueService extends
        AbstractEntityService<PayScaleRateValue> implements
        IPayScaleRateValueService {

    public PayScaleRateValueService() {
        super();
    }

    public PayScaleRateValueService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayScaleRateValue> getEntityClass() {
        return PayScaleRateValue.class;
    }

    public List<PayScaleRateValue> findByScaleRate(PayScaleRate scaleRate) {
        return this.findByScaleRateId(scaleRate.getId());
    }

    public List<PayScaleRateValue> findByScaleRateId(Long scaleRateId) {
        return (List<PayScaleRateValue>) this.em
                .createQuery(
                        "select e from PayScaleRateValue e where e.clientId = :pClientId and e.scaleRate.id = :pScaleRateId",
                        PayScaleRateValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pScaleRateId", scaleRateId).getResultList();
    }

    public List<PayScaleRateValue> findByScalePoint(PayScalePoint scalePoint) {
        return this.findByScalePointId(scalePoint.getId());
    }

    public List<PayScaleRateValue> findByScalePointId(Long scalePointId) {
        return (List<PayScaleRateValue>) this.em
                .createQuery(
                        "select e from PayScaleRateValue e where e.clientId = :pClientId and e.scalePoint.id = :pScalePointId",
                        PayScaleRateValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pScalePointId", scalePointId).getResultList();
    }

}
