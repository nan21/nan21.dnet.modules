/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Client.class)
public class ClientDs extends AbstractDsModel<Client> implements IModelWithId {

    public static final String fNAME = "name";
    public static final String fCODE = "code";
    public static final String fNOTES = "notes";
    public static final String fMAINTENANCELANGUAGE = "maintenanceLanguage";
    public static final String fDEFAULTIMPORTPATH = "defaultImportPath";
    public static final String fDEFAULTEXPORTPATH = "defaultExportPath";
    public static final String fTEMPPATH = "tempPath";
    public static final String fSYSTEMCLIENT = "systemClient";
    public static final String fDEFAULTDSACCESSRULE = "defaultDsAccessRule";
    public static final String fADMINROLE = "adminRole";
    public static final String fID = "id";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";

    @DsField()
    private String name;

    @DsField()
    private String code;

    @DsField()
    private String notes;

    @DsField()
    private String maintenanceLanguage;

    @DsField()
    private String defaultImportPath;

    @DsField()
    private String defaultExportPath;

    @DsField()
    private String tempPath;

    @DsField()
    private Boolean systemClient;

    @DsField()
    private String defaultDsAccessRule;

    @DsField()
    private String adminRole;

    @DsField()
    private Long id;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    public ClientDs() {
        super();
    }

    public ClientDs(Client e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Boolean getSystemClient() {
        return this.systemClient;
    }

    public void setSystemClient(Boolean systemClient) {
        this.systemClient = systemClient;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

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

}
