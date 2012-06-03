/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeGroupService;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeService;
import net.nan21.dnet.module.md.base.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroup;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.base.attr.ds.model.AttributeGroupAttributeDs;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeGroupAttribute;

public class AttributeGroupAttributeDsConv extends
        AbstractDsConverter<AttributeGroupAttributeDs, AttributeGroupAttribute>
        implements
        IDsConverter<AttributeGroupAttributeDs, AttributeGroupAttribute> {

    @Override
    protected void modelToEntityReferences(AttributeGroupAttributeDs ds,
            AttributeGroupAttribute e, boolean isInsert) throws Exception {

        if (ds.getGroupId() != null) {
            if (e.getGroup() == null
                    || !e.getGroup().getId().equals(ds.getGroupId())) {
                e.setGroup((AttributeGroup) this.em.find(AttributeGroup.class,
                        ds.getGroupId()));
            }
        } else {
            this.lookup_group_AttributeGroup(ds, e);
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

    protected void lookup_group_AttributeGroup(AttributeGroupAttributeDs ds,
            AttributeGroupAttribute e) throws Exception {
        if (ds.getGroup() != null && !ds.getGroup().equals("")) {
            AttributeGroup x = null;
            try {
                x = ((IAttributeGroupService) findEntityService(AttributeGroup.class))
                        .findByName(ds.getGroup());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttributeGroup` reference:  `group` = "
                                + ds.getGroup() + "  ");
            }
            e.setGroup(x);

        } else {
            e.setGroup(null);
        }
    }

    protected void lookup_attribute_Attribute(AttributeGroupAttributeDs ds,
            AttributeGroupAttribute e) throws Exception {
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
