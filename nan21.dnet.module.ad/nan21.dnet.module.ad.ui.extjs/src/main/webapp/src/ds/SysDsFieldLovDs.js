 
   	 
Ext.ns("net.nan21.dnet.module.ad.system.ds.model");
	net.nan21.dnet.module.ad.system.ds.model.SysDsFieldLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"dataSourceId",type:"int"}
	,	{name:"dataSourceName",type:"string"}
	,	{name:"dataType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds.param");	
	net.nan21.dnet.module.ad.system.ds.param.SysDsFieldLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds");	
	net.nan21.dnet.module.ad.system.ds.SysDsFieldLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SysDsFieldLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.system.ds.model.SysDsFieldLovDs
				,paramFields: net.nan21.dnet.module.ad.system.ds.param.SysDsFieldLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.system.ds.SysDsFieldLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 