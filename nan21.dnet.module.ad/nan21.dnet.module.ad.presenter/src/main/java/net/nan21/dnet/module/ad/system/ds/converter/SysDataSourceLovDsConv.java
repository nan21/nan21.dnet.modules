/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDataSourceLovDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

public class SysDataSourceLovDsConv extends
        AbstractDsConverter<SysDataSourceLovDs, SysDataSource> implements
        IDsConverter<SysDataSourceLovDs, SysDataSource> {

    protected void modelToEntityAttributes(SysDataSourceLovDs ds,
            SysDataSource e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(SysDataSourceLovDs ds,
            SysDataSource e) throws Exception {
    }

    @Override
    public void entityToModel(SysDataSource e, SysDataSourceLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
