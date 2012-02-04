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

    protected void modelToEntityReferences(AbsenceTypeDs ds, AbsenceType e)
            throws Exception {
        if (ds.getCategoryId() != null) {
            if (e.getCategory() == null
                    || !e.getCategory().getId().equals(ds.getCategoryId())) {
                e.setCategory((AbsenceCategory) this.em.find(
                        AbsenceCategory.class, ds.getCategoryId()));
            }
        } else {
            this.lookup_category_AbsenceCategory(ds, e);
        }
    }

    protected void lookup_category_AbsenceCategory(AbsenceTypeDs ds,
            AbsenceType e) throws Exception {
        if (ds.getCategory() != null && !ds.getCategory().equals("")) {
            AbsenceCategory x = null;
            try {
                x = ((IAbsenceCategoryService) findEntityService(AbsenceCategory.class))
                        .findByName(ds.getClientId(), ds.getCategory());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AbsenceCategory` reference:  `category` = "
                                + ds.getCategory() + "  ");
            }
            e.setCategory(x);

        } else {
            e.setCategory(null);
        }
    }

}
