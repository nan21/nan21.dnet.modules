 
   	 
Ext.ns("net.nan21.dnet.module.ad.client.ds.model");
	net.nan21.dnet.module.ad.client.ds.model.ClientDs = [
	{name:"name",type:"string"}
	,	{name:"code",type:"string"}
	,	{name:"notes",type:"string"}
	,	{name:"maintenanceLanguage",type:"string"}
	,	{name:"defaultImportPath",type:"string"}
	,	{name:"defaultExportPath",type:"string"}
	,	{name:"tempPath",type:"string"}
	,	{name:"defaultDsAccessRule",type:"string"}
	,	{name:"adminRole",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.client.ds.param");	
	net.nan21.dnet.module.ad.client.ds.param.ClientDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.client.ds");	
	net.nan21.dnet.module.ad.client.ds.ClientDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ClientDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.client.ds.model.ClientDs
				,paramFields: net.nan21.dnet.module.ad.client.ds.param.ClientDsParam				 
			});
		 	net.nan21.dnet.module.ad.client.ds.ClientDs.superclass.constructor.call(this, config);
		}	 
	});  
 