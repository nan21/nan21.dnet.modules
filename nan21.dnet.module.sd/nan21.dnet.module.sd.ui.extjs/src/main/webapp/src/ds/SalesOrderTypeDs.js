 
   	 
Ext.ns("net.nan21.dnet.module.sd.order.ds.model");
	net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeDs = [
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
Ext.ns("net.nan21.dnet.module.sd.order.ds.param");	
	net.nan21.dnet.module.sd.order.ds.param.SalesOrderTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds");	
	net.nan21.dnet.module.sd.order.ds.SalesOrderTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesOrderTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeDs
				,paramFields: net.nan21.dnet.module.sd.order.ds.param.SalesOrderTypeDsParam				 
			});
		 	net.nan21.dnet.module.sd.order.ds.SalesOrderTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 