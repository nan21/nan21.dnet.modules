package net.nan21.dnet.module.ad._businessdelegates;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.FileCopyUtils;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.api.setup.IInitDataProvider;
import net.nan21.dnet.core.api.setup.IInitDataProviderFactory;
import net.nan21.dnet.core.api.setup.ISetupParticipant;
import net.nan21.dnet.core.api.setup.ISetupTask;
import net.nan21.dnet.core.api.setup.ISetupTaskParam;
import net.nan21.dnet.core.api.setup.InitData;
import net.nan21.dnet.core.api.setup.InitDataItem;
import net.nan21.dnet.core.api.setup.SetupTask;
import net.nan21.dnet.core.api.setup.SetupTaskParam;
import net.nan21.dnet.core.business.service.AbstractBusinessSetupParticipant;
import net.nan21.dnet.module.ad._businessdelegates.client.ClientBD;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProperty;

public class Setup_AD extends AbstractBusinessSetupParticipant
implements ISetupParticipant {
 
	private static final String PARAM_CLIENT_CODE = "clientCode";
	private static final String PARAM_CLIENT_NAME = "clientName";
	
	private static final String PARAM_USER_CODE = "userCode";
	private static final String PARAM_USER_NAME = "userName";
	private static final String PARAM_USER_PASSWORD = "userPassword";
  
	private static final String PARAM_WORKSPACE_PATH = "workspacePath";
  
	
	@Override
	protected void onExecute() throws Exception {
 
		SetupTask task = (SetupTask)tasks.get(0);
		 
		Map<String, ISetupTaskParam> paramMap = task.getParamsAsMap(); 
		String workspacePath = paramMap.get(PARAM_WORKSPACE_PATH).getValue();
		String clientCode = paramMap.get(PARAM_CLIENT_CODE).getValue();
		String clientName = paramMap.get(PARAM_CLIENT_NAME).getValue();
		
		String defaultImportPath = workspacePath+"/"+clientCode+"/import";
		String defaultExportPath = workspacePath+"/"+clientCode+"/export";
		String defaultTempPath = workspacePath+"/"+clientCode+"/temp";
		
		Client client = new Client();
		client.setCode(clientCode);
		client.setName(clientName);		
		client.setAdminRole(ClientBD.ROLE_ADMIN);			
		client.setDefaultImportPath(defaultImportPath);
		client.setDefaultExportPath(defaultExportPath);
		client.setTempPath(defaultTempPath);
		client.setSystemClient(true);
		
		//this.em.persist(client);
		  
		this.getBusinessDelegate(ClientBD.class).createAdminUser(client, 
				paramMap.get(PARAM_USER_CODE).getValue(), 
				paramMap.get(PARAM_USER_NAME).getValue(), 
				paramMap.get(PARAM_USER_PASSWORD).getValue());
		
		// run in context of the client
		net.nan21.dnet.core.api.session.User su = Session.user.get();
		net.nan21.dnet.core.api.session.User newUser = new 
			net.nan21.dnet.core.api.session.User(su.getUsername(), su.getUsername(), "", false, false, false, true, client.getCode(), client.getId(), null, null, null, null, null); 
		 
		Session.user.set(newUser);
		
		// add activiti default data
		ActProperty p = new ActProperty();
		p.setName("schema.version");		
		p.setValue("5.9");
		p.setRevision(1);
		this.em.persist(p);
		
		p = new ActProperty();
		p.setName("schema.history");		
		p.setValue("create(5.9)");
		p.setRevision(1);
		this.em.persist(p);
		
		p = new ActProperty();
		p.setName("next.dbid");		
		p.setValue("1");
		p.setRevision(1);
		this.em.persist(p);
		 
		p = new ActProperty();
		p.setName("historyLevel");		
		p.setValue("2");
		p.setRevision(1);
		this.em.persist(p);
		
		reqisterInitialDataImports(defaultImportPath);
				
		this.tasks.clear();
		
		this.tasks = null;
	}
	
	
	
	@Override
	protected void init() {		
		this.targetName = "DNet-AD";
		this.createTasks();		 
	}

 
	private void createTasks() {
		this.tasks = new ArrayList<ISetupTask>();
		Long i = (Long)this.em.createQuery("select count(e) from Client e").getResultList().get(0);
		if (i>0) {
			return ;
		}		
		SetupTask task = new SetupTask();
		task.setId("1");
		task.setTitle("Create default client and administrator user account");
		task.setDescription("Initialize the administation module. Create a default client and administrator user account. ");
		
		
		SetupTaskParam param = new SetupTaskParam();
		param.setName(PARAM_CLIENT_CODE);
		param.setTitle("Client code");
		param.setDescription("Specify the code of the system client");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("SYS");
		param.setValue(param.getDefaultValue());
		param.setRequired(true);
		task.addToParams(param);
		
		param = new SetupTaskParam();
		param.setName(PARAM_CLIENT_NAME);
		param.setTitle("Client name");
		param.setDescription("Specify the name of the system client");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("System");
		param.setValue(param.getDefaultValue());
		param.setRequired(true);
		task.addToParams(param);
		
		param = new SetupTaskParam();
		param.setName(PARAM_USER_CODE);
		param.setTitle("Administrator code");
		param.setDescription("Administrator account login name");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("admin");
		param.setValue(param.getDefaultValue());
		param.setRequired(true);
		task.addToParams(param);
		
		
		param = new SetupTaskParam();
		param.setName(PARAM_USER_NAME);
		param.setTitle("Administrator name");
		param.setDescription("Administrator account display name");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("Administrator");
		param.setValue(param.getDefaultValue());
		param.setRequired(true);
		task.addToParams(param);
		
		
		param = new SetupTaskParam();
		param.setName(PARAM_USER_PASSWORD);
		param.setTitle("Administrator password");
		param.setDescription("Administrator account password");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("");
		param.setRequired(true);
		task.addToParams(param);
 
		
		param = new SetupTaskParam();
		param.setName(PARAM_WORKSPACE_PATH);
		param.setTitle("Workspace path");
		param.setDescription("The working folder used by DNet as workspace. Default sub-folders created during setup can be customized per client level in the `Client` definition frame.");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("");
		param.setValue(param.getDefaultValue());
		param.setRequired(true);
		task.addToParams(param);
		  
		tasks.add(task);
	}
	
	private void reqisterInitialDataImports(String importPath) throws Exception {
		 
		List<IInitDataProviderFactory> dataProviderFactories = this.getDataProviderFactories();
		
		ImportJob importJobDemoData = new ImportJob();
		importJobDemoData.setActive(true);
		importJobDemoData.setName("Initial demo data");
		
		ImportJob importJobSetupData = new ImportJob();
		importJobSetupData.setActive(true);
		importJobSetupData.setName("Initial setup data");
		
		for( IInitDataProviderFactory f: dataProviderFactories) {
			IInitDataProvider dp = f.createProvider();
			List<InitData> list = dp.getList();
			for (InitData initData: list) {
				
				
				
				ImportMap importMap = new ImportMap();
				importMap.setName(initData.getName());
				importMap.setDescription("File-set to load "+initData.getName()+ " initial data.");
				importMap.setActive(true);
				
				for(InitDataItem initDataItem: initData.getItems()) {
					ImportMapItem importMapItem = new ImportMapItem();
					importMapItem.setActive(true);
					importMapItem.setDataSourceName(initDataItem.getDsName());
					importMapItem.setFileName(initDataItem.getDestPath()+"/"+initDataItem.getFile().getName());
					importMapItem.setSequenceNo(Integer.parseInt(initDataItem.getSequence()));
					importMapItem.setUkFieldName(initDataItem.getUkFieldName());
					importMapItem.setImportMap(importMap);
					importMap.addToItems(importMapItem);
					String path = importPath+"/"+initDataItem.getDestPath();
					 (new File(path)).mkdirs();
					 
					File dest =  new File(path+"/"+initDataItem.getFile().getName());
					
					FileCopyUtils.copy(initDataItem.getFile(), dest);
				}
				this.em.persist(importMap);
				
				ImportJobItem importJobItem = new ImportJobItem(); 
				importJobItem.setActive(true);
				importJobItem.setMap(importMap);
				importJobItem.setSequenceNo(Integer.parseInt(initData.getSequence()));
				
				if (initData.isMandatory()) {
					importJobItem.setJob(importJobSetupData);				
					importJobSetupData.addToItems(importJobItem);
				} else {
					importJobItem.setJob(importJobDemoData);				
					importJobDemoData.addToItems(importJobItem);
				}

				
			}
		}
		
		this.em.persist(importJobSetupData);
		this.em.persist(importJobDemoData);
		  
	}
 
 
}
