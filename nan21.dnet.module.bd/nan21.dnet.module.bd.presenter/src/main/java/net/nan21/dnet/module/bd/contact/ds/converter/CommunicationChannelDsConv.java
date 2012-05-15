/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.contact.business.service.ICommunicationChannelTypeService;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDs;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannel;

public class CommunicationChannelDsConv extends
        AbstractDsConverter<CommunicationChannelDs, CommunicationChannel>
        implements IDsConverter<CommunicationChannelDs, CommunicationChannel> {

    @Override
    protected void modelToEntityReferences(CommunicationChannelDs ds,
            CommunicationChannel e, boolean isInsert) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((CommunicationChannelType) this.em.find(
                        CommunicationChannelType.class, ds.getTypeId()));
            }
        } else {
            this.lookup_type_CommunicationChannelType(ds, e);
        }

    }

    protected void lookup_type_CommunicationChannelType(
            CommunicationChannelDs ds, CommunicationChannel e) throws Exception {
        if (ds.getType() != null && !ds.getType().equals("")) {
            CommunicationChannelType x = null;
            try {
                x = ((ICommunicationChannelTypeService) findEntityService(CommunicationChannelType.class))
                        .findByName(ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CommunicationChannelType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);

        } else {
            e.setType(null);
        }
    }

}
