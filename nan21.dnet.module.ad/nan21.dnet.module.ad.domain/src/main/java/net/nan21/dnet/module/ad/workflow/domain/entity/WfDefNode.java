/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** WfDefNode. */
@Entity
@Table(name = WfDefNode.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = WfDefNode.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "NAME" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = WfDefNode.NQ_FIND_BY_ID, query = "SELECT e FROM WfDefNode e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = WfDefNode.NQ_FIND_BY_IDS, query = "SELECT e FROM WfDefNode e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = WfDefNode.NQ_FIND_BY_NAME, query = "SELECT e FROM WfDefNode e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class WfDefNode implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "AD_WFDEF_NODE";
    public static final String SEQUENCE_NAME = "AD_WFDEF_NODE_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "WfDefNode.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "WfDefNode.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "WfDefNode.findByName";

    /** AssignToUser. */
    @Column(name = "ASSIGNTOUSER", length = 400)
    private String assignToUser;

    /** AssignToGroup. */
    @Column(name = "ASSIGNTOGROUP", length = 400)
    private String assignToGroup;

    /** StartWithPrevious. */
    @Column(name = "STARTWITHPREVIOUS", nullable = false)
    @NotNull
    private Boolean startWithPrevious;

    /** TaskType. */
    @Column(name = "TASKTYPE", nullable = false, length = 16)
    @NotBlank
    private String taskType;

    /** Name. */
    @Column(name = "NAME", nullable = false, length = 255)
    @NotBlank
    private String name;

    /** Flag which indicates if this record is used.*/
    @Column(name = "ACTIVE", nullable = false)
    @NotNull
    private Boolean active;

    /** Notes about this record. */
    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    /** Owner client */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /** Timestamp when this record was created.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /** Timestamp when this record was last modified.*/
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /** User who created this record.*/
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** Record version number used by the persistence framework. */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /** System generated unique identifier */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = WfDefProcess.class)
    @JoinColumn(name = "PROCESS_ID", referencedColumnName = "ID")
    private WfDefProcess process;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = WfDefNodeField.class, mappedBy = "node", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<WfDefNodeField> fields;

    /* ============== getters - setters ================== */

    public String getAssignToUser() {
        return this.assignToUser;
    }

    public void setAssignToUser(String assignToUser) {
        this.assignToUser = assignToUser;
    }

    public String getAssignToGroup() {
        return this.assignToGroup;
    }

    public void setAssignToGroup(String assignToGroup) {
        this.assignToGroup = assignToGroup;
    }

    public Boolean getStartWithPrevious() {
        return this.startWithPrevious;
    }

    public void setStartWithPrevious(Boolean startWithPrevious) {
        this.startWithPrevious = startWithPrevious;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public String getClassName() {
        return this.getClass().getCanonicalName();
    }

    public void setClassName(String className) {

    }

    public WfDefProcess getProcess() {
        return this.process;
    }

    public void setProcess(WfDefProcess process) {
        this.process = process;
    }

    public Collection<WfDefNodeField> getFields() {
        return this.fields;
    }

    public void setFields(Collection<WfDefNodeField> fields) {
        this.fields = fields;
    }

    public void addToFields(WfDefNodeField e) {
        if (this.fields == null) {
            this.fields = new ArrayList<WfDefNodeField>();
        }
        e.setNode(this);
        this.fields.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("clientId", Session.user.get()
                .getClientId());
        if (this.startWithPrevious == null) {
            event.updateAttributeWithObject("startWithPrevious", false);
        }
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
