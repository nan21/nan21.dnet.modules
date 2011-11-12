 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"productId",type:"int", useNull:true },
		{name:"attributeId",type:"int", useNull:true },
		{name:"attribute",type:"string" },
		{name:"title",type:"string" },
		{name:"dataType",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"uom",type:"string" },
		{name:"listOfvalues",type:"string" },
		{name:"value",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"productId",type:"int", useNull:true },
		{name:"attributeId",type:"int", useNull:true },
		{name:"attribute",type:"string" },
		{name:"title",type:"string" },
		{name:"dataType",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"uom",type:"string" },
		{name:"listOfvalues",type:"string" },
		{name:"value",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAttributeValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 