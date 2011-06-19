/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.domain.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannel;

public interface ICommunicationChannelService extends
        IEntityService<CommunicationChannel> {

    public List<CommunicationChannel> findByType(CommunicationChannelType type);

    public List<CommunicationChannel> findByTypeId(Long typeId);

}
