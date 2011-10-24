/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.mm.md.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.mm.md.business.service.IProductAttributeGroupService;
import net.nan21.dnet.module.mm.md.business.service.IProductManufacturerService;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttributeGroup;
import net.nan21.dnet.module.mm.md.domain.entity.ProductManufacturer;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.mm.md.ds.model.ProductDs;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

public class ProductDsConv extends AbstractDsConverter<ProductDs, Product>
        implements IDsConverter<ProductDs, Product> {

    protected void modelToEntityAttributes(ProductDs ds, Product e)
            throws Exception {
        e.setName(ds.getName());
        e.setCode(ds.getCode());
        e.setActive(ds.getActive());
        e.setNotes(ds.getNotes());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setStorable(ds.getStorable());
        e.setWeight(ds.getWeight());
        e.setVolume(ds.getVolume());
        e.setDimWidth(ds.getDimWidth());
        e.setDimHeight(ds.getDimHeight());
        e.setDimDepth(ds.getDimDepth());
        e.setManufacturerProductNo(ds.getManufacturerProductNo());
        e.setClassName(ds.getClassName());
        e.setBusinessObject(ds.getBusinessObject());
    }

    protected void modelToEntityReferences(ProductDs ds, Product e)
            throws Exception {

        if (ds.getManufacturerId() != null) {
            if (e.getManufacturer() == null
                    || !e.getManufacturer().getId()
                            .equals(ds.getManufacturerId())) {
                e.setManufacturer((ProductManufacturer) this.em.find(
                        ProductManufacturer.class, ds.getManufacturerId()));
            }
        } else {
            this.lookup_manufacturer_ProductManufacturer(ds, e);
        }
        if (ds.getDefaultUomId() != null) {
            if (e.getDefaultUom() == null
                    || !e.getDefaultUom().getId().equals(ds.getDefaultUomId())) {
                e.setDefaultUom((Uom) this.em.find(Uom.class,
                        ds.getDefaultUomId()));
            }
        } else {
            this.lookup_defaultUom_Uom(ds, e);
        }
        if (ds.getDimUomId() != null) {
            if (e.getDimUom() == null
                    || !e.getDimUom().getId().equals(ds.getDimUomId())) {
                e.setDimUom((Uom) this.em.find(Uom.class, ds.getDimUomId()));
            }
        } else {
            this.lookup_dimUom_Uom(ds, e);
        }
        if (ds.getVolumeUomId() != null) {
            if (e.getVolumeUom() == null
                    || !e.getVolumeUom().getId().equals(ds.getVolumeUomId())) {
                e.setVolumeUom((Uom) this.em.find(Uom.class,
                        ds.getVolumeUomId()));
            }
        } else {
            this.lookup_volumeUom_Uom(ds, e);
        }
        if (ds.getWeightUomId() != null) {
            if (e.getWeightUom() == null
                    || !e.getWeightUom().getId().equals(ds.getWeightUomId())) {
                e.setWeightUom((Uom) this.em.find(Uom.class,
                        ds.getWeightUomId()));
            }
        } else {
            this.lookup_weightUom_Uom(ds, e);
        }
        if (ds.getAttributeGroupId() != null) {
            if (e.getAttributeGroup() == null
                    || !e.getAttributeGroup().getId()
                            .equals(ds.getAttributeGroupId())) {
                e.setAttributeGroup((ProductAttributeGroup) this.em.find(
                        ProductAttributeGroup.class, ds.getAttributeGroupId()));
            }
        } else {
            this.lookup_attributeGroup_ProductAttributeGroup(ds, e);
        }
    }

    protected void lookup_manufacturer_ProductManufacturer(ProductDs ds,
            Product e) throws Exception {
        if (ds.getManufacturerCode() != null
                && !ds.getManufacturerCode().equals("")) {
            ProductManufacturer x = null;
            try {
                x = ((IProductManufacturerService) getService(IProductManufacturerService.class))
                        .findByCode(ds.getClientId(), ds.getManufacturerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductManufacturer` reference:  `manufacturerCode` = "
                                + ds.getManufacturerCode() + "  ");
            }
            e.setManufacturer(x);
        } else {
            e.setManufacturer(null);
        }
    }

    protected void lookup_defaultUom_Uom(ProductDs ds, Product e)
            throws Exception {
        if (ds.getDefaultUomCode() != null
                && !ds.getDefaultUomCode().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) getService(IUomService.class)).findByCode(
                        ds.getClientId(), ds.getDefaultUomCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `defaultUomCode` = "
                                + ds.getDefaultUomCode() + "  ");
            }
            e.setDefaultUom(x);
        } else {
            e.setDefaultUom(null);
        }
    }

    protected void lookup_dimUom_Uom(ProductDs ds, Product e) throws Exception {
        if (ds.getDimUomCode() != null && !ds.getDimUomCode().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) getService(IUomService.class)).findByCode(
                        ds.getClientId(), ds.getDimUomCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `dimUomCode` = "
                                + ds.getDimUomCode() + "  ");
            }
            e.setDimUom(x);
        } else {
            e.setDimUom(null);
        }
    }

    protected void lookup_volumeUom_Uom(ProductDs ds, Product e)
            throws Exception {
        if (ds.getVolumeUomCode() != null && !ds.getVolumeUomCode().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) getService(IUomService.class)).findByCode(
                        ds.getClientId(), ds.getVolumeUomCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `volumeUomCode` = "
                                + ds.getVolumeUomCode() + "  ");
            }
            e.setVolumeUom(x);
        } else {
            e.setVolumeUom(null);
        }
    }

    protected void lookup_weightUom_Uom(ProductDs ds, Product e)
            throws Exception {
        if (ds.getWeightUomCode() != null && !ds.getWeightUomCode().equals("")) {
            Uom x = null;
            try {
                x = ((IUomService) getService(IUomService.class)).findByCode(
                        ds.getClientId(), ds.getWeightUomCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Uom` reference:  `weightUomCode` = "
                                + ds.getWeightUomCode() + "  ");
            }
            e.setWeightUom(x);
        } else {
            e.setWeightUom(null);
        }
    }

    protected void lookup_attributeGroup_ProductAttributeGroup(ProductDs ds,
            Product e) throws Exception {
        if (ds.getAttributeGroup() != null
                && !ds.getAttributeGroup().equals("")) {
            ProductAttributeGroup x = null;
            try {
                x = ((IProductAttributeGroupService) getService(IProductAttributeGroupService.class))
                        .findByName(ds.getClientId(), ds.getAttributeGroup());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ProductAttributeGroup` reference:  `attributeGroup` = "
                                + ds.getAttributeGroup() + "  ");
            }
            e.setAttributeGroup(x);
        } else {
            e.setAttributeGroup(null);
        }
    }

    @Override
    public void entityToModel(Product e, ProductDs ds) throws Exception {
        ds.setName(e.getName());
        ds.setCode(e.getCode());
        ds.setActive(e.getActive());
        ds.setNotes(e.getNotes());
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setStorable(e.getStorable());
        ds.setWeight(e.getWeight());
        ds.setVolume(e.getVolume());
        ds.setDimWidth(e.getDimWidth());
        ds.setDimHeight(e.getDimHeight());
        ds.setDimDepth(e.getDimDepth());
        ds.setManufacturerProductNo(e.getManufacturerProductNo());
        ds.setClassName(e.getClassName());
        ds.setBusinessObject(e.getBusinessObject());
        ds.setDefaultUomId(((e.getDefaultUom() != null)) ? e.getDefaultUom()
                .getId() : null);
        ds.setDefaultUomCode(((e.getDefaultUom() != null)) ? e.getDefaultUom()
                .getCode() : null);
        ds.setWeightUomId(((e.getWeightUom() != null)) ? e.getWeightUom()
                .getId() : null);
        ds.setWeightUomCode(((e.getWeightUom() != null)) ? e.getWeightUom()
                .getCode() : null);
        ds.setVolumeUomId(((e.getVolumeUom() != null)) ? e.getVolumeUom()
                .getId() : null);
        ds.setVolumeUomCode(((e.getVolumeUom() != null)) ? e.getVolumeUom()
                .getCode() : null);
        ds.setDimUomId(((e.getDimUom() != null)) ? e.getDimUom().getId() : null);
        ds.setDimUomCode(((e.getDimUom() != null)) ? e.getDimUom().getCode()
                : null);
        ds.setManufacturerId(((e.getManufacturer() != null)) ? e
                .getManufacturer().getId() : null);
        ds.setManufacturerCode(((e.getManufacturer() != null)) ? e
                .getManufacturer().getCode() : null);
        ds.setAttributeGroupId(((e.getAttributeGroup() != null)) ? e
                .getAttributeGroup().getId() : null);
        ds.setAttributeGroup(((e.getAttributeGroup() != null)) ? e
                .getAttributeGroup().getName() : null);
    }

}
