/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.pj.base.business.service.IItemLinkTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.ItemLinkType;
import net.nan21.dnet.module.pj.md.domain.entity.Item;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.pj.md.ds.model.ItemLinkDs;
import net.nan21.dnet.module.pj.md.domain.entity.ItemLink;

public class ItemLinkDsConv extends AbstractDsConverter<ItemLinkDs, ItemLink>
        implements IDsConverter<ItemLinkDs, ItemLink> {

    protected void modelToEntityAttributes(ItemLinkDs ds, ItemLink e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ItemLinkDs ds, ItemLink e)
            throws Exception {

        if (ds.getSourceItemId() != null) {
            if (e.getSourceItem() == null
                    || !e.getSourceItem().getId().equals(ds.getSourceItemId())) {
                e.setSourceItem((Item) this.em.find(Item.class,
                        ds.getSourceItemId()));
            }
        }
        if (ds.getTargetItemId() != null) {
            if (e.getTargetItem() == null
                    || !e.getTargetItem().getId().equals(ds.getTargetItemId())) {
                e.setTargetItem((Item) this.em.find(Item.class,
                        ds.getTargetItemId()));
            }
        }
        if (ds.getLinkTypeId() != null) {
            if (e.getLinkType() == null
                    || !e.getLinkType().getId().equals(ds.getLinkTypeId())) {
                e.setLinkType((ItemLinkType) this.em.find(ItemLinkType.class,
                        ds.getLinkTypeId()));
            }
        } else {
            this.lookup_linkType_ItemLinkType(ds, e);
        }
    }

    protected void lookup_linkType_ItemLinkType(ItemLinkDs ds, ItemLink e)
            throws Exception {
        if (ds.getLinkType() != null && !ds.getLinkType().equals("")) {
            ItemLinkType x = null;
            try {
                x = ((IItemLinkTypeService) getService(IItemLinkTypeService.class))
                        .findByName(ds.getClientId(), ds.getLinkType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ItemLinkType` reference:  `linkType` = "
                                + ds.getLinkType() + "  ");
            }
            e.setLinkType(x);
        } else {
            e.setLinkType(null);
        }
    }

    @Override
    public void entityToModel(ItemLink e, ItemLinkDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSourceItemId(((e.getSourceItem() != null)) ? e.getSourceItem()
                .getId() : null);
        ds.setSourceItem(((e.getSourceItem() != null)) ? e.getSourceItem()
                .getSummary() : null);
        ds.setTargetItemId(((e.getTargetItem() != null)) ? e.getTargetItem()
                .getId() : null);
        ds.setTargetItem(((e.getTargetItem() != null)) ? e.getTargetItem()
                .getSummary() : null);
        ds.setLinkTypeId(((e.getLinkType() != null)) ? e.getLinkType().getId()
                : null);
        ds.setLinkType(((e.getLinkType() != null)) ? e.getLinkType().getName()
                : null);
    }

}
