/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceCategoryService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.time.ds.model.AbsenceTypeDs;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

public class AbsenceTypeDsConv extends
        AbstractDsConverter<AbsenceTypeDs, AbsenceType> implements
        IDsConverter<AbsenceTypeDs, AbsenceType> {

    protected void modelToEntityAttributes(AbsenceTypeDs ds, AbsenceType e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(AbsenceTypeDs ds, AbsenceType e)
            throws Exception {

        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((AbsenceCategory) this.em.getReference(
                        AbsenceCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_AbsenceCategory(ds, e);
        }
    }

    protected void lookup_category_AbsenceCategory(AbsenceTypeDs ds,
            AbsenceType e) throws Exception {
        if (ds.getCategory() != null) {
            AbsenceCategory x = null;
            try {
                x = ((IAbsenceCategoryService) getService(IAbsenceCategoryService.class))
                        .findByName(ds.getClientId(), ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AbsenceCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);
        }
    }

    @Override
    public void entityToModel(AbsenceType e, AbsenceTypeDs ds) throws Exception {
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
