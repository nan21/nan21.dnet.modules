 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionSourceTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionSourceTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.InvTransactionSourceTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"InvTransactionSourceTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionSourceTypeLovDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionSourceTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.InvTransactionSourceTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 