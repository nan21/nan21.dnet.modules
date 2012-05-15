/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class AsgnAccessControlDsFilter extends AbstractAuditableDsFilter {

    private String dsName;

    private Boolean queryAllowed;

    private Boolean updateAllowed;

    private Boolean importAllowed;

    private Boolean exportAllowed;

    private Long accessControlId;

    private Long accessControlId_From;
    private Long accessControlId_To;

    private String accessControl;

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

    public Long getAccessControlId() {
        return this.accessControlId;
    }

    public Long getAccessControlId_From() {
        return this.accessControlId_From;
    }

    public Long getAccessControlId_To() {
        return this.accessControlId_To;
    }

    public void setAccessControlId(Long accessControlId) {
        this.accessControlId = accessControlId;
    }

    public void setAccessControlId_From(Long accessControlId_From) {
        this.accessControlId_From = accessControlId_From;
    }

    public void setAccessControlId_To(Long accessControlId_To) {
        this.accessControlId_To = accessControlId_To;
    }

    public String getAccessControl() {
        return this.accessControl;
    }

    public void setAccessControl(String accessControl) {
        this.accessControl = accessControl;
    }

}
