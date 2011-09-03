 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"productId",type:"int"}
	,	{name:"attributeId",type:"int"}
	,	{name:"attribute",type:"string"}
	,	{name:"value",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttributeValueDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttributeValueDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttributeValueDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttributeValueDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttributeValueDs.superclass.constructor.call(this, config);
		}	 
	});  
 