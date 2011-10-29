 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemLinkDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceItemId",type:"int", useNull:true },
		{name:"sourceItem",type:"string" },
		{name:"targetItemId",type:"int", useNull:true },
		{name:"targetItem",type:"string" },
		{name:"linkTypeId",type:"int", useNull:true },
		{name:"linkType",type:"string" }
	],
	validations: [ 
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemLinkDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceItemId",type:"int", useNull:true },
		{name:"sourceItem",type:"string" },
		{name:"targetItemId",type:"int", useNull:true },
		{name:"targetItem",type:"string" },
		{name:"linkTypeId",type:"int", useNull:true },
		{name:"linkType",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ItemLinkDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 