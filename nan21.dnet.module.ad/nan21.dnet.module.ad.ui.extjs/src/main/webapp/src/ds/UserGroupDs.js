 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.UserGroupDs = [
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
	net.nan21.dnet.module.ad.usr.ds.param.UserGroupDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.UserGroupDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UserGroupDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.UserGroupDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.UserGroupDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.UserGroupDs.superclass.constructor.call(this, config);
		}	 
	});  
 