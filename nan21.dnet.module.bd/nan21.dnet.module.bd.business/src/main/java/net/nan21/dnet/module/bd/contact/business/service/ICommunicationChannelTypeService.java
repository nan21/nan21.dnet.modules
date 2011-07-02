/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.contact.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

public interface ICommunicationChannelTypeService extends
        IEntityService<CommunicationChannelType> {

    public CommunicationChannelType findByName(Long clientId, String name);

}
