/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceext;

import org.quartz.JobDetail;
import org.quartz.Scheduler;

import net.nan21.dnet.core.api.job.IScheduler;
import net.nan21.dnet.core.scheduler.JobDetailBase;
import net.nan21.dnet.module.ad.system.business.service.ISysJobCtxService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

import static org.quartz.JobBuilder.*;

public class SysJobCtxService extends
		net.nan21.dnet.module.ad.system.business.serviceimpl.SysJobCtxService
		implements ISysJobCtxService {

	private IScheduler scheduler;

	@Override
	protected void postUpdate(SysJobCtx e) throws Exception {
		JobDetail jobDetail = newJob(JobDetailBase.class).withIdentity(
				e.getId().toString(), e.getClientId().toString()).storeDurably().build();
		jobDetail.getJobDataMap().put("__JOB_NAME__",
				e.getJobAlias());
		getQuartzScheduler().addJob(jobDetail, true);
	}

	@Override
	protected void postInsert(SysJobCtx e) throws Exception {
		JobDetail jobDetail = newJob(JobDetailBase.class).withIdentity(
				e.getId().toString(), e.getClientId().toString()).storeDurably().build();
		jobDetail.getJobDataMap().put("__JOB_NAME__",
				e.getJobAlias());
		getQuartzScheduler().addJob(jobDetail, false);
	}

	protected Scheduler getQuartzScheduler() throws Exception {
		if (this.scheduler == null) {
			this.scheduler = (IScheduler) this.getAppContext().getBean(
					"osgiJobScheduler");
		}
		return (Scheduler) this.scheduler.getDelegate();
	}
}
