/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfProcess;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** WfProcessInstance. */
@Entity
@Table(name = "ACT_HI_PROCINST")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "WfProcessInstance.findById", query = "SELECT e FROM WfProcessInstance e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "WfProcessInstance.findByIds", query = "SELECT e FROM WfProcessInstance e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@ReadOnly
@Cache(type = CacheType.NONE)
public class WfProcessInstance implements Serializable, IModelWithId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "WfProcessInstance.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "WfProcessInstance.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false)
    @NotBlank
    @Id
    @GeneratedValue
    private String id;

    /** ProcessInstanceId. */
    @Column(name = "PROC_INST_ID_", nullable = false)
    @NotBlank
    private String processInstanceId;

    /** BusinessKey. */
    @Column(name = "BUSINESS_KEY_")
    private String businessKey;

    /** StartTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIME_", nullable = false)
    @NotNull
    private Date startTime;

    /** EndTime. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_TIME_")
    private Date endTime;

    /** Duration. */
    @Column(name = "DURATION_")
    private Long duration;

    /** StartedBy. */
    @Column(name = "START_USER_ID_")
    private String startedBy;

    /** StartAction. */
    @Column(name = "START_ACT_ID_")
    private String startAction;

    /** EndAction. */
    @Column(name = "END_ACT_ID_")
    private String endAction;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = WfProcess.class)
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    private WfProcess process;

    /* ============== getters - setters ================== */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return this.processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getBusinessKey() {
        return this.businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
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

    public Long getDuration() {
        return this.duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getStartedBy() {
        return this.startedBy;
    }

    public void setStartedBy(String startedBy) {
        this.startedBy = startedBy;
    }

    public String getStartAction() {
        return this.startAction;
    }

    public void setStartAction(String startAction) {
        this.startAction = startAction;
    }

    public String getEndAction() {
        return this.endAction;
    }

    public void setEndAction(String endAction) {
        this.endAction = endAction;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public WfProcess getProcess() {
        return this.process;
    }

    public void setProcess(WfProcess process) {
        this.process = process;
    }

    public void aboutToInsert(DescriptorEvent event) {
    }

    public void aboutToUpdate(DescriptorEvent event) {
        WfProcessInstance e = (WfProcessInstance) event.getSource();

    }

}
