/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Organization.class, jpqlWhere = " e.type.legalEntity = true ", sort = { @SortField(field = LegalEntityOrganizationLovDs.fCODE) })
public class LegalEntityOrganizationLovDs extends AbstractDsModel<Organization>
        implements IModelWithId, IModelWithClientId {

    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCODE = "code";
    public static final String fNAME = "name";
    public static final String fACTIVE = "active";
    public static final String fLEGALENTITY = "legalEntity";

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private String code;

    @DsField()
    private String name;

    @DsField()
    private Boolean active;

    @DsField(join = "left", path = "type.legalEntity")
    private Boolean legalEntity;

    public LegalEntityOrganizationLovDs() {
        super();
    }

    public LegalEntityOrganizationLovDs(Organization e) {
        super(e);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = this._asLong_(id);

    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getLegalEntity() {
        return this.legalEntity;
    }

    public void setLegalEntity(Boolean legalEntity) {
        this.legalEntity = legalEntity;
    }

}
