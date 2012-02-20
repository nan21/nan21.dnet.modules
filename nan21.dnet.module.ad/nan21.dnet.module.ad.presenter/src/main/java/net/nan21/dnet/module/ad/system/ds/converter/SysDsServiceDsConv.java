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
import net.nan21.dnet.module.ad.system.ds.model.SysDsServiceDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

public class SysDsServiceDsConv extends
        AbstractDsConverter<SysDsServiceDs, SysDsService> implements
        IDsConverter<SysDsServiceDs, SysDsService> {

    @Override
    protected void modelToEntityReferences(SysDsServiceDs ds, SysDsService e,
            boolean isInsert) throws Exception {

        if (ds.getDataSourceId() != null) {
            if (e.getDataSource() == null
                    || !e.getDataSource().getId().equals(ds.getDataSourceId())) {
                e.setDataSource((SysDataSource) this.em.find(
                        SysDataSource.class, ds.getDataSourceId()));
            }
        } else {
            this.lookup_dataSource_SysDataSource(ds, e);
        }

    }

    protected void lookup_dataSource_SysDataSource(SysDsServiceDs ds,
            SysDsService e) throws Exception {
        if (ds.getDataSource() != null && !ds.getDataSource().equals("")) {
            SysDataSource x = null;
            try {
                x = ((ISysDataSourceService) findEntityService(SysDataSource.class))
                        .findByName(ds.getDataSource());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `SysDataSource` reference:  `dataSource` = "
                                + ds.getDataSource() + "  ");
            }
            e.setDataSource(x);

        } else {
            e.setDataSource(null);
        }
    }

}
