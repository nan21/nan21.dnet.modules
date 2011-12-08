/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeCategoryService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeTypeDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeType;

public class ProductAttributeTypeDsConv extends
        AbstractDsConverter<ProductAttributeTypeDs, ProductAttributeType>
        implements IDsConverter<ProductAttributeTypeDs, ProductAttributeType> {

    protected void modelToEntityReferences(ProductAttributeTypeDs ds,
            ProductAttributeType e) throws Exception {
        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((ProductAttributeCategory) this.em.find(
                        ProductAttributeCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_ProductAttributeCategory(ds, e);
        }
    }

    protected void lookup_category_ProductAttributeCategory(
            ProductAttributeTypeDs ds, ProductAttributeType e) throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            ProductAttributeCategory x = null;
            try {
                x = ((IProductAttributeCategoryService) findEntityService(ProductAttributeCategory.class))
                        .findByName(ds.getClientId(), ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttributeCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

}
