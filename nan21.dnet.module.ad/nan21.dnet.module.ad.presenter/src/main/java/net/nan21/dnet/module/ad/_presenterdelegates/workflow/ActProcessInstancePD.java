package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs;

public class ActProcessInstancePD extends AbstractDsDelegate {

	public void killInstance(ActProcessInstanceDs ds) throws Exception {
		getWorkflowRuntimeService().deleteProcessInstance(ds.getId(), "killed");
	}

}
