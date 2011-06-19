 
   	 
Ext.ns("net.nan21.dnet.module.ad.system.ds.model");
	net.nan21.dnet.module.ad.system.ds.model.SysDataSourceLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds.param");	
	net.nan21.dnet.module.ad.system.ds.param.SysDataSourceLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds");	
	net.nan21.dnet.module.ad.system.ds.SysDataSourceLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SysDataSourceLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.system.ds.model.SysDataSourceLovDs
				,paramFields: net.nan21.dnet.module.ad.system.ds.param.SysDataSourceLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.system.ds.SysDataSourceLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 