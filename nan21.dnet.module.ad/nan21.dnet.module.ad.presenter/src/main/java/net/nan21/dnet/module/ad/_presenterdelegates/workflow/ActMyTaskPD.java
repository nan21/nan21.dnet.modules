package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs;

public class ActMyTaskPD extends AbstractDsDelegate {
	
	public void complete(ActMyTaskDs ds) throws Exception {
		getWorkflowTaskService().complete(ds.getId());	
	}
	
}
