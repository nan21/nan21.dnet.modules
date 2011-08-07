package net.nan21.dnet.module.ad._businessdelegates;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.api.setup.ISetupParticipant;
import net.nan21.dnet.core.api.setup.ISetupTask;
import net.nan21.dnet.core.api.setup.ISetupTaskParam;
import net.nan21.dnet.core.api.setup.SetupTask;
import net.nan21.dnet.core.api.setup.SetupTaskParam;
import net.nan21.dnet.core.business.service.AbstractSetupParticipant;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

public class Setup_AD extends AbstractSetupParticipant
implements ISetupParticipant {

	private static final String PARAM_CLIENT_CODE = "clientCode";
	private static final String PARAM_CLIENT_NAME = "clientName";
	
	private static final String PARAM_USER_CODE = "userCode";
	private static final String PARAM_USER_NAME = "userName";
	private static final String PARAM_USER_PASSWORD = "userPassword";
  
	private static final String PARAM_IMPORT_PATH = "importPath";
	private static final String PARAM_EXPORT_PATH = "exportPath";
	private static final String PARAM_TEMP_PATH = "tempPath";
	
	private static final String ROLE_ADMIN = "ROLE_DNET_ADMIN";
	private static final String ROLE_USER = "ROLE_DNET_USER";
	 
	
	@Override
	public void run() throws Exception {
 
		SetupTask task = (SetupTask)tasks.get(0);
		 
		Map<String, ISetupTaskParam> paramMap = task.getParamsAsMap(); 
		
		Client c = new Client();
		c.setCode(paramMap.get(PARAM_CLIENT_CODE).getValue());
		c.setName(paramMap.get(PARAM_CLIENT_NAME).getValue());		
		c.setAdminRole(ROLE_ADMIN);		
		c.setDefaultImportPath(paramMap.get(PARAM_IMPORT_PATH).getValue());
		c.setDefaultExportPath(paramMap.get(PARAM_EXPORT_PATH).getValue());
		c.setTempPath(paramMap.get(PARAM_TEMP_PATH).getValue());
		this.em.persist(c);
		
		 
		
		// run in context of the client
		net.nan21.dnet.core.api.session.User su = Session.user.get();
		net.nan21.dnet.core.api.session.User newUser = new 
			net.nan21.dnet.core.api.session.User(su.getUsername(), su.getUsername(), "", false, false, false, true, c.getCode(), c.getId(), null, null, null); 
		 
		Session.user.set(newUser);
		
		Role radmin = new Role();
		radmin.setName(ROLE_ADMIN);
		radmin.setDescription("Administrator role for un-restricted access to business functions.");
		this.em.persist(radmin);
		
		Role ruser = new Role();
		ruser.setName(ROLE_USER);
		ruser.setDescription("Application role which allows a user to use the application.");
		this.em.persist(ruser);
		
		 
		
		UserType t = new UserType();
		t.setName("Default");		 
		this.em.persist(t);
		
		Collection<Role> roles = new ArrayList<Role>();
		roles.add(radmin);
		roles.add(ruser);
	 
		
		User u = new User();
		String password = paramMap.get(PARAM_USER_PASSWORD).getValue();
		u.setCode(paramMap.get(PARAM_USER_CODE).getValue());
		u.setName(paramMap.get(PARAM_USER_NAME).getValue());
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
		messageDigest.update(password.getBytes(),0, password.length());  
		String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
		if (hashedPass.length() < 32) { 
		   hashedPass = "0" + hashedPass; 
		}
		
		u.setPassword(hashedPass);	
		u.setRoles(roles);
		this.em.persist(u);
		
		ImportMap im = new ImportMap();
		im.setName("_Import_bootstrap_");
		im.setDescription("Default file-set which loads initial data for this screen");
		im.setActive(true);
		
		ImportMapItem imi = new ImportMapItem();
		imi.setSequenceNo(1);		
		imi.setDataSourceName("ImportMap");
		imi.setFileName("net/nan21/dnet/data/setup/ad/ImportMap.csv");
		imi.setActive(true);		
		im.addToItems(imi);
		
		imi = new ImportMapItem();
		imi.setSequenceNo(2);		
		imi.setDataSourceName("ImportMapItem");
		imi.setFileName("net/nan21/dnet/data/setup/ad/ImportMapItem.csv");
		imi.setActive(true);		
		im.addToItems(imi);
		
		imi = new ImportMapItem();
		imi.setSequenceNo(3);		
		imi.setDataSourceName("ImportJob");
		imi.setFileName("net/nan21/dnet/data/setup/ad/ImportJob.csv");
		imi.setActive(true);		
		im.addToItems(imi);
		
		imi = new ImportMapItem();
		imi.setSequenceNo(4);		
		imi.setDataSourceName("ImportJobItem");
		imi.setFileName("net/nan21/dnet/data/setup/ad/ImportJobItem.csv");
		imi.setActive(true);		
		im.addToItems(imi);
		
		this.em.persist(im);
		
		this.tasks.clear();
	}
	
	
	
	@Override
	protected void init() {		
		this.targetName = "DNet-AD";
		this.createTasks();		 
	}

 
	private void createTasks() {
		this.tasks = new ArrayList<ISetupTask>();
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
		param.setName(PARAM_IMPORT_PATH);
		param.setTitle("Import path");
		param.setDescription("The working folder to be used for data import. It is set per client level and can be changed later in the `Client` definition frame.");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("");
		param.setValue(param.getDefaultValue());
		param.setRequired(true);
		task.addToParams(param);
		
		param = new SetupTaskParam();
		param.setName(PARAM_EXPORT_PATH);
		param.setTitle("Export path");
		param.setDescription("The working folder to be used for data export. It is set per client level and can be changed later in the `Client` definition frame.");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("");
		param.setValue(param.getDefaultValue());
		param.setRequired(true);
		task.addToParams(param);
		
		param = new SetupTaskParam();
		param.setName(PARAM_TEMP_PATH);
		param.setTitle("Temporary path");
		param.setDescription("The temporary folder used by DNet. It is set per client level and can be changed later in the `Client` definition frame.");
		param.setDataType("string");
		param.setFieldType("textfield");
		param.setDefaultValue("");
		param.setValue(param.getDefaultValue());
		param.setRequired(true);
		task.addToParams(param);
		
		tasks.add(task);
	}
	
	
	
}
