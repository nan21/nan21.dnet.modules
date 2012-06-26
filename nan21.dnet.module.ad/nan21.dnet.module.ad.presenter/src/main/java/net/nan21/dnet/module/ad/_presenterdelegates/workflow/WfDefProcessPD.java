package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
 

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeFieldService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;
import net.nan21.dnet.module.ad.workflow.ds.model.WfDefProcessDs;

public class WfDefProcessPD extends AbstractDsDelegate {

	public InputStream getDiagram(WfDefProcessDs ds) throws Exception {
//		KickstartService s = new KickstartServiceImpl(this.getWorkflowEngine());
//		KickstartWorkflowDto dto = convertToKickstartDto(ds);
//		String deploymentId = s.deployKickstartWorkflow(dto);
//		RepositoryService rs = this.getWorkflowRepositoryService();
//		ProcessDefinition processDefinition = rs.createProcessDefinitionQuery()
//				.deploymentId(deploymentId)
//				.processDefinitionName(dto.getName()).singleResult();
//		return rs.getResourceAsStream(processDefinition.getDeploymentId(),
//				processDefinition.getDiagramResourceName());
		return null;
	}

	public void deployProcess(WfDefProcessDs ds) throws Exception {
//		KickstartService s = new KickstartServiceImpl(this.getWorkflowEngine());
//		s.deployKickstartWorkflow(convertToKickstartDto(ds));
	}

//	private KickstartWorkflowDto convertToKickstartDto(WfDefProcessDs ds)
//			throws Exception {
//		KickstartWorkflowDto dto = new KickstartWorkflowDto();
//		dto.setName(ds.getName());
//		dto.setDescription(ds.getDescription());
//		this._addTasks_(ds, dto);
//		return dto;
//	}

//	private void _addTasks_(WfDefProcessDs ds, KickstartWorkflowDto dto)
//			throws Exception {
//		IWfDefNodeService srv = (IWfDefNodeService) this
//				.findEntityService(WfDefNode.class);
//		IWfDefNodeFieldService fieldsrv = (IWfDefNodeFieldService) this
//				.findEntityService(WfDefNodeField.class);
//		List<WfDefNode> nodes = srv.findByProcessId(ds.getId());
//		for (WfDefNode node : nodes) {
//			String type = node.getTaskType();
//			if (type == null) {
//				type = "userTask";
//			}
//			if (type.equals("userTask")) {
//				UserTaskDto task = new UserTaskDto();
//				// task.setId(node.getCode());
//				task.setName(node.getName());
//				task.setDescription(node.getDescription());
//				task.setAssignee(node.getAssignToUser());
//				task.setGroups(node.getAssignToGroup());
//				// add form
//
//				List<WfDefNodeField> fields = fieldsrv.findByNodeId(node
//						.getId());
//				FormDto form = new FormDto();
//				form.setTitle(node.getName());
//				form.setDescription(node.getDescription());
//				FormPropertyDto prop = null;
//				for (WfDefNodeField field : fields) {
//					prop = new FormPropertyDto();
//					prop.setProperty(field.getName());
//					prop.setRequired(field.getRequired());
//					prop.setType(field.getType());
//					form.addFormProperty(prop);
//				}
//
//				task.setForm(form);
//				dto.addTask(task);
//			}
//			if (type.equals("mailTask")) {
//				MailTaskDto task = new MailTaskDto();
//				// task.setId(node.getCode());
//				task.setName(node.getName());
//				task.setDescription(node.getDescription());
//				dto.addTask(task);
//			}
//			if (type.equals("serviceTask")) {
//				ServiceTaskDto task = new ServiceTaskDto();
//				// task.setId(node.getCode());
//				task.setName(node.getName());
//				task.setDescription(node.getDescription());
//				dto.addTask(task);
//			}
//			if (type.equals("scriptTask")) {
//				ScriptTaskDto task = new ScriptTaskDto();
//				// task.setId(node.getCode());
//				task.setName(node.getName());
//				task.setDescription(node.getDescription());
//				dto.addTask(task);
//			}
//		}
//	}
}
