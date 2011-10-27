 
   	 
Ext.define("net.nan21.dnet.module.ad.data.ds.model.NoteDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"note",type:"string" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetType",type:"string" }
	],
	validations: [ 
	]
});

Ext.define("net.nan21.dnet.module.ad.data.ds.model.NoteDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"note",type:"string" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetType",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.data.ds.param.NoteDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 