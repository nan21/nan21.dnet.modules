 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.InvTransactionTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"InvTransactionTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeLovDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.InvTransactionTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 