package net.nan21.dnet.module.ad._presenterdelegates;

import java.util.ArrayList;
import java.util.Map;

import net.nan21.dnet.core.api.session.Params;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.api.setup.ISetupParticipant;
import net.nan21.dnet.core.api.setup.ISetupTask;
import net.nan21.dnet.core.api.setup.ISetupTaskParam;
import net.nan21.dnet.core.api.setup.SetupTask;
import net.nan21.dnet.core.api.setup.SetupTaskParam;
import net.nan21.dnet.core.presenter.service.AbstractPresenterSetupParticipant;
import net.nan21.dnet.module.ad._presenterdelegates.impex.ImportFromJobDelegate;
import net.nan21.dnet.module.ad.client.business.service.IClientService;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.impex.business.service.IImportJobService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.ds.model.ImportJobDs;

public class Setup_AD extends AbstractPresenterSetupParticipant implements
		ISetupParticipant {

	private static final String PARAM_IMPORT_DATA = "importInitialData";

	@Override
	protected void beforeExecute() throws Exception {
		
		// get client , we're in setup so there should by only one 
		// client so far 
		IClientService cs = (IClientService)this.findEntityService(Client.class);
		Client c = cs.findAll().get(0);
		
		net.nan21.dnet.core.api.session.User su = Session.user.get();
		net.nan21.dnet.core.api.session.User newUser = new 
			net.nan21.dnet.core.api.session.User(su.getUsername(), su.getUsername(), "", false, false, false, true, c.getCode(), c.getId(), null, null, null); 
		Session.user.set(newUser);
		Params p = new Params();
		p.setAdminRole(c.getAdminRole());
		p.setDefaultImportPath(c.getDefaultImportPath());
		 
		Session.params.set(p); 
	}
	
	@Override
	protected void onExecute() throws Exception {

		//SysDataSourceDelegate d = new SysDataSourceDelegate();
		//d.setAppContext(appContext);
		//d.synchronizeCatalog(null);
 
		SetupTask task = (SetupTask) tasks.get(0);

		Map<String, ISetupTaskParam> paramMap = task.getParamsAsMap();
		String importInitialData = paramMap.get(PARAM_IMPORT_DATA).getValue();
		boolean b = (importInitialData != null &&(importInitialData.equalsIgnoreCase("on") || 
				importInitialData.equalsIgnoreCase("true") || importInitialData.equalsIgnoreCase("yes") ) );
 
		if (b) {
			IImportJobService importJobService  = (IImportJobService)this.findEntityService(ImportJob.class);
			
			ImportJob ij = (ImportJob)  importJobService.getEntityManager().createQuery(
					"select e from ImportJob e where e.name = :name")
					.setParameter("name", "Initial demo data import")
					.getResultList().get(0);

			ImportJobDs importFromJob = new ImportJobDs();
			importFromJob.setId(ij.getId());

			ImportFromJobDelegate importFromJobDelegate = new ImportFromJobDelegate();
			importFromJobDelegate.setAppContext(appContext);
			//importFromJobDelegate.setEntityServiceFactories(getEntityServiceFactories());			
			importFromJobDelegate.execute(importFromJob);
		}
		this.tasks.clear();

		//this.tasks = null;
	}

	@Override
	protected void init() {
		this.targetName = "DNet-AD";
		this.createTasks();
	}

	private void createTasks() {
		this.tasks = new ArrayList<ISetupTask>();
		try {
			if(this.findEntityService(ImportJob.class).findAll().size() > 0 ) {
				return;
			}			
		} catch(Exception e) {
			e.printStackTrace();
			return ;
		}
		 
		SetupTask task = new SetupTask();
		task.setId("1");
		task.setTitle("Import initial data");
		task
				.setDescription("Imports initial data provided. If it is the first time you are installing DNet it is reccomended to import the demo data.");

		SetupTaskParam param = new SetupTaskParam();
		param.setName(PARAM_IMPORT_DATA);
		param.setTitle("Import data");
		param.setDescription("Check to perform initial data import.");
		param.setDataType("string");
		param.setFieldType("checkbox");
		param.setDefaultValue("on");
		param.setValue(param.getDefaultValue());
		// param.setRequired(true);
		task.addToParams(param);

		tasks.add(task);
	}

}
