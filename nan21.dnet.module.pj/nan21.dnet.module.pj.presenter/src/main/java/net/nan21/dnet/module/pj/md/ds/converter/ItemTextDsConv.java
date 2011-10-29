/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IItemTextTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemTextType;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ItemTextDs;
import net.nan21.dnet.module.pj.md.domain.entity.ItemText;

public class ItemTextDsConv extends AbstractDsConverter<ItemTextDs, ItemText>
        implements IDsConverter<ItemTextDs, ItemText> {

    protected void modelToEntityAttributes(ItemTextDs ds, ItemText e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setContent(ds.getContent());
    }

    protected void modelToEntityReferences(ItemTextDs ds, ItemText e)
            throws Exception {

        if (ds.getItemId() != null) {
            if (e.getItem() == null
                    || !e.getItem().getId().equals(ds.getItemId())) {
                e.setItem((Item) this.em.find(Item.class, ds.getItemId()));
            }
        }
        if (ds.getItemTextTypeId() != null) {
            if (e.getItemTextType() == null
                    || !e.getItemTextType().getId()
                            .equals(ds.getItemTextTypeId())) {
                e.setItemTextType((ItemTextType) this.em.find(
                        ItemTextType.class, ds.getItemTextTypeId()));
            }
        } else {
            this.lookup_itemTextType_ItemTextType(ds, e);
        }
    }

    protected void lookup_itemTextType_ItemTextType(ItemTextDs ds, ItemText e)
            throws Exception {
        if (ds.getItemTextType() != null && !ds.getItemTextType().equals("")) {
            ItemTextType x = null;
            try {
                x = ((IItemTextTypeService) getService(IItemTextTypeService.class))
                        .findByName(ds.getClientId(), ds.getItemTextType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemTextType` reference:  `itemTextType` = "
                                + ds.getItemTextType() + "  ");
            }
            e.setItemTextType(x);
        } else {
            e.setItemTextType(null);
        }
    }

    @Override
    public void entityToModel(ItemText e, ItemTextDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setContent(e.getContent());
        ds.setItemId(((e.getItem() != null)) ? e.getItem().getId() : null);
        ds.setItemTextTypeId(((e.getItemTextType() != null)) ? e
                .getItemTextType().getId() : null);
        ds.setItemTextType(((e.getItemTextType() != null)) ? e
                .getItemTextType().getName() : null);
    }

}
