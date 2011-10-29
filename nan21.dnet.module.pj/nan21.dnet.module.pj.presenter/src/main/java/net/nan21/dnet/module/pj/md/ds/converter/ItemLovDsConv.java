/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ItemLovDs;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

public class ItemLovDsConv extends AbstractDsConverter<ItemLovDs, Item>
        implements IDsConverter<ItemLovDs, Item> {

    protected void modelToEntityAttributes(ItemLovDs ds, Item e)
            throws Exception {
        e.setClientId(ds.getClientId());
    }

    protected void modelToEntityReferences(ItemLovDs ds, Item e)
            throws Exception {
    }

    @Override
    public void entityToModel(Item e, ItemLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
    }

}
