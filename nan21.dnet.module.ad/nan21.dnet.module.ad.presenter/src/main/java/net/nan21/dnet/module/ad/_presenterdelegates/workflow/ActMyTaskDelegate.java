package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs;

public class ActMyTaskDelegate extends AbstractDsDelegate {
	
	public void complete(ActMyTaskDs ds) {
		getWorkflowTaskService().complete(ds.getId());	
	}
	
}
