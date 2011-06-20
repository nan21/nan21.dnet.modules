 
   	 
Ext.ns("net.nan21.dnet.module.sd.order.ds.model");
	net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusDs = [
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
	,	{name:"sequenceNo",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds.param");	
	net.nan21.dnet.module.sd.order.ds.param.SalesOrderStatusDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds");	
	net.nan21.dnet.module.sd.order.ds.SalesOrderStatusDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesOrderStatusDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusDs
				,paramFields: net.nan21.dnet.module.sd.order.ds.param.SalesOrderStatusDsParam				 
			});
		 	net.nan21.dnet.module.sd.order.ds.SalesOrderStatusDs.superclass.constructor.call(this, config);
		}	 
	});  
 