/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.PEmplAttachmentDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAttachment;

public class PEmplAttachmentDsConv extends
        AbstractDsConverter<PEmplAttachmentDs, EmployeeAttachment> implements
        IDsConverter<PEmplAttachmentDs, EmployeeAttachment> {

    protected void modelToEntityAttributes(PEmplAttachmentDs ds,
            EmployeeAttachment e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
    }

    protected void modelToEntityReferences(PEmplAttachmentDs ds,
            EmployeeAttachment e) throws Exception {
    }

    @Override
    public void entityToModel(EmployeeAttachment e, PEmplAttachmentDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
    }

}
