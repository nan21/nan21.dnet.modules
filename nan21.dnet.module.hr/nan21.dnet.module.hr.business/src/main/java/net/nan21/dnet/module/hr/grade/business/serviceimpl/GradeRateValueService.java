/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IGradeRateValueService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRateValue;

public class GradeRateValueService extends
        AbstractEntityService<GradeRateValue> implements IGradeRateValueService {

    public GradeRateValueService() {
        super();
    }

    public GradeRateValueService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<GradeRateValue> getEntityClass() {
        return GradeRateValue.class;
    }

    public List<GradeRateValue> findByGradeRate(GradeRate gradeRate) {
        return this.findByGradeRateId(gradeRate.getId());
    }

    public List<GradeRateValue> findByGradeRateId(Long gradeRateId) {
        return (List<GradeRateValue>) this.em
                .createQuery(
                        "select e from GradeRateValue e where e.clientId = :pClientId and  e.gradeRate.id = :pGradeRateId",
                        GradeRateValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGradeRateId", gradeRateId).getResultList();
    }

    public List<GradeRateValue> findByGrade(Grade grade) {
        return this.findByGradeId(grade.getId());
    }

    public List<GradeRateValue> findByGradeId(Long gradeId) {
        return (List<GradeRateValue>) this.em
                .createQuery(
                        "select e from GradeRateValue e where e.clientId = :pClientId and  e.grade.id = :pGradeId",
                        GradeRateValue.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pGradeId", gradeId).getResultList();
    }

}
