/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDsServiceLovDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

public class SysDsServiceLovDsConv extends
        AbstractDsConverter<SysDsServiceLovDs, SysDsService> implements
        IDsConverter<SysDsServiceLovDs, SysDsService> {

    protected void modelToEntityAttributes(SysDsServiceLovDs ds, SysDsService e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(SysDsServiceLovDs ds, SysDsService e)
            throws Exception {
    }

    @Override
    public void entityToModel(SysDsService e, SysDsServiceLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDataSourceId(((e.getDataSource() != null)) ? e.getDataSource()
                .getId() : null);
        ds.setDataSourceName(((e.getDataSource() != null)) ? e.getDataSource()
                .getName() : null);
    }

}
