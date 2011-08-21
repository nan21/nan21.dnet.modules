package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDs;

public class ActAvailableTaskDelegate extends BaseDsDelegate<ActAvailableTaskDs, EmptyParam> {

	public void claim(ActAvailableTaskDs ds) {
		getWorkflowTaskService().claim(ds.getId(), Session.user.get().getUsername());	
	}
	
}
