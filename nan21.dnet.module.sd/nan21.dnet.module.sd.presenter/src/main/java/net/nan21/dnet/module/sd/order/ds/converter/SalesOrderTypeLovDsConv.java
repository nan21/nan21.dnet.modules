/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeLovDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderType;

public class SalesOrderTypeLovDsConv extends
        AbstractDsConverter<SalesOrderTypeLovDs, SalesOrderType> implements
        IDsConverter<SalesOrderTypeLovDs, SalesOrderType> {

    protected void modelToEntityAttributes(SalesOrderTypeLovDs ds,
            SalesOrderType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(SalesOrderTypeLovDs ds,
            SalesOrderType e) throws Exception {
    }

    @Override
    public void entityToModel(SalesOrderType e, SalesOrderTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
