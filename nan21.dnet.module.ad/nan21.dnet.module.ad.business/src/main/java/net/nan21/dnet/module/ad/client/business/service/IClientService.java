/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.client.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ad.client.domain.entity.Client;

public interface IClientService extends IEntityService<Client> {

    public void doInsertWithUserAccounts(Client client, String userCode,
            String userName, String password) throws Exception;

}
