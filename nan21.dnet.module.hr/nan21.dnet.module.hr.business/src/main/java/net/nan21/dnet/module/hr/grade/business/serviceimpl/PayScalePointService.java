/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IPayScalePointService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

public class PayScalePointService extends AbstractEntityService<PayScalePoint>
        implements IPayScalePointService {

    public PayScalePointService() {
        super();
    }

    public PayScalePointService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PayScalePoint> getEntityClass() {
        return PayScalePoint.class;
    }

    public PayScalePoint findByScale_code(PayScale payScale, String code) {
        return (PayScalePoint) this.em
                .createNamedQuery(PayScalePoint.NQ_FIND_BY_SCALE_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayScale", payScale)
                .setParameter("pCode", code).getSingleResult();
    }

    public PayScalePoint findByScale_code(Long payScaleId, String code) {
        return (PayScalePoint) this.em
                .createNamedQuery(PayScalePoint.NQ_FIND_BY_SCALE_CODE_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayScaleId", payScaleId)
                .setParameter("pCode", code).getSingleResult();
    }

    public List<PayScalePoint> findByPayScale(PayScale payScale) {
        return this.findByPayScaleId(payScale.getId());
    }

    public List<PayScalePoint> findByPayScaleId(Long payScaleId) {
        return (List<PayScalePoint>) this.em
                .createQuery(
                        "select e from PayScalePoint e where e.clientId = :pClientId and  e.payScale.id = :pPayScaleId",
                        PayScalePoint.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pPayScaleId", payScaleId).getResultList();
    }

}
