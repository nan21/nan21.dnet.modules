package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs;

public class ActMyTaskDelegate extends BaseDsDelegate<ActMyTaskDs, EmptyParam> {
	public void complete(ActMyTaskDs ds) {
		getWorkflowTaskService().complete(ds.getId() );	
	}
}
