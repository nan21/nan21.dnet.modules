/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;

public interface IGradePayScaleService extends IEntityService<GradePayScale> {

    public List<GradePayScale> findByGrade(Grade grade);

    public List<GradePayScale> findByGradeId(Long gradeId);

    public List<GradePayScale> findByPayScale(PayScale payScale);

    public List<GradePayScale> findByPayScaleId(Long payScaleId);

    public List<GradePayScale> findByCeiling(PayScalePoint ceiling);

    public List<GradePayScale> findByCeilingId(Long ceilingId);

}
