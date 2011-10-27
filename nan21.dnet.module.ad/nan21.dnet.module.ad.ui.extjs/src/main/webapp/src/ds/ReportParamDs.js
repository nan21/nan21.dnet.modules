 
   	 
Ext.define("net.nan21.dnet.module.ad.report.ds.model.ReportParamDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"reportId",type:"int", useNull:true },
		{name:"reportCode",type:"string" },
		{name:"defaultValue",type:"string" },
		{name:"dataType",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "code", type: 'presence'}, 
		{field: "dataType", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.ad.report.ds.model.ReportParamDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"reportId",type:"int", useNull:true },
		{name:"reportCode",type:"string" },
		{name:"defaultValue",type:"string" },
		{name:"dataType",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.report.ds.param.ReportParamDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 