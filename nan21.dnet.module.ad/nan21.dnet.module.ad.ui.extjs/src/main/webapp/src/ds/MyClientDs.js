 
   	 
Ext.define("net.nan21.dnet.module.ad.client.ds.model.MyClientDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"notes",type:"string" },
		{name:"maintenanceLanguage",type:"string" },
		{name:"adminRole",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" }
	],
	validations: [ 
	]
});

Ext.define("net.nan21.dnet.module.ad.client.ds.model.MyClientDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"notes",type:"string" },
		{name:"maintenanceLanguage",type:"string" },
		{name:"adminRole",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.client.ds.param.MyClientDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 