 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductDs = [
	{name:"name",type:"string"}
	,	{name:"code",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"notes",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"storable",type:"boolean"}
	,	{name:"weight",type:"float"}
	,	{name:"volume",type:"float"}
	,	{name:"dimWidth",type:"float"}
	,	{name:"dimHeight",type:"float"}
	,	{name:"dimDepth",type:"float"}
	,	{name:"manufacturerProductNo",type:"string"}
	,	{name:"defaultUomId",type:"int"}
	,	{name:"defaultUomCode",type:"string"}
	,	{name:"weightUomId",type:"int"}
	,	{name:"weightUomCode",type:"string"}
	,	{name:"volumeUomId",type:"int"}
	,	{name:"volumeUomCode",type:"string"}
	,	{name:"dimUomId",type:"int"}
	,	{name:"dimUomCode",type:"string"}
	,	{name:"manufacturerId",type:"int"}
	,	{name:"manufacturerCode",type:"string"}
	,	{name:"categoryId",type:"int"}
	,	{name:"categoryName",type:"string"}
	,	{name:"attributeGroupId",type:"int"}
	,	{name:"attributeGroup",type:"string"}
	,	{name:"className",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductDs.superclass.constructor.call(this, config);
		}	 
	});  
 