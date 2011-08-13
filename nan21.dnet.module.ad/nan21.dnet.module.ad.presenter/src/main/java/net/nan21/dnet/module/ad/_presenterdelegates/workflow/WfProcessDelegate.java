package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.WfProcessDs;

public class WfProcessDelegate extends BaseDsDelegate<WfProcessDs, EmptyParam> {

	public void startInstance(WfProcessDs ds) {
		getWorkflowRuntimeService().startProcessInstanceById(ds.getId());		
	}
	
}
