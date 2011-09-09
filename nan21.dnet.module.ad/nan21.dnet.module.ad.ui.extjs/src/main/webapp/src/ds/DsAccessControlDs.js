 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"dsName",type:"string"}
	,	{name:"queryAllowed",type:"boolean"}
	,	{name:"insertAllowed",type:"boolean"}
	,	{name:"updateAllowed",type:"boolean"}
	,	{name:"deleteAllowed",type:"boolean"}
	,	{name:"importAllowed",type:"boolean"}
	,	{name:"exportAllowed",type:"boolean"}
	,	{name:"accessControlId",type:"int"}
	,	{name:"accessControl",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds.param");	
	net.nan21.dnet.module.ad.usr.ds.param.DsAccessControlDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.DsAccessControlDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"DsAccessControlDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.DsAccessControlDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.DsAccessControlDs.superclass.constructor.call(this, config);
		}	 
	});  
 