 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionLineDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"transactionId",type:"int"}
	,	{name:"fromInventoryId",type:"int"}
	,	{name:"toInventoryId",type:"int"}
	,	{name:"itemId",type:"int"}
	,	{name:"itemCode",type:"string"}
	,	{name:"item",type:"string"}
	,	{name:"fromSubInventoryId",type:"int"}
	,	{name:"fromSubInventory",type:"string"}
	,	{name:"fromLocatorId",type:"int"}
	,	{name:"fromLocator",type:"string"}
	,	{name:"toSubInventoryId",type:"int"}
	,	{name:"toSubInventory",type:"string"}
	,	{name:"toLocatorId",type:"int"}
	,	{name:"toLocator",type:"string"}
	,	{name:"quantity",type:"float"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionLineDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.InvTransactionLineDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"InvTransactionLineDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionLineDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionLineDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.InvTransactionLineDs.superclass.constructor.call(this, config);
		}	 
	});  
 