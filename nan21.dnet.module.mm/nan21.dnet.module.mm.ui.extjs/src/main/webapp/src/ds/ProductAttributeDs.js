 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"title",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"dataType",type:"string" },
		{name:"listOfvalues",type:"string" },
		{name:"uomId",type:"int", useNull:true },
		{name:"uom",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "title", type: 'presence'}, 
		{field: "dataType", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"title",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"dataType",type:"string" },
		{name:"listOfvalues",type:"string" },
		{name:"uomId",type:"int", useNull:true },
		{name:"uom",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAttributeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 