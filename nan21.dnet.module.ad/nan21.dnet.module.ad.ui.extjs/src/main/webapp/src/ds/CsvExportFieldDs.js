 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.CsvExportFieldDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"csvExportId",type:"int", useNull:true },
		{name:"csvExport",type:"string" },
		{name:"dataSource",type:"string" },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"dsField",type:"string" },
		{name:"alias",type:"string" },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.ad.impex.ds.model.CsvExportFieldDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"csvExportId",type:"int", useNull:true },
		{name:"csvExport",type:"string" },
		{name:"dataSource",type:"string" },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"dsField",type:"string" },
		{name:"alias",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.CsvExportFieldDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 