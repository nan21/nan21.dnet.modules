/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScalePoint;

public interface IGradePayScalePointService extends
        IEntityService<GradePayScalePoint> {

    public List<GradePayScalePoint> findByGradePayScale(
            GradePayScale gradePayScale);

    public List<GradePayScalePoint> findByGradePayScaleId(Long gradePayScaleId);

    public List<GradePayScalePoint> findByPoint(PayScalePoint point);

    public List<GradePayScalePoint> findByPointId(Long pointId);

}
