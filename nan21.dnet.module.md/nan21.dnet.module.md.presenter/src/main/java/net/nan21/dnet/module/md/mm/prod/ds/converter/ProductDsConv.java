/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeSetService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductManufacturerService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.mm.prod.ds.model.ProductDs;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

public class ProductDsConv extends AbstractDsConverter<ProductDs, Product>
        implements IDsConverter<ProductDs, Product> {

    @Override
    protected void modelToEntityReferences(ProductDs ds, Product e,
            boolean isInsert) throws Exception {

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

        if (ds.getAttributeSetId() != null) {
            if (e.getAttributeSet() == null
                    || !e.getAttributeSet().getId()
                            .equals(ds.getAttributeSetId())) {
                e.setAttributeSet((AttributeSet) this.em.find(
                        AttributeSet.class, ds.getAttributeSetId()));
            }
        } else {
            this.lookup_attributeSet_AttributeSet(ds, e);
        }

    }

    protected void lookup_manufacturer_ProductManufacturer(ProductDs ds,
            Product e) throws Exception {
        if (ds.getManufacturerCode() != null
                && !ds.getManufacturerCode().equals("")) {
            ProductManufacturer x = null;
            try {
                x = ((IProductManufacturerService) findEntityService(ProductManufacturer.class))
                        .findByCode(ds.getManufacturerCode());
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
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getDefaultUomCode());
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
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getDimUomCode());
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
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getVolumeUomCode());
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
                x = ((IUomService) findEntityService(Uom.class)).findByCode(ds
                        .getWeightUomCode());
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

    protected void lookup_attributeSet_AttributeSet(ProductDs ds, Product e)
            throws Exception {
        if (ds.getAttributeSet() != null && !ds.getAttributeSet().equals("")) {
            AttributeSet x = null;
            try {
                x = ((IAttributeSetService) findEntityService(AttributeSet.class))
                        .findByName(ds.getAttributeSet());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttributeSet` reference:  `attributeSet` = "
                                + ds.getAttributeSet() + "  ");
            }
            e.setAttributeSet(x);

        } else {
            e.setAttributeSet(null);
        }
    }

}
