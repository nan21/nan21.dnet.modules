/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActJob. */
@Entity
@Table(name = ActJob.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ActJob.NQ_FIND_BY_ID, query = "SELECT e FROM ActJob e WHERE  e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActJob.NQ_FIND_BY_IDS, query = "SELECT e FROM ActJob e WHERE  e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@Cache(type = CacheType.NONE)
public class ActJob implements IModelWithId {

    public static final String TABLE_NAME = "ACT_RU_JOB";
    public static final String SEQUENCE_NAME = "ACT_RU_JOB_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActJob.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActJob.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 64)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Revision. */
    @Column(name = "REV_")
    private Integer revision;

    /** Type. */
    @Column(name = "TYPE_", length = 255)
    private String type;

    /** LockExpirationTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOCK_EXP_TIME_")
    private Date lockExpirationTime;

    /** LockOwner. */
    @Column(name = "LOCK_OWNER_", length = 255)
    private String lockOwner;

    /** IsExclusive. */
    @Column(name = "EXCLUSIVE_")
    private Boolean isExclusive;

    /** ExecutionId. */
    @Column(name = "EXECUTION_ID_", length = 255)
    private String executionId;

    /** ProcessInstanceId. */
    @Column(name = "PROCESS_INSTANCE_ID_", length = 255)
    private String processInstanceId;

    /** Retries. */
    @Column(name = "RETRIES_")
    private Integer retries;

    /** ExceptionByteArrayId. */
    @Column(name = "EXCEPTION_STACK_ID_", length = 255)
    private String exceptionByteArrayId;

    /** ExceptionMessage. */
    @Column(name = "EXCEPTION_MSG_", length = 4000)
    private String exceptionMessage;

    /** DueDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DUE_DATE_")
    private Date dueDate;

    /** Repeat. */
    @Column(name = "REPEAT_", length = 255)
    private String repeat;

    /** JobHandlerType. */
    @Column(name = "HANDLER_TYPE_", length = 255)
    private String jobHandlerType;

    /** JobHandlerConfiguration. */
    @Column(name = "HANDLER_CFG_", length = 255)
    private String jobHandlerConfiguration;

    /* ============== getters - setters ================== */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLockExpirationTime() {
        return this.lockExpirationTime;
    }

    public void setLockExpirationTime(Date lockExpirationTime) {
        this.lockExpirationTime = lockExpirationTime;
    }

    public String getLockOwner() {
        return this.lockOwner;
    }

    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner;
    }

    public Boolean getIsExclusive() {
        return this.isExclusive;
    }

    public void setIsExclusive(Boolean isExclusive) {
        this.isExclusive = isExclusive;
    }

    public String getExecutionId() {
        return this.executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Integer getRetries() {
        return this.retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public String getExceptionByteArrayId() {
        return this.exceptionByteArrayId;
    }

    public void setExceptionByteArrayId(String exceptionByteArrayId) {
        this.exceptionByteArrayId = exceptionByteArrayId;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getRepeat() {
        return this.repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getJobHandlerType() {
        return this.jobHandlerType;
    }

    public void setJobHandlerType(String jobHandlerType) {
        this.jobHandlerType = jobHandlerType;
    }

    public String getJobHandlerConfiguration() {
        return this.jobHandlerConfiguration;
    }

    public void setJobHandlerConfiguration(String jobHandlerConfiguration) {
        this.jobHandlerConfiguration = jobHandlerConfiguration;
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
