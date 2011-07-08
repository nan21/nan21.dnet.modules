/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bd.contact.business.service.ICommunicationChannelService;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannel;

public class CommunicationChannelService extends
        AbstractEntityService<CommunicationChannel> implements
        ICommunicationChannelService {

    public CommunicationChannelService() {
        super();
    }

    public CommunicationChannelService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CommunicationChannel> getEntityClass() {
        return CommunicationChannel.class;
    }

    public List<CommunicationChannel> findByType(CommunicationChannelType type) {
        return this.findByTypeId(type.getId());
    }

    public List<CommunicationChannel> findByTypeId(Long typeId) {
        return (List<CommunicationChannel>) this.em
                .createQuery(
                        "select e from CommunicationChannel e where e.type.id = :pTypeId",
                        CommunicationChannel.class)
                .setParameter("pTypeId", typeId).getResultList();
    }

}
