package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.WfTaskInstanceDs;

public class WfTaskInstanceDelegate extends BaseDsDelegate<WfTaskInstanceDs, EmptyParam> {

	public void assignTask(WfTaskInstanceDs ds) {
		getWorkflowTaskService().setAssignee(ds.getId(), ds.getAssignee());		
	}
	
	public void completeTask(WfTaskInstanceDs ds) {
		getWorkflowTaskService().complete(ds.getId() );		
	}
	
}
