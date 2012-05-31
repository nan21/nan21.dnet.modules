/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** QuartzTrigger. */
@Entity
@Table(name = QuartzTrigger.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({})
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzTrigger {

    public static final String TABLE_NAME = "XT_QRTZ_TRIGGERS";
    public static final String SEQUENCE_NAME = "XT_QRTZ_TRIGGERS_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /** SchedulerName. */
    @Column(name = "SCHED_NAME", nullable = false, length = 255)
    @NotBlank
    @Id
    private String schedulerName;

    /** TriggerName. */
    @Column(name = "TRIGGER_NAME", nullable = false, length = 255)
    @NotBlank
    @Id
    private String triggerName;

    /** TriggerGroup. */
    @Column(name = "TRIGGER_GROUP", nullable = false, length = 255)
    @NotBlank
    @Id
    private String triggerGroup;

    /** JobName. */
    @Column(name = "JOB_NAME", nullable = false, length = 255)
    @NotBlank
    private String jobName;

    /** JobGroup. */
    @Column(name = "JOB_GROUP", nullable = false, length = 255)
    @NotBlank
    private String jobGroup;

    /** Description. */
    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    /** NextFireTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NEXT_FIRE_TIME")
    private Date nextFireTime;

    /** PrevFireTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PREV_FIRE_TIME")
    private Date prevFireTime;

    /** Priority. */
    @Column(name = "PRIORITY")
    private Integer priority;

    /** TriggerState. */
    @Column(name = "TRIGGER_STATE", length = 32)
    private String triggerState;

    /** TriggerType. */
    @Column(name = "TRIGGER_TYPE", length = 32)
    private String triggerType;

    /** StartTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIME")
    private Date startTime;

    /** EndTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_TIME")
    private Date endTime;

    /** CalendarName. */
    @Column(name = "CALENDAR_NAME", length = 255)
    private String calendarName;

    /** MisfireInstr. */
    @Column(name = "MISFIRE_INSTR")
    private Integer misfireInstr;

    /** JobData. */
    @Column(name = "JOB_DATA")
    @Lob
    private byte[] jobData;

    /* ============== getters - setters ================== */

    public String getSchedulerName() {
        return this.schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getTriggerName() {
        return this.triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return this.triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return this.jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getNextFireTime() {
        return this.nextFireTime;
    }

    public void setNextFireTime(Date nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public Date getPrevFireTime() {
        return this.prevFireTime;
    }

    public void setPrevFireTime(Date prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTriggerState() {
        return this.triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCalendarName() {
        return this.calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public Integer getMisfireInstr() {
        return this.misfireInstr;
    }

    public void setMisfireInstr(Integer misfireInstr) {
        this.misfireInstr = misfireInstr;
    }

    public byte[] getJobData() {
        return this.jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public void aboutToInsert(DescriptorEvent event) {

    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
