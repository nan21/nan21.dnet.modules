/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class DsMethodAccessControlDsFilter extends AbstractAuditableDsFilter {

    private String dsName;

    private String serviceMethod;

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

    public String getServiceMethod() {
        return this.serviceMethod;
    }

    public void setServiceMethod(String serviceMethod) {
        this.serviceMethod = serviceMethod;
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
