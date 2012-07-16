/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

@Ds(entity = Organization.class, jpqlWhere = " e.type.inventory = true ", sort = { @SortField(field = InventoryOrganizationLovDs.fCODE) })
public class InventoryOrganizationLovDs extends
        AbstractTypeWithCodeLov<Organization> {

    public static final String fINVENTORY = "inventory";

    @DsField(join = "left", path = "type.inventory")
    private Boolean inventory;

    public InventoryOrganizationLovDs() {
        super();
    }

    public InventoryOrganizationLovDs(Organization e) {
        super(e);
    }

    public Boolean getInventory() {
        return this.inventory;
    }

    public void setInventory(Boolean inventory) {
        this.inventory = inventory;
    }

}
