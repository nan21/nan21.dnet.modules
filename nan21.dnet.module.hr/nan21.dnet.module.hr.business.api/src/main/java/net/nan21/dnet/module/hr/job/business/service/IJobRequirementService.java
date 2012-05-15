/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

import net.nan21.dnet.module.hr.job.domain.entity.JobRequirement;

public interface IJobRequirementService extends IEntityService<JobRequirement> {

    public List<JobRequirement> findByJob(Job job);

    public List<JobRequirement> findByJobId(Long jobId);

    public List<JobRequirement> findByRequirement(WorkRequirement requirement);

    public List<JobRequirement> findByRequirementId(Long requirementId);

}
