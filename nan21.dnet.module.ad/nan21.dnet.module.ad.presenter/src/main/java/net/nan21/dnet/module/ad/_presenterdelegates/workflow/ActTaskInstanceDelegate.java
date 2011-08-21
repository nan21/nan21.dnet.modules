package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs;

public class ActTaskInstanceDelegate extends BaseDsDelegate<ActTaskInstanceDs, EmptyParam> {

	public void assignTask(ActTaskInstanceDs ds) {
		getWorkflowTaskService().setAssignee(ds.getId(), ds.getAssignee());		
	}
	
	public void completeTask(ActTaskInstanceDs ds) {
		getWorkflowTaskService().complete(ds.getId() );		
	}
	
}
