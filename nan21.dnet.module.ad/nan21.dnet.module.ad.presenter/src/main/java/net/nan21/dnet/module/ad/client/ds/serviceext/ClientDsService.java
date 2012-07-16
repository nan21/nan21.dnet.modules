/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.ds.serviceext;

import java.util.List;

import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractDsService;
import net.nan21.dnet.module.ad.client.business.service.IClientService;
import net.nan21.dnet.module.ad.client.domain.entity.Client;

import net.nan21.dnet.module.ad.client.ds.filter.ClientDsFilter;
import net.nan21.dnet.module.ad.client.ds.model.ClientDs;
import net.nan21.dnet.module.ad.client.ds.param.ClientDsParam;

public class ClientDsService extends
		AbstractDsService<ClientDs, ClientDsFilter, ClientDsParam, Client>
		implements IDsService<ClientDs, ClientDsFilter, ClientDsParam> {

	@Override
	public List<ClientDs> find(ClientDsFilter filter, ClientDsParam params,
			IQueryBuilder<ClientDs, ClientDsFilter, ClientDsParam> builder)
			throws Exception {
		if (!Session.params.get().isSystemClient()) {
			filter.setId(Session.user.get().getClientId());
		}
		return super.find(filter, params, builder);
	}

	@Override
	protected void onInsert(ClientDs ds, Client e, ClientDsParam params)
			throws Exception {
		((IClientService) this.getEntityService()).doInsertWithUserAccounts(e,
				params.getAdminUserCode(), params.getAdminUserName(), params
						.getAdminPassword());
	}

	@Override
	protected void onInsert(List<ClientDs> list, List<Client> entities,
			ClientDsParam params) throws Exception {
		IClientService srv = (IClientService) this.getEntityService();
		for (Client e : entities) {
			srv.doInsertWithUserAccounts(e, params.getAdminUserCode(), params
					.getAdminUserName(), params.getAdminPassword());
		}
	}

	// check if action is allowed

	@Override
	protected boolean canInsert(ClientDs ds, ClientDsParam params) {
		return this.canChange();
	}

	@Override
	protected boolean canInsert(List<ClientDs> list, ClientDsParam params) {
		return this.canChange();
	}

	@Override
	protected boolean canUpdate(ClientDs ds, ClientDsParam params) {
		return this.canChange();
	}

	@Override
	protected boolean canUpdate(List<ClientDs> list, ClientDsParam params) {
		return this.canChange();
	}

	private boolean canChange() {
		return Session.params.get().isSystemClient();
	}

}
