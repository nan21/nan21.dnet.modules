 
   	 
Ext.ns("net.nan21.dnet.module.ad.system.ds.model");
	net.nan21.dnet.module.ad.system.ds.model.SysDsServiceLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"dataSourceId",type:"int"}
	,	{name:"dataSourceName",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds.param");	
	net.nan21.dnet.module.ad.system.ds.param.SysDsServiceLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds");	
	net.nan21.dnet.module.ad.system.ds.SysDsServiceLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SysDsServiceLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.system.ds.model.SysDsServiceLovDs
				,paramFields: net.nan21.dnet.module.ad.system.ds.param.SysDsServiceLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.system.ds.SysDsServiceLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 