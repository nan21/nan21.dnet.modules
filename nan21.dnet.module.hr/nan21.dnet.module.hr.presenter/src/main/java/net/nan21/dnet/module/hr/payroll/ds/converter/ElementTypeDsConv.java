/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementCategory;
import net.nan21.dnet.module.hr.payroll.domain.service.IElementCategoryService;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeDs;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementType;

public class ElementTypeDsConv extends
        AbstractDsConverter<ElementTypeDs, ElementType> implements
        IDsConverter<ElementTypeDs, ElementType> {

    protected void modelToEntityAttributes(ElementTypeDs ds, ElementType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(ElementTypeDs ds, ElementType e)
            throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((ElementCategory) this.em.getReference(
                        ElementCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_ElementCategory(ds, e);
        }
    }

    protected void lookup_category_ElementCategory(ElementTypeDs ds,
            ElementType e) throws Exception {
        ElementCategory x = null;
        try {
            x = ((IElementCategoryService) getService(IElementCategoryService.class))
                    .findByName(ds.getClientId(), ds.getCategory());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setCategory(x);
    }

    @Override
    public void entityToModel(ElementType e, ElementTypeDs ds) throws Exception {
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
        ds.setCategoryId(((e.getCategory() != null)) ? e.getCategory().getId()
                : null);
        ds.setCategory(((e.getCategory() != null)) ? e.getCategory().getName()
                : null);
    }

}
