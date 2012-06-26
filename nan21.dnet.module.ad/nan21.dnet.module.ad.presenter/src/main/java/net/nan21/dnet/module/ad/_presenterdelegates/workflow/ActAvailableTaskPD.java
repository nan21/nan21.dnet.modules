package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDs;

public class ActAvailableTaskPD extends AbstractDsDelegate {

	public void claim(ActAvailableTaskDs ds) throws Exception {
		getWorkflowTaskService().claim(ds.getId(), Session.user.get().getUsername());	
	}
	
}
