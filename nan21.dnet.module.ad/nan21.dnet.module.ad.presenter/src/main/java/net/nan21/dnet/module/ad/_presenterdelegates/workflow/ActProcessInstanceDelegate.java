package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs;

public class ActProcessInstanceDelegate extends BaseDsDelegate<ActProcessInstanceDs, EmptyParam>{

	public void killInstance(ActProcessInstanceDs ds) {
		getWorkflowRuntimeService().deleteProcessInstance(ds.getId(), "killed" );		
	}
	
	
}
