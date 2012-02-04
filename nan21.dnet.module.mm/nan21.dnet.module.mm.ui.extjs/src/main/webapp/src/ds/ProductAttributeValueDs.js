 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productName", type:"string"},
		{name:"groupId", type:"int", useNull:true},
		{name:"group", type:"string"},
		{name:"groupAttributeId", type:"int", useNull:true},
		{name:"attributeId", type:"int", useNull:true},
		{name:"attribute", type:"string"},
		{name:"title", type:"string"},
		{name:"dataType", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"uom", type:"string"},
		{name:"listOfvalues", type:"string"},
		{name:"value", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeValueDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productName", type:"string"},
		{name:"groupId", type:"int", useNull:true},
		{name:"groupId_From",type:"int", useNull:true},
		{name:"groupId_To",type:"int", useNull:true},
		{name:"group", type:"string"},
		{name:"groupAttributeId", type:"int", useNull:true},
		{name:"groupAttributeId_From",type:"int", useNull:true},
		{name:"groupAttributeId_To",type:"int", useNull:true},
		{name:"attributeId", type:"int", useNull:true},
		{name:"attributeId_From",type:"int", useNull:true},
		{name:"attributeId_To",type:"int", useNull:true},
		{name:"attribute", type:"string"},
		{name:"title", type:"string"},
		{name:"dataType", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"uom", type:"string"},
		{name:"listOfvalues", type:"string"},
		{name:"value", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAttributeValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 