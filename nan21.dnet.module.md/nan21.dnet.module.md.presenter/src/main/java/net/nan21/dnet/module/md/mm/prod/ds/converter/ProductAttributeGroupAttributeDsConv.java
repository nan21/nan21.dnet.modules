/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeGroupService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeGroup;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeGroupAttributeDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeGroupAttribute;

public class ProductAttributeGroupAttributeDsConv
        extends
        AbstractDsConverter<ProductAttributeGroupAttributeDs, ProductAttributeGroupAttribute>
        implements
        IDsConverter<ProductAttributeGroupAttributeDs, ProductAttributeGroupAttribute> {

    @Override
    protected void modelToEntityReferences(ProductAttributeGroupAttributeDs ds,
            ProductAttributeGroupAttribute e, boolean isInsert)
            throws Exception {

        if (ds.getGroupId() != null) {
            if (e.getGroup() == null
                    || !e.getGroup().getId().equals(ds.getGroupId())) {
                e.setGroup((ProductAttributeGroup) this.em.find(
                        ProductAttributeGroup.class, ds.getGroupId()));
            }
        } else {
            this.lookup_group_ProductAttributeGroup(ds, e);
        }

        if (ds.getAttributeId() != null) {
            if (e.getAttribute() == null
                    || !e.getAttribute().getId().equals(ds.getAttributeId())) {
                e.setAttribute((ProductAttribute) this.em.find(
                        ProductAttribute.class, ds.getAttributeId()));
            }
        } else {
            this.lookup_attribute_ProductAttribute(ds, e);
        }

    }

    protected void lookup_group_ProductAttributeGroup(
            ProductAttributeGroupAttributeDs ds,
            ProductAttributeGroupAttribute e) throws Exception {
        if (ds.getGroup() != null && !ds.getGroup().equals("")) {
            ProductAttributeGroup x = null;
            try {
                x = ((IProductAttributeGroupService) findEntityService(ProductAttributeGroup.class))
                        .findByName(ds.getGroup());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttributeGroup` reference:  `group` = "
                                + ds.getGroup() + "  ");
            }
            e.setGroup(x);

        } else {
            e.setGroup(null);
        }
    }

    protected void lookup_attribute_ProductAttribute(
            ProductAttributeGroupAttributeDs ds,
            ProductAttributeGroupAttribute e) throws Exception {
        if (ds.getAttribute() != null && !ds.getAttribute().equals("")) {
            ProductAttribute x = null;
            try {
                x = ((IProductAttributeService) findEntityService(ProductAttribute.class))
                        .findByName(ds.getAttribute());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttribute` reference:  `attribute` = "
                                + ds.getAttribute() + "  ");
            }
            e.setAttribute(x);

        } else {
            e.setAttribute(null);
        }
    }

}
