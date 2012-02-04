/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;
import net.nan21.dnet.module.mm.md.business.service.IProductService;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttachment;

public class ProductAttachmentDsConv extends
        AbstractDsConverter<ProductAttachmentDs, ProductAttachment> implements
        IDsConverter<ProductAttachmentDs, ProductAttachment> {

    protected void modelToEntityReferences(ProductAttachmentDs ds,
            ProductAttachment e) throws Exception {
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttachmentType) this.em.find(AttachmentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttachmentType(ds, e);
        }
        if (ds.getProductId() != null) {
            if (e.getProduct() == null
                    || !e.getProduct().getId().equals(ds.getProductId())) {
                e.setProduct((Product) this.em.find(Product.class,
                        ds.getProductId()));
            }
        } else {
            this.lookup_product_Product(ds, e);
        }
    }

    protected void lookup_type_AttachmentType(ProductAttachmentDs ds,
            ProductAttachment e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AttachmentType x = null;
            try {
                x = ((IAttachmentTypeService) findEntityService(AttachmentType.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttachmentType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_product_Product(ProductAttachmentDs ds,
            ProductAttachment e) throws Exception {
        if (ds.getProduct() != null && !ds.getProduct().equals("")) {
            Product x = null;
            try {
                x = ((IProductService) findEntityService(Product.class))
                        .findByCode(ds.getClientId(), ds.getProduct());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Product` reference:  `product` = "
                                + ds.getProduct() + "  ");
            }
            e.setProduct(x);

        } else {
            e.setProduct(null);
        }
    }

}
