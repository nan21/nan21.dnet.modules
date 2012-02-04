/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class IssueDsParam extends EmptyParam {

    public static final String fAFFECTEDVERSIONID = "affectedVersionId";
    public static final String fAFFECTEDVERSION = "affectedVersion";
    public static final String fAFFECTEDCOMPONENTID = "affectedComponentId";
    public static final String fAFFECTEDCOMPONENT = "affectedComponent";

    private Long affectedVersionId;
    private String affectedVersion;
    private Long affectedComponentId;
    private String affectedComponent;

    public Long getAffectedVersionId() {
        return this.affectedVersionId;
    }

    public void setAffectedVersionId(Long affectedVersionId) {
        this.affectedVersionId = affectedVersionId;
    }

    public String getAffectedVersion() {
        return this.affectedVersion;
    }

    public void setAffectedVersion(String affectedVersion) {
        this.affectedVersion = affectedVersion;
    }

    public Long getAffectedComponentId() {
        return this.affectedComponentId;
    }

    public void setAffectedComponentId(Long affectedComponentId) {
        this.affectedComponentId = affectedComponentId;
    }

    public String getAffectedComponent() {
        return this.affectedComponent;
    }

    public void setAffectedComponent(String affectedComponent) {
        this.affectedComponent = affectedComponent;
    }

}
