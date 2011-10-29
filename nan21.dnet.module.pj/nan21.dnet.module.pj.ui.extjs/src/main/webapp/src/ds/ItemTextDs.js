 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemTextDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"itemId",type:"int", useNull:true },
		{name:"itemTextTypeId",type:"int", useNull:true },
		{name:"itemTextType",type:"string" },
		{name:"content",type:"string" }
	],
	validations: [ 
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemTextDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"itemId",type:"int", useNull:true },
		{name:"itemTextTypeId",type:"int", useNull:true },
		{name:"itemTextType",type:"string" },
		{name:"content",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ItemTextDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 