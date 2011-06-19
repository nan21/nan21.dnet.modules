/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.system.ds.model.SysDsFieldLovDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;

public class SysDsFieldLovDsConv extends
        AbstractDsConverter<SysDsFieldLovDs, SysDsField> implements
        IDsConverter<SysDsFieldLovDs, SysDsField> {

    protected void modelToEntityAttributes(SysDsFieldLovDs ds, SysDsField e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDataType(ds.getDataType());
    }

    protected void modelToEntityReferences(SysDsFieldLovDs ds, SysDsField e)
            throws Exception {
    }

    @Override
    public void entityToModel(SysDsField e, SysDsFieldLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setDataType(e.getDataType());
        ds.setDataSourceId(((e.getDataSource() != null)) ? e.getDataSource()
                .getId() : null);
        ds.setDataSourceName(((e.getDataSource() != null)) ? e.getDataSource()
                .getName() : null);
    }

}
