/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.quartz.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Transient;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** QuartzJobDetail. */
@Entity
@Table(name = QuartzJobDetail.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({})
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzJobDetail {

    public static final String TABLE_NAME = "XT_QRTZ_JOB_DETAILS";
    public static final String SEQUENCE_NAME = "XT_QRTZ_JOB_DETAILS_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /** SchedulerName. */
    @Column(name = "SCHED_NAME", nullable = false, length = 255)
    @NotBlank
    @Id
    private String schedulerName;

    /** JobName. */
    @Column(name = "JOB_NAME", nullable = false, length = 255)
    @NotBlank
    @Id
    private String jobName;

    /** JobGroup. */
    @Column(name = "JOB_GROUP", nullable = false, length = 255)
    @NotBlank
    @Id
    private String jobGroup;

    /** Description. */
    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    /** JobClassName. */
    @Column(name = "JOB_CLASS_NAME", length = 255)
    private String jobClassName;

    /** IsDurable. */
    @Column(name = "IS_DURABLE", length = 1)
    private String isDurable;

    /** IsNonConcurrent. */
    @Column(name = "IS_NONCONCURRENT", length = 1)
    private String isNonConcurrent;

    /** IsUpdateData. */
    @Column(name = "IS_UPDATE_DATA", length = 1)
    private String isUpdateData;

    /** RequestsRecovery. */
    @Column(name = "REQUESTS_RECOVERY", length = 1)
    private String requestsRecovery;

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

    public String getJobClassName() {
        return this.jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getIsDurable() {
        return this.isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    public String getIsNonConcurrent() {
        return this.isNonConcurrent;
    }

    public void setIsNonConcurrent(String isNonConcurrent) {
        this.isNonConcurrent = isNonConcurrent;
    }

    public String getIsUpdateData() {
        return this.isUpdateData;
    }

    public void setIsUpdateData(String isUpdateData) {
        this.isUpdateData = isUpdateData;
    }

    public String getRequestsRecovery() {
        return this.requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
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
