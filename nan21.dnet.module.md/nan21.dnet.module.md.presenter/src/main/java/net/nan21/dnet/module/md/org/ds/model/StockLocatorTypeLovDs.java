/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;

@Ds(entity = StockLocatorType.class, jpqlWhere = " e.active = true ", sort = { @SortField(field = StockLocatorTypeLovDs.fNAME) })
public class StockLocatorTypeLovDs extends AbstractTypeLov<StockLocatorType> {

    public StockLocatorTypeLovDs() {
        super();
    }

    public StockLocatorTypeLovDs(StockLocatorType e) {
        super(e);
    }

}
