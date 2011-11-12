/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.domain.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ProjectVersion. */
@Entity
@Table(name = ProjectVersion.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = "PJ_PROJECT_VERSION_UK1", columnNames = {
        "CLIENTID", "PROJECT_ID", "NAME" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "ProjectVersion.findById", query = "SELECT e FROM ProjectVersion e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProjectVersion.findByIds", query = "SELECT e FROM ProjectVersion e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProjectVersion.findByName", query = "SELECT e FROM ProjectVersion e WHERE e.clientId = :pClientId and  e.project = :pProject and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProjectVersion.findByName_PRIMITIVE", query = "SELECT e FROM ProjectVersion e WHERE e.clientId = :pClientId and  e.project.id = :pProjectId and e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProjectVersion implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "PJ_PROJECT_VERSION";
    public static final String SEQUENCE_NAME = "PJ_PROJECT_VERSION_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProjectVersion.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProjectVersion.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "ProjectVersion.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "ProjectVersion.findByName_PRIMITIVE";

    /** PlanDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "PLANDATE", nullable = false)
    @NotNull
    private Date planDate;

    /** ReleaseDate. */
    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASEDATE")
    private Date releaseDate;

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    private Project project;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectVersion.class)
    @JoinColumn(name = "PROJECTVERSION_ID", referencedColumnName = "ID")
    private ProjectVersion projectVersion;

    @ManyToMany(mappedBy = "affectedVersions")
    private Collection<Issue> affectingIssues;

    /* ============== getters - setters ================== */

    public Date getPlanDate() {
        return this.planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ProjectVersion getProjectVersion() {
        return this.projectVersion;
    }

    public void setProjectVersion(ProjectVersion projectVersion) {
        this.projectVersion = projectVersion;
    }

    public Collection<Issue> getAffectingIssues() {
        return this.affectingIssues;
    }

    public void setAffectingIssues(Collection<Issue> affectingIssues) {
        this.affectingIssues = affectingIssues;
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
        if (this.active == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        ProjectVersion e = (ProjectVersion) event.getSource();
        e.setModifiedAt(new Date());
        e.setModifiedBy(Session.user.get().getUsername());

    }

}
