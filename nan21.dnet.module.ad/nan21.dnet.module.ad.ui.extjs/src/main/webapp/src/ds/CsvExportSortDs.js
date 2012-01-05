 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.CsvExportSortDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"csvExportId", type:"int", useNull:true},
		{name:"csvExport", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"dsField", type:"string"},
		{name:"descend", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.ad.impex.ds.model.CsvExportSortDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"csvExportId", type:"int", useNull:true},
		{name:"csvExportId_From",type:"int", useNull:true},
		{name:"csvExportId_To",type:"int", useNull:true},
		{name:"csvExport", type:"string"},
		{name:"dataSource", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"dsField", type:"string"},
		{name:"descend", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.CsvExportSortDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 