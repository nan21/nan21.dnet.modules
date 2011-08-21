package net.nan21.dnet.module.ad._presenterdelegates.workflow;

import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

import net.nan21.dnet.core.presenter.model.EmptyParam;
import net.nan21.dnet.core.presenter.service.BaseDsDelegate;
import net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs;

public class ActProcessDefinitionDelegate extends BaseDsDelegate<ActProcessDefinitionDs, EmptyParam> {

	
	public InputStream getStartForm(ActProcessDefinitionDs ds) {
		InputStream stream = getWorkflowRepositoryService().getResourceAsStream(
				ds.getDeploymentId(), "org/activiti/examples/taskforms/request.form");
		return stream;
	}
	public void startInstance(ActProcessDefinitionDs ds) {
		//ProcessEngine pe = getWorkflowEngine();
		getWorkflowRuntimeService().startProcessInstanceById(ds.getId());
		//pe.getRuntimeService().startProcessInstanceById(ds.getId());
		//pe.getFormService().getStartFormData(processDefinitionId)
		//pe.getRepositoryService().getResourceAsStream(ds.getDeploymentId(), "org/activiti/examples/taskforms/request.form")
		//Object f = pe.getFormService().getStartFormData(ds.getId());
		//int x=1;
	}
	
	public InputStream getDiagram(ActProcessDefinitionDs ds) {
		RepositoryService repositoryService = getWorkflowRepositoryService();
		String processDefinitionId = ds.getId();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
	    .processDefinitionId(processDefinitionId)
	    .singleResult();
	    return repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), 
	            processDefinition.getDiagramResourceName());
		
	}
}
