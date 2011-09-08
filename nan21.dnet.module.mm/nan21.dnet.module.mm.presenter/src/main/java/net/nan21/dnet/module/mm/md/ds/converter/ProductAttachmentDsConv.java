/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.md.business.service.IProductAttachmentTypeService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachmentType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachment;

public class ProductAttachmentDsConv extends
        AbstractDsConverter<ProductAttachmentDs, ProductAttachment> implements
        IDsConverter<ProductAttachmentDs, ProductAttachment> {

    protected void modelToEntityAttributes(ProductAttachmentDs ds,
            ProductAttachment e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setName(ds.getName());
        e.setLocation(ds.getLocation());
        e.setNotes(ds.getNotes());
    }

    protected void modelToEntityReferences(ProductAttachmentDs ds,
            ProductAttachment e) throws Exception {

        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.getReference(Product.class,
                        ds.getProductId()));
            }
        }
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((ProductAttachmentType) this.em.getReference(
                        ProductAttachmentType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_ProductAttachmentType(ds, e);
        }
    }

    protected void lookup_type_ProductAttachmentType(ProductAttachmentDs ds,
            ProductAttachment e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            ProductAttachmentType x = null;
            try {
                x = ((IProductAttachmentTypeService) getService(IProductAttachmentTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttachmentType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        }
    }

    @Override
    public void entityToModel(ProductAttachment e, ProductAttachmentDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setName(e.getName());
        ds.setLocation(e.getLocation());
        ds.setNotes(e.getNotes());
        ds.setProductId(((e.getProduct() != null)) ? e.getProduct().getId()
                : null);
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
