/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

import net.nan21.dnet.module.hr.job.domain.entity.Job;

public interface IJobService extends IEntityService<Job> {

    public Job findByCode(String code);

    public Job findByName(String name);

    public List<Job> findByJobType(JobType jobType);

    public List<Job> findByJobTypeId(Long jobTypeId);

}
