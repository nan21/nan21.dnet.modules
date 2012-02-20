/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.domain.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Issue. */
@Entity
@Table(name = Issue.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = Issue.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "CODE" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = Issue.NQ_FIND_BY_ID, query = "SELECT e FROM Issue e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Issue.NQ_FIND_BY_IDS, query = "SELECT e FROM Issue e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Issue.NQ_FIND_BY_CODE, query = "SELECT e FROM Issue e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Issue implements Serializable, IModelWithId, IModelWithClientId {

    public static final String TABLE_NAME = "PJ_ITEM";
    public static final String SEQUENCE_NAME = "PJ_ITEM_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Issue.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Issue.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "Issue.findByCode";

    /** Code. */
    @Column(name = "CODE", nullable = false, length = 32)
    @NotBlank
    private String code;

    /**
     * Brief (one line) description of this issue.
     */
    @Column(name = "SUMMARY", nullable = false, length = 255)
    @NotBlank
    private String summary;

    /** Description. */
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    /** BusinessValue. */
    @Column(name = "BUSINESSVALUE")
    private Integer businessValue;

    /** EstimatedEffort. */
    @Column(name = "ESTIMATEDEFFORT")
    private Integer estimatedEffort;

    /** Clarity. */
    @Column(name = "CLARITY")
    private Integer clarity;

    /** DueDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "DUEDATE")
    private Date dueDate;

    /** ResolutionDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "RESOLUTIONDATE")
    private Date resolutionDate;

    /**
     * Identifies the client(tenant) which owns this record.
     */
    @Column(name = "CLIENTID", nullable = false)
    @NotNull
    private Long clientId;

    /**
     * Timestamp when this record was created.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDAT", nullable = false)
    @NotNull
    private Date createdAt;

    /**
     * Timestamp when this record was last modified.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIEDAT", nullable = false)
    @NotNull
    private Date modifiedAt;

    /**
     * User who created this record.
     */
    @Column(name = "CREATEDBY", nullable = false, length = 32)
    @NotBlank
    private String createdBy;

    /**
     * User who last modified this record.
     */
    @Column(name = "MODIFIEDBY", nullable = false, length = 32)
    @NotBlank
    private String modifiedBy;

    @Version
    /** 
     * Record version number used by the persistence framework.
     */
    @Column(name = "VERSION", nullable = false)
    @NotNull
    private Long version;

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /**
     * System generated UID. Useful for data import-export and data-replication
     */
    @Column(name = "UUID", length = 36)
    private String uuid;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    private Project project;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueStatus.class)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    private IssueStatus status;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private IssueType type;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssuePriority.class)
    @JoinColumn(name = "PRIORITY_ID", referencedColumnName = "ID")
    private IssuePriority priority;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueResolution.class)
    @JoinColumn(name = "RESOLUTION_ID", referencedColumnName = "ID")
    private IssueResolution resolution;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueSeverity.class)
    @JoinColumn(name = "SEVERITY_ID", referencedColumnName = "ID")
    private IssueSeverity severity;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectVersion.class)
    @JoinColumn(name = "REPORTEDVERSION_ID", referencedColumnName = "ID")
    private ProjectVersion reportedVersion;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectVersion.class)
    @JoinColumn(name = "TARGETVERSION_ID", referencedColumnName = "ID")
    private ProjectVersion targetVersion;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectVersion.class)
    @JoinColumn(name = "FIXEDINVERSION_ID", referencedColumnName = "ID")
    private ProjectVersion fixedInVersion;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectMember.class)
    @JoinColumn(name = "ASSIGNEE_ID", referencedColumnName = "ID")
    private ProjectMember assignee;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectRole.class)
    @JoinColumn(name = "ASSIGNEEROLE_ID", referencedColumnName = "ID")
    private ProjectRole assigneeRole;

    @ManyToMany
    @JoinTable(name = "PJ_ITEM_PRJVERSIONS")
    private Collection<ProjectVersion> affectedVersions;

    @ManyToMany
    @JoinTable(name = "PJ_ITEM_COMPS")
    private Collection<ProjectComponent> affectedComponents;

    /* ============== getters - setters ================== */

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBusinessValue() {
        return this.businessValue;
    }

    public void setBusinessValue(Integer businessValue) {
        this.businessValue = businessValue;
    }

    public Integer getEstimatedEffort() {
        return this.estimatedEffort;
    }

    public void setEstimatedEffort(Integer estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }

    public Integer getClarity() {
        return this.clarity;
    }

    public void setClarity(Integer clarity) {
        this.clarity = clarity;
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

    @Transient
    public String getBusinessObject() {
        return "ProjectIssue";
    }

    public void setBusinessObject(String businessObject) {

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

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public IssueStatus getStatus() {
        return this.status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public IssueType getType() {
        return this.type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public IssuePriority getPriority() {
        return this.priority;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
    }

    public IssueResolution getResolution() {
        return this.resolution;
    }

    public void setResolution(IssueResolution resolution) {
        this.resolution = resolution;
    }

    public IssueSeverity getSeverity() {
        return this.severity;
    }

    public void setSeverity(IssueSeverity severity) {
        this.severity = severity;
    }

    public ProjectVersion getReportedVersion() {
        return this.reportedVersion;
    }

    public void setReportedVersion(ProjectVersion reportedVersion) {
        this.reportedVersion = reportedVersion;
    }

    public ProjectVersion getTargetVersion() {
        return this.targetVersion;
    }

    public void setTargetVersion(ProjectVersion targetVersion) {
        this.targetVersion = targetVersion;
    }

    public ProjectVersion getFixedInVersion() {
        return this.fixedInVersion;
    }

    public void setFixedInVersion(ProjectVersion fixedInVersion) {
        this.fixedInVersion = fixedInVersion;
    }

    public ProjectMember getAssignee() {
        return this.assignee;
    }

    public void setAssignee(ProjectMember assignee) {
        this.assignee = assignee;
    }

    public ProjectRole getAssigneeRole() {
        return this.assigneeRole;
    }

    public void setAssigneeRole(ProjectRole assigneeRole) {
        this.assigneeRole = assigneeRole;
    }

    public Collection<ProjectVersion> getAffectedVersions() {
        return this.affectedVersions;
    }

    public void setAffectedVersions(Collection<ProjectVersion> affectedVersions) {
        this.affectedVersions = affectedVersions;
    }

    public Collection<ProjectComponent> getAffectedComponents() {
        return this.affectedComponents;
    }

    public void setAffectedComponents(
            Collection<ProjectComponent> affectedComponents) {
        this.affectedComponents = affectedComponents;
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
        if (this.uuid == null || this.uuid.equals("")) {
            event.updateAttributeWithObject("uuid", UUID.randomUUID()
                    .toString().toUpperCase());
        }
        if (this.code == null || this.code.equals("")) {
            event.updateAttributeWithObject("code", "I-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
