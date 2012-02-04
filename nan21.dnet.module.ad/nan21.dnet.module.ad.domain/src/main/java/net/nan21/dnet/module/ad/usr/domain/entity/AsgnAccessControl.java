/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.domain.entity;

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
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Access control rules for assignment components.
 */
@Entity
@Table(name = AsgnAccessControl.TABLE_NAME, uniqueConstraints = { @UniqueConstraint(name = AsgnAccessControl.TABLE_NAME
        + "_UK1", columnNames = { "CLIENTID", "ACCESSCONTROL_ID", "DSNAME" }) })
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = AsgnAccessControl.NQ_FIND_BY_ID, query = "SELECT e FROM AsgnAccessControl e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AsgnAccessControl.NQ_FIND_BY_IDS, query = "SELECT e FROM AsgnAccessControl e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = AsgnAccessControl.NQ_FIND_BY_UNIQUE, query = "SELECT e FROM AsgnAccessControl e WHERE e.clientId = :pClientId and  e.accessControl = :pAccessControl and e.dsName = :pDsName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "AsgnAccessControl.findByUnique_PRIMITIVE", query = "SELECT e FROM AsgnAccessControl e WHERE e.clientId = :pClientId and  e.accessControl.id = :pAccessControlId and e.dsName = :pDsName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class AsgnAccessControl implements Serializable, IModelWithId,
        IModelWithClientId {

    public static final String TABLE_NAME = "AD_ACCESS_CONTROL_ASGN";
    public static final String SEQUENCE_NAME = "AD_ACCESS_CONTROL_ASGN_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "AsgnAccessControl.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "AsgnAccessControl.findByIds";

    /**
     * Named query find by unique key: Unique.
     */
    public static final String NQ_FIND_BY_UNIQUE = "AsgnAccessControl.findByUnique";

    /**
     * Named query find by unique key: Unique using the ID field for references.
     */
    public static final String NQ_FIND_BY_UNIQUE_PRIMITIVE = "AsgnAccessControl.findByUnique_PRIMITIVE";

    /** DsName. */
    @Column(name = "DSNAME", nullable = false, length = 255)
    @NotBlank
    private String dsName;

    /** Specify if it is allowed to query for data.*/
    @Column(name = "QUERYALLOWED", nullable = false)
    @NotNull
    private Boolean queryAllowed;

    /** Specify if it is allowed to update records.*/
    @Column(name = "UPDATEALLOWED", nullable = false)
    @NotNull
    private Boolean updateAllowed;

    /** Specify if it is allowed to import records.*/
    @Column(name = "IMPORTALLOWED", nullable = false)
    @NotNull
    private Boolean importAllowed;

    /** Specify if it is allowed to export records.*/
    @Column(name = "EXPORTALLOWED", nullable = false)
    @NotNull
    private Boolean exportAllowed;

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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AccessControl.class)
    @JoinColumn(name = "ACCESSCONTROL_ID", referencedColumnName = "ID")
    private AccessControl accessControl;

    /* ============== getters - setters ================== */

    public String getDsName() {
        return this.dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public Boolean getQueryAllowed() {
        return this.queryAllowed;
    }

    public void setQueryAllowed(Boolean queryAllowed) {
        this.queryAllowed = queryAllowed;
    }

    public Boolean getUpdateAllowed() {
        return this.updateAllowed;
    }

    public void setUpdateAllowed(Boolean updateAllowed) {
        this.updateAllowed = updateAllowed;
    }

    public Boolean getImportAllowed() {
        return this.importAllowed;
    }

    public void setImportAllowed(Boolean importAllowed) {
        this.importAllowed = importAllowed;
    }

    public Boolean getExportAllowed() {
        return this.exportAllowed;
    }

    public void setExportAllowed(Boolean exportAllowed) {
        this.exportAllowed = exportAllowed;
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

    public AccessControl getAccessControl() {
        return this.accessControl;
    }

    public void setAccessControl(AccessControl accessControl) {
        this.accessControl = accessControl;
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
        if (this.queryAllowed == null) {
            event.updateAttributeWithObject("queryAllowed", false);
        }
        if (this.updateAllowed == null) {
            event.updateAttributeWithObject("updateAllowed", false);
        }
        if (this.importAllowed == null) {
            event.updateAttributeWithObject("importAllowed", false);
        }
        if (this.exportAllowed == null) {
            event.updateAttributeWithObject("exportAllowed", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {

        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());

    }

}
