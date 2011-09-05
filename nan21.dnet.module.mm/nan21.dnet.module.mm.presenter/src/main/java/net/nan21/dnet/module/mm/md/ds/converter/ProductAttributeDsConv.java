/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeTypeService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductAttributeDs;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;

public class ProductAttributeDsConv extends
        AbstractDsConverter<ProductAttributeDs, ProductAttribute> implements
        IDsConverter<ProductAttributeDs, ProductAttribute> {

    protected void modelToEntityAttributes(ProductAttributeDs ds,
            ProductAttribute e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setTitle(ds.getTitle());
        e.setDataType(ds.getDataType());
    }

    protected void modelToEntityReferences(ProductAttributeDs ds,
            ProductAttribute e) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((ProductAttributeType) this.em.getReference(
                        ProductAttributeType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_ProductAttributeType(ds, e);
        }
        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.getReference(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }
    }

    protected void lookup_type_ProductAttributeType(ProductAttributeDs ds,
            ProductAttribute e) throws Exception {
        if (ds.getType() != null) {
            ProductAttributeType x = null;
            try {
                x = ((IProductAttributeTypeService) getService(IProductAttributeTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttributeType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        }
    }

    protected void lookup_uom_Uom(ProductAttributeDs ds, ProductAttribute e)
            throws Exception {
        if (ds.getUom() != null) {
            Uom x = null;
            try {
                x = ((IUomService) getService(IUomService.class)).findByName(
                        ds.getClientId(), ds.getUom());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `uom` = "
                                + ds.getUom() + "  ");
            }
            e.setUom(x);
        }
    }

    @Override
    public void entityToModel(ProductAttribute e, ProductAttributeDs ds)
            throws Exception {
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
        ds.setTitle(e.getTitle());
        ds.setDataType(e.getDataType());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
        ds.setUomId(((e.getUom() != null)) ? e.getUom().getId() : null);
        ds.setUom(((e.getUom() != null)) ? e.getUom().getName() : null);
    }

}
