/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.service.IPositionGradeService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.grade.domain.entity.PositionGrade;

public class PositionGradeService extends AbstractEntityService<PositionGrade>
        implements IPositionGradeService {

    public PositionGradeService() {
        super();
    }

    public PositionGradeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<PositionGrade> getEntityClass() {
        return PositionGrade.class;
    }

    public List<PositionGrade> findByPosition(Position position) {
        return this.findByPositionId(position.getId());
    }

    public List<PositionGrade> findByPositionId(Long positionId) {
        return (List<PositionGrade>) this.em
                .createQuery(
                        "select e from PositionGrade where e.position.id = :pPositionId",
                        PositionGrade.class)
                .setParameter("pPositionId", positionId).getResultList();
    }

    public List<PositionGrade> findByGrade(Grade grade) {
        return this.findByGradeId(grade.getId());
    }

    public List<PositionGrade> findByGradeId(Long gradeId) {
        return (List<PositionGrade>) this.em
                .createQuery(
                        "select e from PositionGrade where e.grade.id = :pGradeId",
                        PositionGrade.class).setParameter("pGradeId", gradeId)
                .getResultList();
    }

}
