/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.model.IModelWithClientId;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.presenter.model.AbstractDsModel;

import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = OrganizationType.class)
public class OrganizationTypeDs extends AbstractDsModel<OrganizationType>
        implements IModelWithId, IModelWithClientId {

    public static final String fNAME = "name";
    public static final String fACTIVE = "active";
    public static final String fDESCRIPTION = "description";
    public static final String fID = "id";
    public static final String fCLIENTID = "clientId";
    public static final String fCREATEDAT = "createdAt";
    public static final String fMODIFIEDAT = "modifiedAt";
    public static final String fCREATEDBY = "createdBy";
    public static final String fMODIFIEDBY = "modifiedBy";
    public static final String fVERSION = "version";
    public static final String fVIRTUALENTITY = "virtualEntity";
    public static final String fLEGALENTITY = "legalEntity";
    public static final String fACCOUNTINGENABLED = "accountingEnabled";
    public static final String fINVENTORY = "inventory";
    public static final String fEXTERNAL = "external";
    public static final String fCARRIER = "carrier";

    @DsField()
    private String name;

    @DsField()
    private Boolean active;

    @DsField()
    private String description;

    @DsField()
    private Long id;

    @DsField()
    private Long clientId;

    @DsField()
    private Date createdAt;

    @DsField()
    private Date modifiedAt;

    @DsField()
    private String createdBy;

    @DsField()
    private String modifiedBy;

    @DsField()
    private Long version;

    @DsField()
    private Boolean virtualEntity;

    @DsField()
    private Boolean legalEntity;

    @DsField()
    private Boolean accountingEnabled;

    @DsField()
    private Boolean inventory;

    @DsField()
    private Boolean external;

    @DsField()
    private Boolean carrier;

    public OrganizationTypeDs() {
        super();
    }

    public OrganizationTypeDs(OrganizationType e) {
        super(e);
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getVirtualEntity() {
        return this.virtualEntity;
    }

    public void setVirtualEntity(Boolean virtualEntity) {
        this.virtualEntity = virtualEntity;
    }

    public Boolean getLegalEntity() {
        return this.legalEntity;
    }

    public void setLegalEntity(Boolean legalEntity) {
        this.legalEntity = legalEntity;
    }

    public Boolean getAccountingEnabled() {
        return this.accountingEnabled;
    }

    public void setAccountingEnabled(Boolean accountingEnabled) {
        this.accountingEnabled = accountingEnabled;
    }

    public Boolean getInventory() {
        return this.inventory;
    }

    public void setInventory(Boolean inventory) {
        this.inventory = inventory;
    }

    public Boolean getExternal() {
        return this.external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    public Boolean getCarrier() {
        return this.carrier;
    }

    public void setCarrier(Boolean carrier) {
        this.carrier = carrier;
    }

}
