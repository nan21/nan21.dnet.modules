 
   	 
Ext.ns("net.nan21.dnet.module.ad.system.ds.model");
	net.nan21.dnet.module.ad.system.ds.model.SysDataSourceModelLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"model",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds.param");	
	net.nan21.dnet.module.ad.system.ds.param.SysDataSourceModelLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds");	
	net.nan21.dnet.module.ad.system.ds.SysDataSourceModelLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SysDataSourceModelLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.system.ds.model.SysDataSourceModelLovDs
				,paramFields: net.nan21.dnet.module.ad.system.ds.param.SysDataSourceModelLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.system.ds.SysDataSourceModelLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 