/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;

import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = StockLocator.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = StockLocatorLovDs.fNAME) })
public class StockLocatorLovDs extends AbstractTypeLov<StockLocator> {

    public static final String fSUBINVENTORYID = "subInventoryId";

    @DsField(join = "left", path = "subInventory.id")
    private Long subInventoryId;

    public StockLocatorLovDs() {
        super();
    }

    public StockLocatorLovDs(StockLocator e) {
        super(e);
    }

    public Long getSubInventoryId() {
        return this.subInventoryId;
    }

    public void setSubInventoryId(Long subInventoryId) {
        this.subInventoryId = subInventoryId;
    }

}
