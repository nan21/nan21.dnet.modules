 
   	 
Ext.define("net.nan21.dnet.module.ad.client.ds.model.ClientDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"notes",type:"string" },
		{name:"maintenanceLanguage",type:"string" },
		{name:"defaultImportPath",type:"string" },
		{name:"defaultExportPath",type:"string" },
		{name:"tempPath",type:"string" },
		{name:"systemClient",type:"boolean" },
		{name:"defaultDsAccessRule",type:"string" },
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

Ext.define("net.nan21.dnet.module.ad.client.ds.model.ClientDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"notes",type:"string" },
		{name:"maintenanceLanguage",type:"string" },
		{name:"defaultImportPath",type:"string" },
		{name:"defaultExportPath",type:"string" },
		{name:"tempPath",type:"string" },
		{name:"systemClient",type:"boolean", useNull:true },
		{name:"defaultDsAccessRule",type:"string" },
		{name:"adminRole",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.client.ds.param.ClientDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 	
		{name:"adminUserCode",type:"string"},	
		{name:"adminUserName",type:"string"},	
		{name:"adminPassword",type:"string"}
	]
}); 
 