/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ItemResolutionLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.ItemResolution;

public class ItemResolutionLovDsConv extends
        AbstractDsConverter<ItemResolutionLovDs, ItemResolution> implements
        IDsConverter<ItemResolutionLovDs, ItemResolution> {

    protected void modelToEntityAttributes(ItemResolutionLovDs ds,
            ItemResolution e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ItemResolutionLovDs ds,
            ItemResolution e) throws Exception {
    }

    @Override
    public void entityToModel(ItemResolution e, ItemResolutionLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
