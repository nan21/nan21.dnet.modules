/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.business.service.IEmplAttachmentTypeService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmplAttachmentType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAttachment;

public class EmplAttachmentDsConv extends
        AbstractDsConverter<EmplAttachmentDs, EmployeeAttachment> implements
        IDsConverter<EmplAttachmentDs, EmployeeAttachment> {

    protected void modelToEntityAttributes(EmplAttachmentDs ds,
            EmployeeAttachment e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setName(ds.getName());
        e.setLocation(ds.getLocation());
        e.setNotes(ds.getNotes());
        e.setUrl(ds.getUrl());
    }

    protected void modelToEntityReferences(EmplAttachmentDs ds,
            EmployeeAttachment e) throws Exception {

        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        }
        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((EmplAttachmentType) this.em.find(
                        EmplAttachmentType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_EmplAttachmentType(ds, e);
        }
    }

    protected void lookup_type_EmplAttachmentType(EmplAttachmentDs ds,
            EmployeeAttachment e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            EmplAttachmentType x = null;
            try {
                x = ((IEmplAttachmentTypeService) getService(IEmplAttachmentTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `EmplAttachmentType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        } else {
            e.setType(null);
        }
    }

    @Override
    public void entityToModel(EmployeeAttachment e, EmplAttachmentDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setName(e.getName());
        ds.setLocation(e.getLocation());
        ds.setNotes(e.getNotes());
        ds.setUrl(e.getUrl());
        ds.setEmployeeId(((e.getEmployee() != null)) ? e.getEmployee().getId()
                : null);
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
