/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;

@Ds(entity = BpAccount.class, jpqlWhere = " e.vendor = true ")
public class VendorLovDs extends AbstractAuditableLov<BpAccount> {

    public static final String fBPARTNERID = "bpartnerId";
    public static final String fCODE = "code";
    public static final String fNAME = "name";
    public static final String fORGID = "orgId";
    public static final String fORG = "org";

    @DsField(join = "left", path = "bpartner.id")
    private Long bpartnerId;

    @DsField(join = "left", path = "bpartner.code")
    private String code;

    @DsField(join = "left", path = "bpartner.name")
    private String name;

    @DsField(join = "left", path = "org.id")
    private Long orgId;

    @DsField(join = "left", path = "org.code")
    private String org;

    public VendorLovDs() {
        super();
    }

    public VendorLovDs(BpAccount e) {
        super(e);
    }

    public Long getBpartnerId() {
        return this.bpartnerId;
    }

    public void setBpartnerId(Long bpartnerId) {
        this.bpartnerId = bpartnerId;
    }

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

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrg() {
        return this.org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

}
