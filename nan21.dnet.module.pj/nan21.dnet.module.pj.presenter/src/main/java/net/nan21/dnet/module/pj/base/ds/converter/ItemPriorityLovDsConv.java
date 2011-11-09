/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ItemPriorityLovDs;
import net.nan21.dnet.module.pj.base.domain.entity.ItemPriority;

public class ItemPriorityLovDsConv extends
        AbstractDsConverter<ItemPriorityLovDs, ItemPriority> implements
        IDsConverter<ItemPriorityLovDs, ItemPriority> {

    protected void modelToEntityAttributes(ItemPriorityLovDs ds, ItemPriority e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setSequenceNo(ds.getSequenceNo());
    }

    protected void modelToEntityReferences(ItemPriorityLovDs ds, ItemPriority e)
            throws Exception {
    }

    @Override
    public void entityToModel(ItemPriority e, ItemPriorityLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setSequenceNo(e.getSequenceNo());
    }

}
