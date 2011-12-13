 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"storable",type:"boolean" },
		{name:"weight",type:"float", useNull:true },
		{name:"volume",type:"float", useNull:true },
		{name:"dimWidth",type:"float", useNull:true },
		{name:"dimHeight",type:"float", useNull:true },
		{name:"dimDepth",type:"float", useNull:true },
		{name:"manufacturerProductNo",type:"string" },
		{name:"defaultUomId",type:"int", useNull:true },
		{name:"defaultUomCode",type:"string" },
		{name:"weightUomId",type:"int", useNull:true },
		{name:"weightUomCode",type:"string" },
		{name:"volumeUomId",type:"int", useNull:true },
		{name:"volumeUomCode",type:"string" },
		{name:"dimUomId",type:"int", useNull:true },
		{name:"dimUomCode",type:"string" },
		{name:"manufacturerId",type:"int", useNull:true },
		{name:"manufacturerCode",type:"string" },
		{name:"attributeGroupId",type:"int", useNull:true },
		{name:"attributeGroup",type:"string" },
		{name:"className",type:"string" },
		{name:"businessObject",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"storable",type:"boolean", useNull:true },
		{name:"weight",type:"float", useNull:true },
		{name:"volume",type:"float", useNull:true },
		{name:"dimWidth",type:"float", useNull:true },
		{name:"dimHeight",type:"float", useNull:true },
		{name:"dimDepth",type:"float", useNull:true },
		{name:"manufacturerProductNo",type:"string" },
		{name:"defaultUomId",type:"int", useNull:true },
		{name:"defaultUomCode",type:"string" },
		{name:"weightUomId",type:"int", useNull:true },
		{name:"weightUomCode",type:"string" },
		{name:"volumeUomId",type:"int", useNull:true },
		{name:"volumeUomCode",type:"string" },
		{name:"dimUomId",type:"int", useNull:true },
		{name:"dimUomCode",type:"string" },
		{name:"manufacturerId",type:"int", useNull:true },
		{name:"manufacturerCode",type:"string" },
		{name:"attributeGroupId",type:"int", useNull:true },
		{name:"attributeGroup",type:"string" },
		{name:"className",type:"string" },
		{name:"businessObject",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 	
		{name:"productCategoryId",type:"int", useNull:true},	
		{name:"productCategory",type:"string"}
	]
}); 
 