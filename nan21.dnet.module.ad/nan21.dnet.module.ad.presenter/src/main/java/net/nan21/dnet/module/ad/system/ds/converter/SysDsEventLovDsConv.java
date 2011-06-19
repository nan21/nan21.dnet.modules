/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDsEventLovDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;

public class SysDsEventLovDsConv extends
        AbstractDsConverter<SysDsEventLovDs, SysDsEvent> implements
        IDsConverter<SysDsEventLovDs, SysDsEvent> {

    protected void modelToEntityAttributes(SysDsEventLovDs ds, SysDsEvent e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setEventType(ds.getName());
    }

    protected void modelToEntityReferences(SysDsEventLovDs ds, SysDsEvent e)
            throws Exception {
    }

    @Override
    public void entityToModel(SysDsEvent e, SysDsEventLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getEventType());
        ds.setDataSourceId(((e.getDataSource() != null)) ? e.getDataSource()
                .getId() : null);
        ds.setDataSourceName(((e.getDataSource() != null)) ? e.getDataSource()
                .getName() : null);
    }

}
