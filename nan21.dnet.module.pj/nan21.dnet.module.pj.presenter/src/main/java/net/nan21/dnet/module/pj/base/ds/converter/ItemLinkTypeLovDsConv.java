/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ItemLinkTypeLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.ItemLinkType;

public class ItemLinkTypeLovDsConv extends
        AbstractDsConverter<ItemLinkTypeLovDs, ItemLinkType> implements
        IDsConverter<ItemLinkTypeLovDs, ItemLinkType> {

    protected void modelToEntityAttributes(ItemLinkTypeLovDs ds, ItemLinkType e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ItemLinkTypeLovDs ds, ItemLinkType e)
            throws Exception {
    }

    @Override
    public void entityToModel(ItemLinkType e, ItemLinkTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
