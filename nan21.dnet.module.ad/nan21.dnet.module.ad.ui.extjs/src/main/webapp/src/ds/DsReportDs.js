 
   	 
Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"reportId",type:"int", useNull:true },
		{name:"reportCode",type:"string" },
		{name:"dataSource",type:"string" }
	],
	validations: [  
		{field: "dataSource", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"reportId",type:"int", useNull:true },
		{name:"reportCode",type:"string" },
		{name:"dataSource",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.report.ds.param.DsReportDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 