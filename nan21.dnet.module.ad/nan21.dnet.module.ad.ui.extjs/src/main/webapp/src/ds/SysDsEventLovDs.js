 
   	 
Ext.ns("net.nan21.dnet.module.ad.system.ds.model");
	net.nan21.dnet.module.ad.system.ds.model.SysDsEventLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"dataSourceId",type:"int"}
	,	{name:"dataSourceName",type:"string"}
	,	{name:"name",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds.param");	
	net.nan21.dnet.module.ad.system.ds.param.SysDsEventLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds");	
	net.nan21.dnet.module.ad.system.ds.SysDsEventLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SysDsEventLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.system.ds.model.SysDsEventLovDs
				,paramFields: net.nan21.dnet.module.ad.system.ds.param.SysDsEventLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.system.ds.SysDsEventLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 