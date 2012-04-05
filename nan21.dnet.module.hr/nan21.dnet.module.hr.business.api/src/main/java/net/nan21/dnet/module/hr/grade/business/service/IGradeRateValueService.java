/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

import net.nan21.dnet.module.hr.grade.domain.entity.GradeRateValue;

public interface IGradeRateValueService extends IEntityService<GradeRateValue> {

    public List<GradeRateValue> findByGradeRate(GradeRate gradeRate);

    public List<GradeRateValue> findByGradeRateId(Long gradeRateId);

    public List<GradeRateValue> findByGrade(Grade grade);

    public List<GradeRateValue> findByGradeId(Long gradeId);

}
