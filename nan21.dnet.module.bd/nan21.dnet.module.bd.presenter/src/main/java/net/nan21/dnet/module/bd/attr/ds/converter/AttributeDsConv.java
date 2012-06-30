/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeCategoryService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeCategory;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.attr.ds.model.AttributeDs;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;

public class AttributeDsConv extends
        AbstractDsConverter<AttributeDs, Attribute> implements
        IDsConverter<AttributeDs, Attribute> {

    @Override
    protected void modelToEntityReferences(AttributeDs ds, Attribute e,
            boolean isInsert) throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((AttributeCategory) this.em.find(
                        AttributeCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_AttributeCategory(ds, e);
        }

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }

    }

    protected void lookup_category_AttributeCategory(AttributeDs ds, Attribute e)
            throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            AttributeCategory x = null;
            try {
                x = ((IAttributeCategoryService) findEntityService(AttributeCategory.class))
                        .findByName(ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttributeCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

    protected void lookup_uom_Uom(AttributeDs ds, Attribute e) throws Exception {
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
