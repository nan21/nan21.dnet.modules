/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.contact.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeDs;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

public class CommunicationChannelTypeDsConv
        extends
        AbstractDsConverter<CommunicationChannelTypeDs, CommunicationChannelType>
        implements
        IDsConverter<CommunicationChannelTypeDs, CommunicationChannelType> {

    protected void modelToEntityAttributes(CommunicationChannelTypeDs ds,
            CommunicationChannelType e) throws Exception {
        e.setName(ds.getName());
        e.setActive(ds.getActive());
        e.setDescription(ds.getDescription());
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setType(ds.getType());
    }

    protected void modelToEntityReferences(CommunicationChannelTypeDs ds,
            CommunicationChannelType e) throws Exception {
    }

    @Override
    public void entityToModel(CommunicationChannelType e,
            CommunicationChannelTypeDs ds) throws Exception {
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
        ds.setType(e.getType());
    }

}
