package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.repository.ProcessDefinition;
import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs;

public class ActProcessDefinitionPD extends AbstractDsDelegate {

	public InputStream getStartForm(ActProcessDefinitionDs ds) {
//		InputStream stream = getWorkflowRepositoryService()
//				.getResourceAsStream(ds.getDeploymentId(),
//						"org/activiti/examples/taskforms/request.form");
//		return stream;
		return null;
	}

	public void startInstance(ActProcessDefinitionDs ds) throws Exception {
		ProcessEngine pe = getWorkflowEngine();
		String processDefinitionId = ds.getId();
		
		ProcessDefinition processDefinition = getWorkflowRepositoryService()
		.createProcessDefinitionQuery().processDefinitionId(
				processDefinitionId).singleResult();
		
		boolean hasStartForm =  processDefinition.hasStartFormKey();
		if (hasStartForm) {
			
		}
		StartFormData sfd = pe.getFormService().getStartFormData(processDefinitionId);
		
		Map<String, Object> vars = new HashMap<String, Object> ();
		vars.put("stringVar", "sdf sdfsdf ds");
		this.findEntityService(ActProcessDefinition.class)
				.doStartWfProcessInstanceById(ds.getId(), null, vars);
	}

	public InputStream getDiagram(ActProcessDefinitionDs ds) {
//		RepositoryService repositoryService = getWorkflowRepositoryService();
//		String processDefinitionId = ds.getId();
//		ProcessDefinition processDefinition = repositoryService
//				.createProcessDefinitionQuery().processDefinitionId(
//						processDefinitionId).singleResult();
//		return repositoryService.getResourceAsStream(processDefinition
//				.getDeploymentId(), processDefinition.getDiagramResourceName());
		return null;
	}
}
