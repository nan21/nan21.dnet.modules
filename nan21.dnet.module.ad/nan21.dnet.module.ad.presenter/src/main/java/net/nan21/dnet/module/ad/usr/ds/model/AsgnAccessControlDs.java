/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.usr.domain.entity.AsgnAccessControl;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AsgnAccessControl.class, sort = { @SortField(field = AsgnAccessControlDs.fDSNAME) })
public class AsgnAccessControlDs extends AbstractAuditableDs<AsgnAccessControl> {

    public static final String fDSNAME = "dsName";
    public static final String fQUERYALLOWED = "queryAllowed";
    public static final String fUPDATEALLOWED = "updateAllowed";
    public static final String fIMPORTALLOWED = "importAllowed";
    public static final String fEXPORTALLOWED = "exportAllowed";
    public static final String fACCESSCONTROLID = "accessControlId";
    public static final String fACCESSCONTROL = "accessControl";

    @DsField()
    private String dsName;

    @DsField()
    private Boolean queryAllowed;

    @DsField()
    private Boolean updateAllowed;

    @DsField()
    private Boolean importAllowed;

    @DsField()
    private Boolean exportAllowed;

    @DsField(join = "left", path = "accessControl.id")
    private Long accessControlId;

    @DsField(join = "left", path = "accessControl.name")
    private String accessControl;

    public AsgnAccessControlDs() {
        super();
    }

    public AsgnAccessControlDs(AsgnAccessControl e) {
        super(e);
    }

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

    public void setAccessControlId(Long accessControlId) {
        this.accessControlId = accessControlId;
    }

    public String getAccessControl() {
        return this.accessControl;
    }

    public void setAccessControl(String accessControl) {
        this.accessControl = accessControl;
    }

}
