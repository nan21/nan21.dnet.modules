/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.client.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.client.business.service.IClientService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad._businessdelegates.client.ClientBD;

public class ClientService extends AbstractEntityService<Client> implements
        IClientService {

    public ClientService() {
        super();
    }

    public ClientService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Client> getEntityClass() {
        return Client.class;
    }

    public void doInsertWithUserAccounts(Client client, String userCode,
            String userName, String password) throws Exception {
        this.getBusinessDelegate(ClientBD.class).createAdminUser(client,
                userCode, userName, password);
    }

}
