/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.client.ds.filter;

import net.nan21.dnet.core.presenter.model.base.X_AbstractAuditedDsFilter;

public class ClientDsFilter extends X_AbstractAuditedDsFilter {

    private String name;

    private String code;

    private String notes;

    private String maintenanceLanguage;

    private String defaultImportPath;

    private String defaultExportPath;

    private String tempPath;

    private Boolean systemClient;

    private String defaultDsAccessRule;

    private String adminRole;

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

}
