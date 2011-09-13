/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentTypeLovDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmplAttachmentType;

public class EmplAttachmentTypeLovDsConv extends
        AbstractDsConverter<EmplAttachmentTypeLovDs, EmplAttachmentType>
        implements IDsConverter<EmplAttachmentTypeLovDs, EmplAttachmentType> {

    protected void modelToEntityAttributes(EmplAttachmentTypeLovDs ds,
            EmplAttachmentType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(EmplAttachmentTypeLovDs ds,
            EmplAttachmentType e) throws Exception {
    }

    @Override
    public void entityToModel(EmplAttachmentType e, EmplAttachmentTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
