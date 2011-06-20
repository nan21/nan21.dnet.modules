/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderStatus;

public class SalesOrderStatusDsConv extends
        AbstractDsConverter<SalesOrderStatusDs, SalesOrderStatus> implements
        IDsConverter<SalesOrderStatusDs, SalesOrderStatus> {

    protected void modelToEntityAttributes(SalesOrderStatusDs ds,
            SalesOrderStatus e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSequenceNo(ds.getSequenceNo());
    }

    protected void modelToEntityReferences(SalesOrderStatusDs ds,
            SalesOrderStatus e) throws Exception {
    }

    @Override
    public void entityToModel(SalesOrderStatus e, SalesOrderStatusDs ds)
            throws Exception {
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDescription(e.getDescription());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSequenceNo(e.getSequenceNo());
    }

}
