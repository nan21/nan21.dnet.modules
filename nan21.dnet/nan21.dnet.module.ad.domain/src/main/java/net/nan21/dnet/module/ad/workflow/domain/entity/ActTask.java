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
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ActTask. */
@Entity
@Table(name = ActTask.TABLE_NAME)
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = ActTask.NQ_FIND_BY_ID, query = "SELECT e FROM ActTask e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ActTask.NQ_FIND_BY_IDS, query = "SELECT e FROM ActTask e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
@ReadOnly
@Cache(type = CacheType.NONE)
public class ActTask implements Serializable, IModelWithId {

    public static final String TABLE_NAME = "ACT_RU_TASK";
    public static final String SEQUENCE_NAME = "ACT_RU_TASK_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ActTask.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ActTask.findByIds";

    /** Id. */
    @Column(name = "ID_", nullable = false, length = 255)
    @NotBlank
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private String id;

    /** Revision. */
    @Column(name = "REV_", nullable = false)
    @NotNull
    private Integer revision;

    /** ProcessInstanceId. */
    @Column(name = "PROC_INST_ID_", length = 255)
    private String processInstanceId;

    /** ExecutionId. */
    @Column(name = "EXECUTION_ID_", length = 255)
    private String executionId;

    /** Name. */
    @Column(name = "NAME_", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Description. */
    @Column(name = "DESCRIPTION_", length = 4000)
    private String description;

    /** TaskDefinitionKey. */
    @Column(name = "TASK_DEF_KEY_", length = 255)
    private String taskDefinitionKey;

    /** DelegationState. */
    @Column(name = "DELEGATION_", length = 255)
    private String delegationState;

    /** Priority. */
    @Column(name = "PRIORITY_")
    private Integer priority;

    /** Owner. */
    @Column(name = "OWNER_", length = 32)
    private String owner;

    /** Assignee. */
    @Column(name = "ASSIGNEE_", length = 32)
    private String assignee;

    /** DueDate. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DUE_DATE_")
    private Date dueDate;

    /** CreatedAt. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME_")
    private Date createdAt;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ActProcessDefinition.class)
    @JoinColumn(name = "PROC_DEF_ID_", referencedColumnName = "ID_")
    private ActProcessDefinition processDefinition;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ActTask.class)
    @JoinColumn(name = "PARENT_TASK_ID_", referencedColumnName = "ID_")
    private ActTask parent;

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

    public String getExecutionId() {
        return this.executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskDefinitionKey() {
        return this.taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getDelegationState() {
        return this.delegationState;
    }

    public void setDelegationState(String delegationState) {
        this.delegationState = delegationState;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Transient
    public Long getVersion() {
        return 1L;
    }

    public void setVersion(Long version) {

    }

    public ActProcessDefinition getProcessDefinition() {
        return this.processDefinition;
    }

    public void setProcessDefinition(ActProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }

    public ActTask getParent() {
        return this.parent;
    }

    public void setParent(ActTask parent) {
        this.parent = parent;
    }

    public void aboutToInsert(DescriptorEvent event) {

        event.updateAttributeWithObject("createdAt", new Date());
    }

    public void aboutToUpdate(DescriptorEvent event) {

    }

}
