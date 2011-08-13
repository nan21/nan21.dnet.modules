package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.WfMyTaskDs;

public class WfMyTaskDelegate extends BaseDsDelegate<WfMyTaskDs, EmptyParam> {
	public void complete(WfMyTaskDs ds) {
		getWorkflowTaskService().complete(ds.getId() );	
	}
}
