package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.WfProcessInstanceRunningDs;

public class WfProcessInstanceRunningDelegate extends BaseDsDelegate<WfProcessInstanceRunningDs, EmptyParam>{

	public void killInstance(WfProcessInstanceRunningDs ds) {
		getWorkflowRuntimeService().deleteProcessInstance(ds.getId(), "killed" );		
	}
	
	
}
