 
   	 
Ext.ns("net.nan21.dnet.module.ad.system.ds.model");
	net.nan21.dnet.module.ad.system.ds.model.SysDataSourceControllerLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"controller",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds.param");	
	net.nan21.dnet.module.ad.system.ds.param.SysDataSourceControllerLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds");	
	net.nan21.dnet.module.ad.system.ds.SysDataSourceControllerLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SysDataSourceControllerLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.system.ds.model.SysDataSourceControllerLovDs
				,paramFields: net.nan21.dnet.module.ad.system.ds.param.SysDataSourceControllerLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.system.ds.SysDataSourceControllerLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 