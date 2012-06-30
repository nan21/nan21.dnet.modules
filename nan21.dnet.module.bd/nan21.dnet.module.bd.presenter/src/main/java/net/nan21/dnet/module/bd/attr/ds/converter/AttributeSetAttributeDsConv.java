/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.attr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeService;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeSetService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.attr.ds.model.AttributeSetAttributeDs;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSetAttribute;

public class AttributeSetAttributeDsConv extends
        AbstractDsConverter<AttributeSetAttributeDs, AttributeSetAttribute>
        implements IDsConverter<AttributeSetAttributeDs, AttributeSetAttribute> {

    @Override
    protected void modelToEntityReferences(AttributeSetAttributeDs ds,
            AttributeSetAttribute e, boolean isInsert) throws Exception {

        if (ds.getSetId() != null) {
            if (e.getAttributeSet() == null
                    || !e.getAttributeSet().getId().equals(ds.getSetId())) {
                e.setAttributeSet((AttributeSet) this.em.find(
                        AttributeSet.class, ds.getSetId()));
            }
        } else {
            this.lookup_attributeSet_AttributeSet(ds, e);
        }

        if (ds.getAttributeId() != null) {
            if (e.getAttribute() == null
                    || !e.getAttribute().getId().equals(ds.getAttributeId())) {
                e.setAttribute((Attribute) this.em.find(Attribute.class,
                        ds.getAttributeId()));
            }
        } else {
            this.lookup_attribute_Attribute(ds, e);
        }

    }

    protected void lookup_attributeSet_AttributeSet(AttributeSetAttributeDs ds,
            AttributeSetAttribute e) throws Exception {
        if (ds.getSet() != null && !ds.getSet().equals("")) {
            AttributeSet x = null;
            try {
                x = ((IAttributeSetService) findEntityService(AttributeSet.class))
                        .findByName(ds.getSet());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttributeSet` reference:  `set` = "
                                + ds.getSet() + "  ");
            }
            e.setAttributeSet(x);

        } else {
            e.setAttributeSet(null);
        }
    }

    protected void lookup_attribute_Attribute(AttributeSetAttributeDs ds,
            AttributeSetAttribute e) throws Exception {
        if (ds.getAttribute() != null && !ds.getAttribute().equals("")) {
            Attribute x = null;
            try {
                x = ((IAttributeService) findEntityService(Attribute.class))
                        .findByName(ds.getAttribute());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Attribute` reference:  `attribute` = "
                                + ds.getAttribute() + "  ");
            }
            e.setAttribute(x);

        } else {
            e.setAttribute(null);
        }
    }

}
