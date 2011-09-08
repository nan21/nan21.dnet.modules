/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(CommunicationChannelDs ds,
            CommunicationChannel e) throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setTargetId(ds.getTargetId());
        e.setTargetType(ds.getTargetType());
        e.setValue(ds.getValue());
        e.setValidFrom(ds.getValidFrom());
        e.setValidTo(ds.getValidTo());
    }

    protected void modelToEntityReferences(CommunicationChannelDs ds,
            CommunicationChannel e) throws Exception {

        if (ds.getTypeId() != null) {
            if (e.getType() == null
                    || !e.getType().getId().equals(ds.getTypeId())) {
                e.setType((CommunicationChannelType) this.em.getReference(
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
                x = ((ICommunicationChannelTypeService) getService(ICommunicationChannelTypeService.class))
                        .findByName(ds.getClientId(), ds.getType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `CommunicationChannelType` reference:  `type` = "
                                + ds.getType() + "  ");
            }
            e.setType(x);
        }
    }

    @Override
    public void entityToModel(CommunicationChannel e, CommunicationChannelDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setTargetId(e.getTargetId());
        ds.setTargetType(e.getTargetType());
        ds.setValue(e.getValue());
        ds.setValidFrom(e.getValidFrom());
        ds.setValidTo(e.getValidTo());
        ds.setTypeId(((e.getType() != null)) ? e.getType().getId() : null);
        ds.setType(((e.getType() != null)) ? e.getType().getName() : null);
    }

}
