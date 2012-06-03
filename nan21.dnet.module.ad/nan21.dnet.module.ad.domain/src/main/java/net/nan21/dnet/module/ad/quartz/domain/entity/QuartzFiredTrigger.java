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
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** QuartzFiredTrigger. */
@Entity
@Table(name = QuartzFiredTrigger.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({})
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzFiredTrigger {

    public static final String TABLE_NAME = "XT_QRTZ_FIRED_TRIGGERS";
    public static final String SEQUENCE_NAME = "XT_QRTZ_FIRED_TRIGGERS_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /** SchedulerName. */
    @Column(name = "SCHED_NAME", nullable = false, length = 255)
    @NotBlank
    @Id
    private String schedulerName;

    /** EntryID. */
    @Column(name = "ENTRY_ID", nullable = false, length = 255)
    @NotBlank
    @Id
    private String entryID;

    /** TriggerName. */
    @Column(name = "TRIGGER_NAME", nullable = false, length = 255)
    @NotBlank
    private String triggerName;

    /** TriggerGroup. */
    @Column(name = "TRIGGER_GROUP", nullable = false, length = 255)
    @NotBlank
    private String triggerGroup;

    /** InstanceName. */
    @Column(name = "INSTANCE_NAME", nullable = false, length = 255)
    @NotBlank
    private String instanceName;

    /** FiredTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FIRED_TIME", nullable = false)
    @NotNull
    private Date firedTime;

    /** Priority. */
    @Column(name = "PRIORITY", nullable = false)
    @NotNull
    private Integer priority;

    /** State. */
    @Column(name = "STATE", nullable = false, length = 255)
    @NotBlank
    private String state;

    /** JobName. */
    @Column(name = "JOB_NAME", length = 255)
    private String jobName;

    /** JobGroup. */
    @Column(name = "JOB_GROUP", length = 255)
    private String jobGroup;

    /** IsNonConcurrent. */
    @Column(name = "IS_NONCONCURRENT", length = 1)
    private String isNonConcurrent;

    /** RequestsRecovery. */
    @Column(name = "REQUESTS_RECOVERY", length = 1)
    private String requestsRecovery;

    /* ============== getters - setters ================== */

    public String getSchedulerName() {
        return this.schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getEntryID() {
        return this.entryID;
    }

    public void setEntryID(String entryID) {
        this.entryID = entryID;
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

    public String getInstanceName() {
        return this.instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public Date getFiredTime() {
        return this.firedTime;
    }

    public void setFiredTime(Date firedTime) {
        this.firedTime = firedTime;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getIsNonConcurrent() {
        return this.isNonConcurrent;
    }

    public void setIsNonConcurrent(String isNonConcurrent) {
        this.isNonConcurrent = isNonConcurrent;
    }

    public String getRequestsRecovery() {
        return this.requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
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
