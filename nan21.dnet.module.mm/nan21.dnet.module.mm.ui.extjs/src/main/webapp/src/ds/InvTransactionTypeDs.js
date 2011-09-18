 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDs = [
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
	,	{name:"sourceTypeId",type:"int"}
	,	{name:"sourceType",type:"string"}
	,	{name:"actionId",type:"int"}
	,	{name:"action",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.InvTransactionTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"InvTransactionTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionTypeDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.InvTransactionTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 