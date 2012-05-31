/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.uom.business.service.IUomService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeTypeService;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.base.attr.ds.model.AttributeDs;
import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;

public class AttributeDsConv extends
        AbstractDsConverter<AttributeDs, Attribute> implements
        IDsConverter<AttributeDs, Attribute> {

    @Override
    protected void modelToEntityReferences(AttributeDs ds, Attribute e,
            boolean isInsert) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttributeType) this.em.find(AttributeType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttributeType(ds, e);
        }

        if (ds.getUomId() != null) {
            if (e.getUom() == null || !e.getUom().getId().equals(ds.getUomId())) {
                e.setUom((Uom) this.em.find(Uom.class, ds.getUomId()));
            }
        } else {
            this.lookup_uom_Uom(ds, e);
        }

    }

    protected void lookup_type_AttributeType(AttributeDs ds, Attribute e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AttributeType x = null;
            try {
                x = ((IAttributeTypeService) findEntityService(AttributeType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttributeType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
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
