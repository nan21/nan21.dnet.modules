/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.system.business.service.ISysDataSourceService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDsEventDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;

public class SysDsEventDsConv extends
        AbstractDsConverter<SysDsEventDs, SysDsEvent> implements
        IDsConverter<SysDsEventDs, SysDsEvent> {

    protected void modelToEntityAttributes(SysDsEventDs ds, SysDsEvent e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setEventType(ds.getName());
    }

    protected void modelToEntityReferences(SysDsEventDs ds, SysDsEvent e)
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

    protected void lookup_dataSource_SysDataSource(SysDsEventDs ds, SysDsEvent e)
            throws Exception {
        SysDataSource x = null;
        try {
            x = ((ISysDataSourceService) getService(ISysDataSourceService.class))
                    .findByName(ds.getClientId(), ds.getDataSource());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setDataSource(x);
    }

    @Override
    public void entityToModel(SysDsEvent e, SysDsEventDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setName(e.getEventType());
        ds.setDataSourceId(((e.getDataSource() != null)) ? e.getDataSource()
                .getId() : null);
        ds.setDataSource(((e.getDataSource() != null)) ? e.getDataSource()
                .getName() : null);
    }

}
