/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusLovDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderStatus;

public class SalesOrderStatusLovDsConv extends
        AbstractDsConverter<SalesOrderStatusLovDs, SalesOrderStatus> implements
        IDsConverter<SalesOrderStatusLovDs, SalesOrderStatus> {

    protected void modelToEntityAttributes(SalesOrderStatusLovDs ds,
            SalesOrderStatus e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setSequenceNo(ds.getSequenceNo());
    }

    protected void modelToEntityReferences(SalesOrderStatusLovDs ds,
            SalesOrderStatus e) throws Exception {
    }

    @Override
    public void entityToModel(SalesOrderStatus e, SalesOrderStatusLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setSequenceNo(e.getSequenceNo());
    }

}
