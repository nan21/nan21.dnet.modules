 
   	 
Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportParamDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"dsReportId",type:"int", useNull:true }, 		
		{name:"reportId",type:"int", useNull:true }, 		
		{name:"reportCode",type:"string" }, 		
		{name:"paramId",type:"int", useNull:true }, 		
		{name:"paramCode",type:"string" }, 		
		{name:"paramName",type:"string" }, 		
		{name:"dataSource",type:"string" }, 		
		{name:"dsField",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.report.ds.param.DsReportParamDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 