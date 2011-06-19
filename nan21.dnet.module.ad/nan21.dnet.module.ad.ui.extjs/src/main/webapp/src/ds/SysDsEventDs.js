 
   	 
Ext.ns("net.nan21.dnet.module.ad.system.ds.model");
	net.nan21.dnet.module.ad.system.ds.model.SysDsEventDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"dataSourceId",type:"int"}
	,	{name:"dataSource",type:"string"}
	,	{name:"name",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds.param");	
	net.nan21.dnet.module.ad.system.ds.param.SysDsEventDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.system.ds");	
	net.nan21.dnet.module.ad.system.ds.SysDsEventDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SysDsEventDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.system.ds.model.SysDsEventDs
				,paramFields: net.nan21.dnet.module.ad.system.ds.param.SysDsEventDsParam				 
			});
		 	net.nan21.dnet.module.ad.system.ds.SysDsEventDs.superclass.constructor.call(this, config);
		}	 
	});  
 