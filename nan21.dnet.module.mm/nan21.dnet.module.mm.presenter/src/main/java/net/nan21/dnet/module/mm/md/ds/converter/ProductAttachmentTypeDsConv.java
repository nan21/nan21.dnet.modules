/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentTypeDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachmentType;

public class ProductAttachmentTypeDsConv extends
        AbstractDsConverter<ProductAttachmentTypeDs, ProductAttachmentType>
        implements IDsConverter<ProductAttachmentTypeDs, ProductAttachmentType> {

    protected void modelToEntityAttributes(ProductAttachmentTypeDs ds,
            ProductAttachmentType e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setCategory(ds.getCategory());
        e.setUploadPath(ds.getUploadPath());
        e.setBaseUrl(ds.getBaseUrl());
    }

    protected void modelToEntityReferences(ProductAttachmentTypeDs ds,
            ProductAttachmentType e) throws Exception {
    }

    @Override
    public void entityToModel(ProductAttachmentType e,
            ProductAttachmentTypeDs ds) throws Exception {
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
        ds.setCategory(e.getCategory());
        ds.setUploadPath(e.getUploadPath());
        ds.setBaseUrl(e.getBaseUrl());
    }

}
