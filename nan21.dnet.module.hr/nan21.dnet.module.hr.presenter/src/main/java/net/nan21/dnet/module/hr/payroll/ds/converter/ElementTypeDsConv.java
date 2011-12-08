/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.payroll.business.service.IElementCategoryService;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;

public class ElementTypeDsConv extends
        AbstractDsConverter<ElementTypeDs, ElementType> implements
        IDsConverter<ElementTypeDs, ElementType> {

    protected void modelToEntityReferences(ElementTypeDs ds, ElementType e)
            throws Exception {
        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((ElementCategory) this.em.find(
                        ElementCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_ElementCategory(ds, e);
        }
    }

    protected void lookup_category_ElementCategory(ElementTypeDs ds,
            ElementType e) throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            ElementCategory x = null;
            try {
                x = ((IElementCategoryService) findEntityService(ElementCategory.class))
                        .findByName(ds.getClientId(), ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ElementCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

}
