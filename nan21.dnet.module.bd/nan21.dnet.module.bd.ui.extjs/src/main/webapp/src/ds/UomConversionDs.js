 
   	 
Ext.ns("net.nan21.dnet.module.bd.uom.ds.model");
	net.nan21.dnet.module.bd.uom.ds.model.UomConversionDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"sourceId",type:"int"}
	,	{name:"sourceCode",type:"string"}
	,	{name:"targetId",type:"int"}
	,	{name:"targetCode",type:"string"}
	,	{name:"multiplyWith",type:"float"}
	,	{name:"divideTo",type:"float"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds.param");	
	net.nan21.dnet.module.bd.uom.ds.param.UomConversionDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds");	
	net.nan21.dnet.module.bd.uom.ds.UomConversionDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UomConversionDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.uom.ds.model.UomConversionDs
				,paramFields: net.nan21.dnet.module.bd.uom.ds.param.UomConversionDsParam				 
			});
		 	net.nan21.dnet.module.bd.uom.ds.UomConversionDs.superclass.constructor.call(this, config);
		}	 
	});  
 