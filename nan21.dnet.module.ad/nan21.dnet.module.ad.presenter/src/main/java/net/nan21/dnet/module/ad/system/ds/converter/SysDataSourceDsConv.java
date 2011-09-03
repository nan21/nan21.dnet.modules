/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDataSourceDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

public class SysDataSourceDsConv extends
        AbstractDsConverter<SysDataSourceDs, SysDataSource> implements
        IDsConverter<SysDataSourceDs, SysDataSource> {

    protected void modelToEntityAttributes(SysDataSourceDs ds, SysDataSource e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setModel(ds.getModel());
    }

    protected void modelToEntityReferences(SysDataSourceDs ds, SysDataSource e)
            throws Exception {
    }

    @Override
    public void entityToModel(SysDataSource e, SysDataSourceDs ds)
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
        ds.setModel(e.getModel());
    }

}
