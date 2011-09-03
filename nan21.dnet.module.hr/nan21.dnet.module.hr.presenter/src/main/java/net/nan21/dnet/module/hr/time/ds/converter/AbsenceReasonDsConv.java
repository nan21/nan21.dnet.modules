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

    protected void modelToEntityAttributes(AbsenceReasonDs ds, AbsenceReason e)
            throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(AbsenceReasonDs ds, AbsenceReason e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AbsenceType) this.em.getReference(AbsenceType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AbsenceType(ds, e);
        }
    }

    protected void lookup_type_AbsenceType(AbsenceReasonDs ds, AbsenceReason e)
            throws Exception {
        if (ds.getType() != null) {
            AbsenceType x = null;
            try {
                x = ((IAbsenceTypeService) getService(IAbsenceTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AbsenceType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        }
    }

    @Override
    public void entityToModel(AbsenceReason e, AbsenceReasonDs ds)
            throws Exception {
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
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
