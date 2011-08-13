package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.WfAvailableTaskDs;

public class WfAvailableTaskDelegate extends BaseDsDelegate<WfAvailableTaskDs, EmptyParam> {

	public void claim(WfAvailableTaskDs ds) {
		getWorkflowTaskService().claim(ds.getId(), Session.user.get().getUsername());	
	}
	
}
