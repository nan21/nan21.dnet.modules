/* 
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DomainEntityEventAdapter;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Client. */
@Entity
@Table(name = "AD_CLIENT")
@Customizer(DomainEntityEventAdapter.class)
@NamedQueries({
        @NamedQuery(name = "Client.findById", query = "SELECT e FROM Client e WHERE e.id = :pId", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = "Client.findByIds", query = "SELECT e FROM Client e WHERE e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Client implements Serializable, IModelWithId {

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Client.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Client.findByIds";

    /** Code. */
    @Column(name = "CODE")
    private String code;

    /** Name. */
    @Column(name = "NAME")
    private String name;

    /** Notes. */
    @Column(name = "NOTES")
    private String notes;

    /** MaintenanceLanguage. */
    @Column(name = "MAINTENANCELANGUAGE")
    private String maintenanceLanguage;

    /**
    	Specify which is the default access rule if there is no explicit entry in ACL list.
    	<BR> Possible values are:
    	 <li> deny: by default deny access to data-source function if there is no explicit access defined in ACL.
    	 <li> allow: by default allow access to data-source function if there is no explicit denial defined in ACL.
     */
    @Column(name = "DEFAULTDSACCESSRULE")
    private String defaultDsAccessRule;

    /**
    	Specify which is the administrator role. 
    	Access rights are not checked for the users having this role granted so they have access to ALL of the functions.
     */
    @Column(name = "ADMINROLE")
    private String adminRole;

    /** DefaultImportPath. */
    @Column(name = "DEFAULTIMPORTPATH")
    private String defaultImportPath;

    /** DefaultExportPath. */
    @Column(name = "DEFAULTEXPORTPATH")
    private String defaultExportPath;

    /** TempPath. */
    @Column(name = "TEMPPATH")
    private String tempPath;

    /** DefaultUomWeight. */
    @Column(name = "DEFAULTUOMWEIGHT")
    private String defaultUomWeight;

    /** DefaultUomVolume. */
    @Column(name = "DEFAULTUOMVOLUME")
    private String defaultUomVolume;

    /** DefaultUomLength. */
    @Column(name = "DEFAULTUOMLENGTH")
    private String defaultUomLength;

    /** DefaultCurrency. */
    @Column(name = "DEFAULTCURRENCY")
    private String defaultCurrency;

    /** SystemClient. */
    @Column(name = "SYSTEMCLIENT", nullable = false)
    @NotNull
    private Boolean systemClient;

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

    /* ============== getters - setters ================== */

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMaintenanceLanguage() {
        return this.maintenanceLanguage;
    }

    public void setMaintenanceLanguage(String maintenanceLanguage) {
        this.maintenanceLanguage = maintenanceLanguage;
    }

    public String getDefaultDsAccessRule() {
        return this.defaultDsAccessRule;
    }

    public void setDefaultDsAccessRule(String defaultDsAccessRule) {
        this.defaultDsAccessRule = defaultDsAccessRule;
    }

    public String getAdminRole() {
        return this.adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public String getDefaultImportPath() {
        return this.defaultImportPath;
    }

    public void setDefaultImportPath(String defaultImportPath) {
        this.defaultImportPath = defaultImportPath;
    }

    public String getDefaultExportPath() {
        return this.defaultExportPath;
    }

    public void setDefaultExportPath(String defaultExportPath) {
        this.defaultExportPath = defaultExportPath;
    }

    public String getTempPath() {
        return this.tempPath;
    }

    public void setTempPath(String tempPath) {
        this.tempPath = tempPath;
    }

    public String getDefaultUomWeight() {
        return this.defaultUomWeight;
    }

    public void setDefaultUomWeight(String defaultUomWeight) {
        this.defaultUomWeight = defaultUomWeight;
    }

    public String getDefaultUomVolume() {
        return this.defaultUomVolume;
    }

    public void setDefaultUomVolume(String defaultUomVolume) {
        this.defaultUomVolume = defaultUomVolume;
    }

    public String getDefaultUomLength() {
        return this.defaultUomLength;
    }

    public void setDefaultUomLength(String defaultUomLength) {
        this.defaultUomLength = defaultUomLength;
    }

    public String getDefaultCurrency() {
        return this.defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public Boolean getSystemClient() {
        return this.systemClient;
    }

    public void setSystemClient(Boolean systemClient) {
        this.systemClient = systemClient;
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

    public void aboutToInsert(DescriptorEvent event) {
        event.updateAttributeWithObject("createdAt", new Date());
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("createdBy", Session.user.get()
                .getUsername());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
        if (this.systemClient == null) {
            event.updateAttributeWithObject("systemClient", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        Client e = (Client) event.getSource();
        e.setModifiedAt(new Date());
        e.setModifiedBy(Session.user.get().getUsername());

    }

}
