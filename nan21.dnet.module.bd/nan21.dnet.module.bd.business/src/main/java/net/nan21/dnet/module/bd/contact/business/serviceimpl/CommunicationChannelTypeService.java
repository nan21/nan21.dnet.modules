/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.business.serviceimpl;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.contact.business.service.ICommunicationChannelTypeService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

public class CommunicationChannelTypeService extends
        AbstractEntityService<CommunicationChannelType> implements
        ICommunicationChannelTypeService {

    public CommunicationChannelTypeService() {
        super();
    }

    public CommunicationChannelTypeService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CommunicationChannelType> getEntityClass() {
        return CommunicationChannelType.class;
    }

    public CommunicationChannelType findByName(String name) {
        return (CommunicationChannelType) this.em
                .createNamedQuery(CommunicationChannelType.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pName", name).getSingleResult();
    }

}
