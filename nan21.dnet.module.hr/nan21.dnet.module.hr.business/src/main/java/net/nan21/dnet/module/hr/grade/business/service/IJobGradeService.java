/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

import net.nan21.dnet.module.hr.grade.domain.entity.JobGrade;

public interface IJobGradeService extends IEntityService<JobGrade> {

    public List<JobGrade> findByJob(Job job);

    public List<JobGrade> findByJobId(Long jobId);

    public List<JobGrade> findByGrade(Grade grade);

    public List<JobGrade> findByGradeId(Long gradeId);

}
