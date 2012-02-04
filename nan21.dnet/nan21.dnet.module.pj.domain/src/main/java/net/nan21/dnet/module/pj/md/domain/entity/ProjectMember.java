/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** ProjectMember. */
@Entity
@Table(name = ProjectMember.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = ProjectMember.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "PROJECT_ID", "MEMBER_ID" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = ProjectMember.NQ_FIND_BY_ID, query = "SELECT e FROM ProjectMember e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProjectMember.NQ_FIND_BY_IDS, query = "SELECT e FROM ProjectMember e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = ProjectMember.NQ_FIND_BY_NAME, query = "SELECT e FROM ProjectMember e WHERE e.clientId = :pClientId and  e.project = :pProject and e.member = :pMember ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "ProjectMember.findByName_PRIMITIVE", query = "SELECT e FROM ProjectMember e WHERE e.clientId = :pClientId and  e.project.id = :pProjectId and e.member.id = :pMemberId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class ProjectMember implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "PJ_PROJECT_MEMBER";
    public static final String SEQUENCE_NAME = "PJ_PROJECT_MEMBER_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "ProjectMember.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "ProjectMember.findByIds";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "ProjectMember.findByName";

    /**
     * Named query find by unique key: Name using the ID field for references.
     */
    public static final String NQ_FIND_BY_NAME_PRIMITIVE = "ProjectMember.findByName_PRIMITIVE";

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Assignable.class)
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID")
    private Assignable member;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectRole.class)
    @JoinColumn(name = "PROJECTROLE_ID", referencedColumnName = "ID")
    private ProjectRole projectRole;

    /* ============== getters - setters ================== */

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

    public Assignable getMember() {
        return this.member;
    }

    public void setMember(Assignable member) {
        this.member = member;
    }

    public ProjectRole getProjectRole() {
        return this.projectRole;
    }

    public void setProjectRole(ProjectRole projectRole) {
        this.projectRole = projectRole;
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
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}