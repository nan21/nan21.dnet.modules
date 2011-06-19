/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.service.ISysDataSourceService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDsServiceDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

public class SysDsServiceDsConv extends
        AbstractDsConverter<SysDsServiceDs, SysDsService> implements
        IDsConverter<SysDsServiceDs, SysDsService> {

    protected void modelToEntityAttributes(SysDsServiceDs ds, SysDsService e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(SysDsServiceDs ds, SysDsService e)
            throws Exception {

        if (ds.getDataSourceId() != null) {
            if (e.getDataSource() == null
                    || !e.getDataSource().getId().equals(ds.getDataSourceId())) {
                e.setDataSource((SysDataSource) this.em.getReference(
                        SysDataSource.class, ds.getDataSourceId()));
            }
        } else {
            this.lookup_dataSource_SysDataSource(ds, e);
        }
    }

    protected void lookup_dataSource_SysDataSource(SysDsServiceDs ds,
            SysDsService e) throws Exception {
        SysDataSource x = null;
        try {
            x = ((ISysDataSourceService) getService(ISysDataSourceService.class))
                    .findByName(ds.getClientId(), ds.getDataSource());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setDataSource(x);
    }

    @Override
    public void entityToModel(SysDsService e, SysDsServiceDs ds)
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
        ds.setDataSourceId(((e.getDataSource() != null)) ? e.getDataSource()
                .getId() : null);
        ds.setDataSource(((e.getDataSource() != null)) ? e.getDataSource()
                .getName() : null);
    }

}
