package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import java.util.List;

import org.activiti.kickstart.dto.BaseTaskDto;
import org.activiti.kickstart.dto.KickstartWorkflowDto;
import org.activiti.kickstart.dto.UserTaskDto;
import org.activiti.kickstart.service.KickstartService;
import org.activiti.kickstart.service.KickstartServiceImpl;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeService;
import net.nan21.dnet.module.ad.workflow.business.serviceimpl.WfDefNodeService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.ds.model.WfDefProcessDs;
 
public class WfDefProcessDelegate extends BaseDsDelegate<WfDefProcessDs, EmptyParam> {
	 
	public void deployProcess(WfDefProcessDs ds) throws Exception {
		KickstartService s = new KickstartServiceImpl(this.getWorkflowEngine());
		s.deployKickstartWorkflow(convertToKickstartDto(ds));						
	}


	private KickstartWorkflowDto convertToKickstartDto (WfDefProcessDs ds) throws Exception {
		KickstartWorkflowDto dto = new KickstartWorkflowDto();
		dto.setName( ds.getName() );
		dto.setDescription(ds.getDescription());
		this._addTasks_(ds, dto);
		return dto;
	}
 
	private void _addTasks_ (WfDefProcessDs ds, KickstartWorkflowDto dto ) throws Exception {
		IWfDefNodeService srv = (IWfDefNodeService)this.findEntityService(WfDefNode.class);
		List<WfDefNode> nodes = srv.findByProcessId(ds.getId());
		for(WfDefNode node:nodes) {
			BaseTaskDto task = new UserTaskDto();
			//task.setId(node.getCode());
			task.setName(node.getCode());
			task.setDescription(node.getName());
			dto.addTask(task);
		}
	}
}
