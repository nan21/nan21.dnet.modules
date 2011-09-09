 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.AccessControlDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds.param");	
	net.nan21.dnet.module.ad.usr.ds.param.AccessControlDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.AccessControlDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"AccessControlDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.AccessControlDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.AccessControlDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.AccessControlDs.superclass.constructor.call(this, config);
		}	 
	});  
 