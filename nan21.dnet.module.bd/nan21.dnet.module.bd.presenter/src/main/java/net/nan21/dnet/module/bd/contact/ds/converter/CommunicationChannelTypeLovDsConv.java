/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.contact.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeLovDs;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

public class CommunicationChannelTypeLovDsConv
        extends
        AbstractDsConverter<CommunicationChannelTypeLovDs, CommunicationChannelType>
        implements
        IDsConverter<CommunicationChannelTypeLovDs, CommunicationChannelType> {

    protected void modelToEntityAttributes(CommunicationChannelTypeLovDs ds,
            CommunicationChannelType e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setName(ds.getName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(CommunicationChannelTypeLovDs ds,
            CommunicationChannelType e) throws Exception {
    }

    @Override
    public void entityToModel(CommunicationChannelType e,
            CommunicationChannelTypeLovDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setName(e.getName());
        ds.setActive(e.getActive());
    }

}
