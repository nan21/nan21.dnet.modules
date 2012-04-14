/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;

import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Organization.class, jpqlWhere = " e.type.warehouse = true ", sort = { @SortField(field = WarehouseOrganizationLovDs.fCODE) })
public class WarehouseOrganizationLovDs extends
        AbstractTypeWithCodeLov<Organization> {

    public static final String fWAREHOUSE = "warehouse";

    @DsField(join = "left", path = "type.warehouse")
    private Boolean warehouse;

    public WarehouseOrganizationLovDs() {
        super();
    }

    public WarehouseOrganizationLovDs(Organization e) {
        super(e);
    }

    public Boolean getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Boolean warehouse) {
        this.warehouse = warehouse;
    }

}
