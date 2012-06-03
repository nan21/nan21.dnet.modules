/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.pj.md.domain.entity;

import java.util.Collection;
import java.util.Date;
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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
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
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Issue.NQ_FIND_BY_ID, query = "SELECT e FROM Issue e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Issue.NQ_FIND_BY_IDS, query = "SELECT e FROM Issue e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Issue.NQ_FIND_BY_CODE, query = "SELECT e FROM Issue e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Issue extends AbstractAuditable {

    public static final String TABLE_NAME = "PJ_ISSUE";
    public static final String SEQUENCE_NAME = "PJ_ISSUE_SEQ";

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

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

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
    @JoinTable(name = "PJ_ISSUE_PRJVER")
    private Collection<ProjectVersion> affectedVersions;

    @ManyToMany
    @JoinTable(name = "PJ_ISSUE_COMP")
    private Collection<ProjectComponent> affectedComponents;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        if (project != null) {
            this.__validate_client_context__(project.getClientId());
        }
        this.project = project;
    }

    public IssueStatus getStatus() {
        return this.status;
    }

    public void setStatus(IssueStatus status) {
        if (status != null) {
            this.__validate_client_context__(status.getClientId());
        }
        this.status = status;
    }

    public IssueType getType() {
        return this.type;
    }

    public void setType(IssueType type) {
        if (type != null) {
            this.__validate_client_context__(type.getClientId());
        }
        this.type = type;
    }

    public IssuePriority getPriority() {
        return this.priority;
    }

    public void setPriority(IssuePriority priority) {
        if (priority != null) {
            this.__validate_client_context__(priority.getClientId());
        }
        this.priority = priority;
    }

    public IssueResolution getResolution() {
        return this.resolution;
    }

    public void setResolution(IssueResolution resolution) {
        if (resolution != null) {
            this.__validate_client_context__(resolution.getClientId());
        }
        this.resolution = resolution;
    }

    public IssueSeverity getSeverity() {
        return this.severity;
    }

    public void setSeverity(IssueSeverity severity) {
        if (severity != null) {
            this.__validate_client_context__(severity.getClientId());
        }
        this.severity = severity;
    }

    public ProjectVersion getReportedVersion() {
        return this.reportedVersion;
    }

    public void setReportedVersion(ProjectVersion reportedVersion) {
        if (reportedVersion != null) {
            this.__validate_client_context__(reportedVersion.getClientId());
        }
        this.reportedVersion = reportedVersion;
    }

    public ProjectVersion getTargetVersion() {
        return this.targetVersion;
    }

    public void setTargetVersion(ProjectVersion targetVersion) {
        if (targetVersion != null) {
            this.__validate_client_context__(targetVersion.getClientId());
        }
        this.targetVersion = targetVersion;
    }

    public ProjectVersion getFixedInVersion() {
        return this.fixedInVersion;
    }

    public void setFixedInVersion(ProjectVersion fixedInVersion) {
        if (fixedInVersion != null) {
            this.__validate_client_context__(fixedInVersion.getClientId());
        }
        this.fixedInVersion = fixedInVersion;
    }

    public ProjectMember getAssignee() {
        return this.assignee;
    }

    public void setAssignee(ProjectMember assignee) {
        if (assignee != null) {
            this.__validate_client_context__(assignee.getClientId());
        }
        this.assignee = assignee;
    }

    public ProjectRole getAssigneeRole() {
        return this.assigneeRole;
    }

    public void setAssigneeRole(ProjectRole assigneeRole) {
        if (assigneeRole != null) {
            this.__validate_client_context__(assigneeRole.getClientId());
        }
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

        super.aboutToInsert(event);

        if (this.getCode() == null || this.getCode().equals("")) {
            event.updateAttributeWithObject("code", "I-" + this.getId());
        }
    }

}
