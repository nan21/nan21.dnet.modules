/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IGradePayScaleService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;

public class GradePayScaleService extends AbstractEntityService<GradePayScale>
        implements IGradePayScaleService {

    public GradePayScaleService() {
        super();
    }

    public GradePayScaleService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<GradePayScale> getEntityClass() {
        return GradePayScale.class;
    }

    public List<GradePayScale> findByGrade(Grade grade) {
        return this.findByGradeId(grade.getId());
    }

    public List<GradePayScale> findByGradeId(Long gradeId) {
        return (List<GradePayScale>) this.em
                .createQuery(
                        "select e from GradePayScale e where e.grade.id = :pGradeId",
                        GradePayScale.class).setParameter("pGradeId", gradeId)
                .getResultList();
    }

    public List<GradePayScale> findByPayScale(PayScale payScale) {
        return this.findByPayScaleId(payScale.getId());
    }

    public List<GradePayScale> findByPayScaleId(Long payScaleId) {
        return (List<GradePayScale>) this.em
                .createQuery(
                        "select e from GradePayScale e where e.payScale.id = :pPayScaleId",
                        GradePayScale.class)
                .setParameter("pPayScaleId", payScaleId).getResultList();
    }

    public List<GradePayScale> findByCeiling(PayScalePoint ceiling) {
        return this.findByCeilingId(ceiling.getId());
    }

    public List<GradePayScale> findByCeilingId(Long ceilingId) {
        return (List<GradePayScale>) this.em
                .createQuery(
                        "select e from GradePayScale e where e.ceiling.id = :pCeilingId",
                        GradePayScale.class)
                .setParameter("pCeilingId", ceilingId).getResultList();
    }

}
