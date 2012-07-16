/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

@Ds(entity = SubInventory.class, sort = { @SortField(field = SubInventoryDs.fNAME) })
public class SubInventoryDs extends AbstractTypeDs<SubInventory> {

    public static final String fINVENTORYID = "inventoryId";
    public static final String fINVENTORY = "inventory";

    @DsField(join = "left", path = "inventory.id")
    private Long inventoryId;

    @DsField(join = "left", path = "inventory.code")
    private String inventory;

    public SubInventoryDs() {
        super();
    }

    public SubInventoryDs(SubInventory e) {
        super(e);
    }

    public Long getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventory() {
        return this.inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

}
