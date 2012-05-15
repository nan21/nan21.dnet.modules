/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class OrganizationTypeDsFilter extends AbstractTypeDsFilter {

    private Boolean virtualEntity;

    private Boolean legalEntity;

    private Boolean accountingEnabled;

    private Boolean inventory;

    private Boolean external;

    private Boolean carrier;

    private Boolean warehouse;

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
