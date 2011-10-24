/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.data.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeLovDs;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

public class AttachmentTypeLovDsConv extends
        AbstractDsConverter<AttachmentTypeLovDs, AttachmentType> implements
        IDsConverter<AttachmentTypeLovDs, AttachmentType> {

    protected void modelToEntityAttributes(AttachmentTypeLovDs ds,
            AttachmentType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setUseInContext(ds.getUseInContext());
    }

    protected void modelToEntityReferences(AttachmentTypeLovDs ds,
            AttachmentType e) throws Exception {
    }

    @Override
    public void entityToModel(AttachmentType e, AttachmentTypeLovDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
        ds.setUseInContext(e.getUseInContext());
    }

}
