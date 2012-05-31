/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceext;

import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.CronScheduleBuilder.cronSchedule;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

import net.nan21.dnet.core.api.job.IScheduler;
import net.nan21.dnet.module.ad.system.business.service.ISysTimerService;
import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;

public class SysTimerService extends
		net.nan21.dnet.module.ad.system.business.serviceimpl.SysTimerService
		implements ISysTimerService {

	private IScheduler scheduler;

	@Override
	protected void postInsert(SysTimer e) throws Exception {
		try {
			Scheduler s = this.getQuartzScheduler();
			JobDetail jobDetail = s.getJobDetail(JobKey.jobKey(e.getJobCtx()
					.getId().toString(), e.getJobCtx().getClientId().toString()));

			Trigger newTrigger = this.createQuartzTrigger(e, jobDetail);

			getQuartzScheduler().scheduleJob(newTrigger);

		} catch (Exception ex) {
			throw new RuntimeException("Cannot create timer. Reason: "
					+ ex.getMessage());
		}

	}

	@Override
	protected void postUpdate(SysTimer e) throws Exception {
		try {
			Scheduler s = this.getQuartzScheduler();
			Trigger oldTrigger = s.getTrigger(TriggerKey.triggerKey(
					e.getId().toString(), e.getClientId().toString()));
			JobDetail jobDetail = s.getJobDetail(JobKey.jobKey(e.getJobCtx()
					.getId().toString(), e.getJobCtx().getClientId().toString()));

			Trigger newTrigger = this.createQuartzTrigger(e, jobDetail);

			if (oldTrigger == null) {
				getQuartzScheduler().scheduleJob(newTrigger);
			} else {
				getQuartzScheduler().rescheduleJob(
						TriggerKey.triggerKey(e.getId().toString(), e.getClientId()
								.toString()), newTrigger);
			}

		} catch (Exception ex) {
			throw new RuntimeException("Cannot create timer. Reason: "
					+ ex.getMessage());
		}

	}

	protected Trigger createQuartzTrigger(SysTimer e, JobDetail jobDetail) {
		Trigger newTrigger = null;
		if (e.getType() != null && e.getType().equals("simple")) {

			SimpleScheduleBuilder sb = simpleSchedule().withRepeatCount(
					e.getRepeatCount());

			if (e.getRepeatIntervalType().equals("seconds")) {
				sb = sb.withIntervalInSeconds(e.getRepeatInterval());
			}
			if (e.getRepeatIntervalType().equals("minutes")) {
				sb = sb.withIntervalInMinutes(e.getRepeatInterval());
			}
			if (e.getRepeatIntervalType().equals("hours")) {
				sb = sb.withIntervalInHours(e.getRepeatInterval());
			}

			newTrigger = (SimpleTrigger) newTrigger().withIdentity(e.getId().toString(),
					e.getClientId().toString()).startAt(e.getStartTime())
					.endAt(e.getEndTime()).withSchedule(sb).forJob(jobDetail)
					.build();

		} else if (e.getType().equals("cron")) {
			newTrigger = (CronTrigger) newTrigger().withIdentity(e.getId().toString(),
					e.getClientId().toString()).startAt(e.getStartTime())
					.endAt(e.getEndTime()).withSchedule(
							cronSchedule(e.getCronExpression())).forJob(
							jobDetail).build();
		}
		return newTrigger;
	}

	protected Scheduler getQuartzScheduler() throws Exception {
		if (this.scheduler == null) {
			this.scheduler = (IScheduler) this.getAppContext().getBean(
					"osgiJobScheduler");
		}
		return (Scheduler) this.scheduler.getDelegate();
	}
}
