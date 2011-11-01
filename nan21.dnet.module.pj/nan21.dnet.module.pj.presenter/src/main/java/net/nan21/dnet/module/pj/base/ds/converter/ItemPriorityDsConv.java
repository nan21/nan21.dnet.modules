/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ItemPriorityDs;
import net.nan21.dnet.module.pj.base.domain.entity.ItemPriority;

public class ItemPriorityDsConv extends
        AbstractDsConverter<ItemPriorityDs, ItemPriority> implements
        IDsConverter<ItemPriorityDs, ItemPriority> {

    protected void modelToEntityAttributes(ItemPriorityDs ds, ItemPriority e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSortValue(ds.getSortValue());
    }

    protected void modelToEntityReferences(ItemPriorityDs ds, ItemPriority e)
            throws Exception {
    }

    @Override
    public void entityToModel(ItemPriority e, ItemPriorityDs ds)
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
        ds.setSortValue(e.getSortValue());
    }

}