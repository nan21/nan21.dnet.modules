 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"exportMapId",type:"int", useNull:true },
		{name:"exportMap",type:"string" },
		{name:"csvExportId",type:"int", useNull:true },
		{name:"csvExport",type:"string" },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"fileName",type:"string" },
		{name:"active",type:"boolean" }
	],
	validations: [  
		{field: "sequenceNo", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ExportMapItemDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"exportMapId",type:"int", useNull:true },
		{name:"exportMap",type:"string" },
		{name:"csvExportId",type:"int", useNull:true },
		{name:"csvExport",type:"string" },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"fileName",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.ExportMapItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 