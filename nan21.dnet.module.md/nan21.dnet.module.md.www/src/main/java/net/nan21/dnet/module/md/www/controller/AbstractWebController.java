package net.nan21.dnet.module.md.www.controller;

 
import net.nan21.dnet.core.api.ISystemConfig;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.api.session.Params;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.api.session.User;
import net.nan21.dnet.core.api.session.UserPreferences;
import net.nan21.dnet.core.presenter.service.ServiceLocator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AbstractWebController {

	@Autowired
	protected ServiceLocator serviceLocator;
	
	@Autowired
	protected ApplicationContext appContext;
	
	
//	@Autowired
//	protected WebApplicationContext webAppContext;
	
	//@Autowired
	//protected List<IDsServiceFactory> serviceFactories;
	 
	@Autowired
	protected ISystemConfig systemConfig;
	
	
	protected void prepareRequest() throws Exception  {
		String username = "Guest";
	    String displayName = "Guest";     
	    //char[] password;
	    UserPreferences preferences = null;
	    
	    boolean accountExpired = false;
	    boolean accountLocked= false;
	    boolean credentialsExpired= false;
	    boolean enabled = true;
	    
	    String clientCode = this.systemConfig.getPortalClientCode();
	    Long clientId = Long.parseLong(this.systemConfig.getPortalClientId());
	    
	    String employeeCode = "xxx";
	    Long employeeId = 0L;
	    
	    User user;
		Params params;
		try { 
            
            user = new User(username, displayName, "", accountExpired, accountLocked, credentialsExpired, enabled
            		,clientCode, clientId, preferences, employeeCode,employeeId, null, null);
            params = new Params();                          
             
        } catch (ClassCastException e) {
            throw new Exception(
                    "<b>Session expired.</b>"
                            + "<br> Logout from application and login again.");
        }
        Session.user.set(user);
        Session.params.set(params);   
		
		
	}
	protected void finishRequest() {
		Session.user.set(null);
        Session.params.set(null); 
	}

	protected IDsService findDsService(String name) throws Exception {
		IDsService service = this.serviceLocator.findDsService(name);
		service.setSystemConfig(this.systemConfig);	
		return service;
	}
	protected IDsService findDsService(Class<?> modelClass) throws Exception {
		IDsService service = this.serviceLocator.findDsService(modelClass);
		service.setSystemConfig(this.systemConfig);	
		return service;
	}
	 
	
	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
 
	public ApplicationContext getAppContext() {
		return appContext;
	}

	public void setAppContext(ApplicationContext appContext) {
		this.appContext = appContext;
	}

//	public WebApplicationContext getWebAppContext() {
//		return webAppContext;
//	}
//
//	public void setWebAppContext(WebApplicationContext webAppContext) {
//		this.webAppContext = webAppContext;
//	}

//	public List<IDsServiceFactory> getServiceFactories() {
//		return serviceFactories;
//	}
//
//	public void setServiceFactories(List<IDsServiceFactory> serviceFactories) {
//		this.serviceFactories = serviceFactories;
//	}

	public ISystemConfig getSystemConfig() {
		return systemConfig;
	}

	public void setSystemConfig(ISystemConfig systemConfig) {
		this.systemConfig = systemConfig;
	} 
}
