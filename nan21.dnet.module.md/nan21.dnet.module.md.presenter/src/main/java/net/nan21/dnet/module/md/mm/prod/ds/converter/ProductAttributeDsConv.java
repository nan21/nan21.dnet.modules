/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeTypeService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttribute;

public class ProductAttributeDsConv extends
        AbstractDsConverter<ProductAttributeDs, ProductAttribute> implements
        IDsConverter<ProductAttributeDs, ProductAttribute> {

    @Override
    protected void modelToEntityReferences(ProductAttributeDs ds,
            ProductAttribute e, boolean isInsert) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((ProductAttributeType) this.em.find(
                        ProductAttributeType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_ProductAttributeType(ds, e);
        }

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }

    }

    protected void lookup_type_ProductAttributeType(ProductAttributeDs ds,
            ProductAttribute e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            ProductAttributeType x = null;
            try {
                x = ((IProductAttributeTypeService) findEntityService(ProductAttributeType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttributeType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

    protected void lookup_uom_Uom(ProductAttributeDs ds, ProductAttribute e)
            throws Exception {
        if (ds.getUom() != null && !ds.getUom().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getUom());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `uom` = "
                                + ds.getUom() + "  ");
            }
            e.setUom(x);

        } else {
            e.setUom(null);
        }
    }

}
