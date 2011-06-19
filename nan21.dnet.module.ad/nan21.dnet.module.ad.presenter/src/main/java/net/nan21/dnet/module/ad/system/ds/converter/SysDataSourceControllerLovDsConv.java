/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDataSourceControllerLovDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

public class SysDataSourceControllerLovDsConv extends
        AbstractDsConverter<SysDataSourceControllerLovDs, SysDataSource>
        implements IDsConverter<SysDataSourceControllerLovDs, SysDataSource> {

    protected void modelToEntityAttributes(SysDataSourceControllerLovDs ds,
            SysDataSource e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setController(ds.getController());
    }

    protected void modelToEntityReferences(SysDataSourceControllerLovDs ds,
            SysDataSource e) throws Exception {
    }

    @Override
    public void entityToModel(SysDataSource e, SysDataSourceControllerLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setController(e.getController());
    }

}
