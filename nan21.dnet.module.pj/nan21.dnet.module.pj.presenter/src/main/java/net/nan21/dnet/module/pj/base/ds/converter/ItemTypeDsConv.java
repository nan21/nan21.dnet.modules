/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IItemCategoryService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.base.ds.model.ItemTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.ItemType;

public class ItemTypeDsConv extends AbstractDsConverter<ItemTypeDs, ItemType>
        implements IDsConverter<ItemTypeDs, ItemType> {

    protected void modelToEntityAttributes(ItemTypeDs ds, ItemType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ItemTypeDs ds, ItemType e)
            throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((ItemCategory) this.em.find(ItemCategory.class,
                        ds.getCategoryId()));
            }
        } else {
            this.lookup_category_ItemCategory(ds, e);
        }
    }

    protected void lookup_category_ItemCategory(ItemTypeDs ds, ItemType e)
            throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            ItemCategory x = null;
            try {
                x = ((IItemCategoryService) getService(IItemCategoryService.class))
                        .findByName(ds.getClientId(), ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);
        } else {
            e.setCategory(null);
        }
    }

    @Override
    public void entityToModel(ItemType e, ItemTypeDs ds) throws Exception {
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
        ds.setCategoryId(((e.getCategory() != null)) ? e.getCategory().getId()
                : null);
        ds.setCategory(((e.getCategory() != null)) ? e.getCategory().getName()
                : null);
    }

}
