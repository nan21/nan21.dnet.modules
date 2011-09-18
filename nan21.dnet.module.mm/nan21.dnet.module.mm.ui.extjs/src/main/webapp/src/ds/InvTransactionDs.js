 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"transactionTypeId",type:"int"}
	,	{name:"transactionType",type:"string"}
	,	{name:"fromInventoryId",type:"int"}
	,	{name:"fromInventory",type:"string"}
	,	{name:"toInventoryId",type:"int"}
	,	{name:"toInventory",type:"string"}
	,	{name:"eventDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.InvTransactionDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"InvTransactionDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.InvTransactionDs.superclass.constructor.call(this, config);
		}	 
	});  
 