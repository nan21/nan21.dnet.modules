/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceTypeService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonDs;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;

public class AbsenceReasonDsConv extends
        AbstractDsConverter<AbsenceReasonDs, AbsenceReason> implements
        IDsConverter<AbsenceReasonDs, AbsenceReason> {

    @Override
    protected void modelToEntityReferences(AbsenceReasonDs ds, AbsenceReason e,
            boolean isInsert) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AbsenceType) this.em.find(AbsenceType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AbsenceType(ds, e);
        }

    }

    protected void lookup_type_AbsenceType(AbsenceReasonDs ds, AbsenceReason e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AbsenceType x = null;
            try {
                x = ((IAbsenceTypeService) findEntityService(AbsenceType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AbsenceType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
