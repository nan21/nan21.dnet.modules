/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

import net.nan21.dnet.module.hr.grade.domain.entity.PositionGrade;

public interface IPositionGradeService extends IEntityService<PositionGrade> {

    public List<PositionGrade> findByPosition(Position position);

    public List<PositionGrade> findByPositionId(Long positionId);

    public List<PositionGrade> findByGrade(Grade grade);

    public List<PositionGrade> findByGradeId(Long gradeId);

}
