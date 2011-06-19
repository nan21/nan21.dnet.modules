 
   	 
Ext.ns("net.nan21.dnet.module.bd.contact.ds.model");
	net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeDs = [
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
	,	{name:"type",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.contact.ds.param");	
	net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.contact.ds");	
	net.nan21.dnet.module.bd.contact.ds.CommunicationChannelTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CommunicationChannelTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeDs
				,paramFields: net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelTypeDsParam				 
			});
		 	net.nan21.dnet.module.bd.contact.ds.CommunicationChannelTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 