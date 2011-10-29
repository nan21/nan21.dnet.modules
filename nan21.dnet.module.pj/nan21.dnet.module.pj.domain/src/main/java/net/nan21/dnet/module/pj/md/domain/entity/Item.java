/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.domain.entity;

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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ItemPriority;
import net.nan21.dnet.module.pj.base.domain.entity.ItemResolution;
import net.nan21.dnet.module.pj.base.domain.entity.ItemSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.ItemStatus;
import net.nan21.dnet.module.pj.base.domain.entity.ItemType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Item;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Item. */
@Entity
@Table(name = "PJ_ITEM")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "Item.findById", query = "SELECT e FROM Item e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "Item.findByIds", query = "SELECT e FROM Item e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Item implements Serializable, IModelWithId, IModelWithClientId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Item.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Item.findByIds";

    /**
     * Instance type of this item: Possible values: issue, task 
     */
    @Column(name = "INSTANCETYPE", nullable = false)
    @NotBlank
    private String instanceType;

    /**
     * Brief (one line) description of this item.
     */
    @Column(name = "SUMMARY", nullable = false)
    @NotBlank
    private String summary;

    /** DueDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "DUEDATE")
    private Date dueDate;

    /** ResolutionDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "RESOLUTIONDATE")
    private Date resolutionDate;

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
    @Column(name = "CREATEDBY", nullable = false)
    @NotBlank
    private String createdBy;

    /** User who last modified this record.*/
    @Column(name = "MODIFIEDBY", nullable = false)
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
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    private Project project;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Item.class)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ItemStatus.class)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    private ItemStatus status;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ItemType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private ItemType type;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ItemPriority.class)
    @JoinColumn(name = "PRIORITY_ID", referencedColumnName = "ID")
    private ItemPriority priority;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ItemResolution.class)
    @JoinColumn(name = "RESOLUTION_ID", referencedColumnName = "ID")
    private ItemResolution resolution;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ItemSeverity.class)
    @JoinColumn(name = "SEVERITY_ID", referencedColumnName = "ID")
    private ItemSeverity severity;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Assignable.class)
    @JoinColumn(name = "ASSIGNEE_ID", referencedColumnName = "ID")
    private Assignable assignee;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectRole.class)
    @JoinColumn(name = "ASSIGNEEROLE_ID", referencedColumnName = "ID")
    private ProjectRole assigneeRole;

    /* ============== getters - setters ================== */

    public String getInstanceType() {
        return this.instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getResolutionDate() {
        return this.resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
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

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemStatus getStatus() {
        return this.status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public ItemType getType() {
        return this.type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public ItemPriority getPriority() {
        return this.priority;
    }

    public void setPriority(ItemPriority priority) {
        this.priority = priority;
    }

    public ItemResolution getResolution() {
        return this.resolution;
    }

    public void setResolution(ItemResolution resolution) {
        this.resolution = resolution;
    }

    public ItemSeverity getSeverity() {
        return this.severity;
    }

    public void setSeverity(ItemSeverity severity) {
        this.severity = severity;
    }

    public Assignable getAssignee() {
        return this.assignee;
    }

    public void setAssignee(Assignable assignee) {
        this.assignee = assignee;
    }

    public ProjectRole getAssigneeRole() {
        return this.assigneeRole;
    }

    public void setAssigneeRole(ProjectRole assigneeRole) {
        this.assigneeRole = assigneeRole;
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
    }

    public void aboutToUpdate(DescriptorEvent event) {
        Item e = (Item) event.getSource();
        e.setModifiedAt(new Date());
        e.setModifiedBy(Session.user.get().getUsername());

    }

}
