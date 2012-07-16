/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

@Ds(entity = OrganizationType.class, sort = { @SortField(field = OrganizationTypeDs.fNAME) })
public class OrganizationTypeDs extends AbstractTypeDs<OrganizationType> {

    public static final String fVIRTUALENTITY = "virtualEntity";
    public static final String fLEGALENTITY = "legalEntity";
    public static final String fACCOUNTINGENABLED = "accountingEnabled";
    public static final String fINVENTORY = "inventory";
    public static final String fEXTERNAL = "external";
    public static final String fCARRIER = "carrier";
    public static final String fWAREHOUSE = "warehouse";

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

    @DsField()
    private Boolean warehouse;

    public OrganizationTypeDs() {
        super();
    }

    public OrganizationTypeDs(OrganizationType e) {
        super(e);
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

    public Boolean getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Boolean warehouse) {
        this.warehouse = warehouse;
    }

}
