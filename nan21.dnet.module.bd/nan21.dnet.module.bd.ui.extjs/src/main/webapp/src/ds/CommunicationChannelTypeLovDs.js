 
   	 
Ext.ns("net.nan21.dnet.module.bd.contact.ds.model");
	net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.contact.ds.param");	
	net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.contact.ds");	
	net.nan21.dnet.module.bd.contact.ds.CommunicationChannelTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CommunicationChannelTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeLovDs
				,paramFields: net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.contact.ds.CommunicationChannelTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 