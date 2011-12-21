 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupAttributeDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"groupId",type:"int", useNull:true },
		{name:"group",type:"string" },
		{name:"attributeId",type:"int", useNull:true },
		{name:"attribute",type:"string" },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"inDescription",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupAttributeDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"groupId",type:"int", useNull:true },
		{name:"group",type:"string" },
		{name:"attributeId",type:"int", useNull:true },
		{name:"attribute",type:"string" },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"inDescription",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAttributeGroupAttributeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 