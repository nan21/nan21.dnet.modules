/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentTypeLovDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachmentType;

public class ProductAttachmentTypeLovDsConv extends
        AbstractDsConverter<ProductAttachmentTypeLovDs, ProductAttachmentType>
        implements
        IDsConverter<ProductAttachmentTypeLovDs, ProductAttachmentType> {

    protected void modelToEntityAttributes(ProductAttachmentTypeLovDs ds,
            ProductAttachmentType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ProductAttachmentTypeLovDs ds,
            ProductAttachmentType e) throws Exception {
    }

    @Override
    public void entityToModel(ProductAttachmentType e,
            ProductAttachmentTypeLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
