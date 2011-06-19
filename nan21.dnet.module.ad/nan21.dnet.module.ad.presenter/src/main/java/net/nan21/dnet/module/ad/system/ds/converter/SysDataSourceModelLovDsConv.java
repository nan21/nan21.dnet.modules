/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDataSourceModelLovDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

public class SysDataSourceModelLovDsConv extends
        AbstractDsConverter<SysDataSourceModelLovDs, SysDataSource> implements
        IDsConverter<SysDataSourceModelLovDs, SysDataSource> {

    protected void modelToEntityAttributes(SysDataSourceModelLovDs ds,
            SysDataSource e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setModel(ds.getModel());
    }

    protected void modelToEntityReferences(SysDataSourceModelLovDs ds,
            SysDataSource e) throws Exception {
    }

    @Override
    public void entityToModel(SysDataSource e, SysDataSourceModelLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setModel(e.getModel());
    }

}
