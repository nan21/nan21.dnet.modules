/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.ds.serviceext; 

import java.util.List;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.AbstractDsService;
import net.nan21.dnet.module.ad.client.business.service.IClientService;
import net.nan21.dnet.module.ad.client.domain.entity.Client;

import net.nan21.dnet.module.ad.client.ds.model.ClientDs;
import net.nan21.dnet.module.ad.client.ds.param.ClientDsParam;

public class ClientDsService  extends AbstractDsService<ClientDs, ClientDsParam, Client> 
 implements IDsService<ClientDs, ClientDsParam>  {

	@Override
	protected void onInsert(ClientDs ds, Client e, ClientDsParam params) throws Exception {
		((IClientService)this.getEntityService()).doInsertWithUserAccounts(e, params.getAdminUserCode(), params.getAdminUserName(), params.getAdminPassword());		
	}
	
	@Override
	protected void onInsert(List<ClientDs> list, List<Client> entities, ClientDsParam params) throws Exception {
		IClientService srv = (IClientService)this.getEntityService();
		for (Client e: entities) {
			srv.doInsertWithUserAccounts(e, params.getAdminUserCode(), params.getAdminUserName(), params.getAdminPassword());
		}		 
	}
	 
}
 