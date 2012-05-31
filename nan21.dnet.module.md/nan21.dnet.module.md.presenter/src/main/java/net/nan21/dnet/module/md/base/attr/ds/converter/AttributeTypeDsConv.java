/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.attr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.md.base.attr.business.service.IAttributeCategoryService;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.md.base.attr.ds.model.AttributeTypeDs;
import net.nan21.dnet.module.md.base.attr.domain.entity.AttributeType;

public class AttributeTypeDsConv extends
        AbstractDsConverter<AttributeTypeDs, AttributeType> implements
        IDsConverter<AttributeTypeDs, AttributeType> {

    @Override
    protected void modelToEntityReferences(AttributeTypeDs ds, AttributeType e,
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

    }

    protected void lookup_category_AttributeCategory(AttributeTypeDs ds,
            AttributeType e) throws Exception {
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

}
