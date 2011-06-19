 
   	 
Ext.ns("net.nan21.dnet.module.bd.contact.ds.model");
	net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"targetId",type:"int"}
	,	{name:"targetType",type:"string"}
	,	{name:"value",type:"string"}
	,	{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.bd.contact.ds.param");	
	net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.contact.ds");	
	net.nan21.dnet.module.bd.contact.ds.CommunicationChannelDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CommunicationChannelDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDs
				,paramFields: net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelDsParam				 
			});
		 	net.nan21.dnet.module.bd.contact.ds.CommunicationChannelDs.superclass.constructor.call(this, config);
		}	 
	});  
 