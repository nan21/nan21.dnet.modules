/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IGradePayScalePointService;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
 
import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScalePoint;

public class GradePayScalePointService extends
        AbstractEntityService<GradePayScalePoint> implements
        IGradePayScalePointService {

    public GradePayScalePointService() {
        super();
    }

    public GradePayScalePointService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<GradePayScalePoint> getEntityClass() {
        return GradePayScalePoint.class;
    }

    public List<GradePayScalePoint> findByGradePayScale(
            GradePayScale gradePayScale) {
        return this.findByGradePayScaleId(gradePayScale.getId());
    }

    public List<GradePayScalePoint> findByGradePayScaleId(Long gradePayScaleId) {
        return (List<GradePayScalePoint>) this.em
                .createQuery(
                        "select e from GradePayScalePoint where e.gradePayScale.id = :pGradePayScaleId",
                        GradePayScalePoint.class)
                .setParameter("pGradePayScaleId", gradePayScaleId)
                .getResultList();
    }

    public List<GradePayScalePoint> findByPoint(PayScalePoint point) {
        return this.findByPointId(point.getId());
    }

    public List<GradePayScalePoint> findByPointId(Long pointId) {
        return (List<GradePayScalePoint>) this.em
                .createQuery(
                        "select e from GradePayScalePoint where e.point.id = :pPointId",
                        GradePayScalePoint.class)
                .setParameter("pPointId", pointId).getResultList();
    }

}
