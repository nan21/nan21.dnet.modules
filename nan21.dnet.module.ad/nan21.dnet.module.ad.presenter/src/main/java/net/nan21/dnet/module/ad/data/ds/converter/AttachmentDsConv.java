/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.data.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.data.business.service.IAttachmentTypeService;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.data.ds.model.AttachmentDs;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;

public class AttachmentDsConv extends
        AbstractDsConverter<AttachmentDs, Attachment> implements
        IDsConverter<AttachmentDs, Attachment> {

    protected void modelToEntityAttributes(AttachmentDs ds, Attachment e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setTargetId(ds.getTargetId());
        e.setTargetType(ds.getTargetType());
        e.setName(ds.getName());
        e.setLocation(ds.getLocation());
        e.setNotes(ds.getNotes());
        e.setUrl(ds.getUrl());
    }

    protected void modelToEntityReferences(AttachmentDs ds, Attachment e)
            throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((AttachmentType) this.em.find(AttachmentType.class,
                        ds.getTypeId()));
            }
        } else {
            this.lookup_type_AttachmentType(ds, e);
        }
    }

    protected void lookup_type_AttachmentType(AttachmentDs ds, Attachment e)
            throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            AttachmentType x = null;
            try {
                x = ((IAttachmentTypeService) getService(IAttachmentTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `AttachmentType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        } else {
            e.setType(null);
        }
    }

    @Override
    public void entityToModel(Attachment e, AttachmentDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setTargetId(e.getTargetId());
        ds.setTargetType(e.getTargetType());
        ds.setName(e.getName());
        ds.setLocation(e.getLocation());
        ds.setNotes(e.getNotes());
        ds.setUrl(e.getUrl());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
