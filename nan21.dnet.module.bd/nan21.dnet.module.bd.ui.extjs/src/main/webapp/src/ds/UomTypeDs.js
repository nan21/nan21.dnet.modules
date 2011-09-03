 
   	 
Ext.ns("net.nan21.dnet.module.bd.uom.ds.model");
	net.nan21.dnet.module.bd.uom.ds.model.UomTypeDs = [
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
	,	{name:"category",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds.param");	
	net.nan21.dnet.module.bd.uom.ds.param.UomTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds");	
	net.nan21.dnet.module.bd.uom.ds.UomTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UomTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.uom.ds.model.UomTypeDs
				,paramFields: net.nan21.dnet.module.bd.uom.ds.param.UomTypeDsParam				 
			});
		 	net.nan21.dnet.module.bd.uom.ds.UomTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 