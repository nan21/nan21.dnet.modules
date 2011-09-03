/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomTypeService;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;
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
        if (ds.getUomTypeId() != null) {
            if (e.getUomType() == null
                    || !e.getUomType().getId().equals(ds.getUomTypeId())) {
                e.setUomType((UomType) this.em.getReference(UomType.class,
                        ds.getUomTypeId()));
            }
        } else {
            this.lookup_uomType_UomType(ds, e);
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

    protected void lookup_uomType_UomType(ProductAttributeDs ds,
            ProductAttribute e) throws Exception {
        if (ds.getUomType() != null) {
            UomType x = null;
            try {
                x = ((IUomTypeService) getService(IUomTypeService.class))
                        .findByName(ds.getClientId(), ds.getUomType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `UomType` reference:  `uomType` = "
                                + ds.getUomType() + "  ");
            }
            e.setUomType(x);
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
        ds.setUomTypeId(((e.getUomType() != null)) ? e.getUomType().getId()
                : null);
        ds.setUomType(((e.getUomType() != null)) ? e.getUomType().getName()
                : null);
    }

}
