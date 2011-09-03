 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttributeDs = [
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
	,	{name:"title",type:"string"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"dataType",type:"string"}
	,	{name:"uomTypeId",type:"int"}
	,	{name:"uomType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttributeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttributeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttributeDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttributeDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttributeDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttributeDs.superclass.constructor.call(this, config);
		}	 
	});  
 