/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

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
import javax.persistence.Transient;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActExecution;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActExecution. */
@Entity
@Table(name = ActExecution.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = ActExecution.NQ_FIND_BY_ID, query = "SELECT e FROM ActExecution e WHERE  e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActExecution.NQ_FIND_BY_IDS, query = "SELECT e FROM ActExecution e WHERE  e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@Cache(type = CacheType.NONE)
public class ActExecution implements IModelWithId {

    public static final String TABLE_NAME = "ACT_RU_EXECUTION";
    public static final String SEQUENCE_NAME = "ACT_RU_EXECUTION_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActExecution.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActExecution.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 64)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Revision. */
    @Column(name = "REV_")
    private Integer revision;

    /** ProcessInstanceId. */
    @Column(name = "PROC_INST_ID_", length = 255)
    private String processInstanceId;

    /** BusinessKey. */
    @Column(name = "BUSINESS_KEY_", length = 255)
    private String businessKey;

    /** SuperExecution. */
    @Column(name = "SUPER_EXEC_", length = 255)
    private String superExecution;

    /** ActivityId. */
    @Column(name = "ACT_ID_", length = 255)
    private String activityId;

    /** IsActive. */
    @Column(name = "IS_ACTIVE_")
    private Boolean isActive;

    /** IsConcurrent. */
    @Column(name = "IS_CONCURRENT_")
    private Boolean isConcurrent;

    /** IsScope. */
    @Column(name = "IS_SCOPE_")
    private Boolean isScope;

    /** IsEventScope. */
    @Column(name = "IS_EVENT_SCOPE_")
    private Boolean isEventScope;

    /** SuspensionState. */
    @Column(name = "SUSPENSION_STATE_")
    private Integer suspensionState;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ActExecution.class)
    @JoinColumn(name = "PARENT_ID_", referencedColumnName = "ID_")
    private ActExecution parent;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ActProcessDefinition.class)
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    private ActProcessDefinition processDefinition;

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

    public String getSuperExecution() {
        return this.superExecution;
    }

    public void setSuperExecution(String superExecution) {
        this.superExecution = superExecution;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsConcurrent() {
        return this.isConcurrent;
    }

    public void setIsConcurrent(Boolean isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public Boolean getIsScope() {
        return this.isScope;
    }

    public void setIsScope(Boolean isScope) {
        this.isScope = isScope;
    }

    public Boolean getIsEventScope() {
        return this.isEventScope;
    }

    public void setIsEventScope(Boolean isEventScope) {
        this.isEventScope = isEventScope;
    }

    public Integer getSuspensionState() {
        return this.suspensionState;
    }

    public void setSuspensionState(Integer suspensionState) {
        this.suspensionState = suspensionState;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public ActExecution getParent() {
        return this.parent;
    }

    public void setParent(ActExecution parent) {
        this.parent = parent;
    }

    public ActProcessDefinition getProcessDefinition() {
        return this.processDefinition;
    }

    public void setProcessDefinition(ActProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }

    public void aboutToInsert(DescriptorEvent event) {

    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
