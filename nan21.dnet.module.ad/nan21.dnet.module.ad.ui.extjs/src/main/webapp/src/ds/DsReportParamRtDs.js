/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportParamRtDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"dsReportId", type:"int", useNull:true},
		{name:"reportId", type:"int", useNull:true},
		{name:"reportCode", type:"string"},
		{name:"paramId", type:"int", useNull:true},
		{name:"paramCode", type:"string"},
		{name:"paramName", type:"string"},
		{name:"paramDataType", type:"string"},
		{name:"paramMandatory", type:"boolean"},
		{name:"paramDefaultValue", type:"string"},
		{name:"paramListOfValues", type:"string"},
		{name:"paramNoEdit", type:"boolean"},
		{name:"dataSource", type:"string"},
		{name:"dsField", type:"string"},
		{name:"staticValue", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.report.ds.model.DsReportParamRtDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"dsReportId", type:"int", useNull:true},
		{name:"dsReportId_From",type:"int", useNull:true},
		{name:"dsReportId_To",type:"int", useNull:true},
		{name:"reportId", type:"int", useNull:true},
		{name:"reportId_From",type:"int", useNull:true},
		{name:"reportId_To",type:"int", useNull:true},
		{name:"reportCode", type:"string"},
		{name:"paramId", type:"int", useNull:true},
		{name:"paramId_From",type:"int", useNull:true},
		{name:"paramId_To",type:"int", useNull:true},
		{name:"paramCode", type:"string"},
		{name:"paramName", type:"string"},
		{name:"paramDataType", type:"string"},
		{name:"paramMandatory", type:"boolean", useNull:true},
		{name:"paramDefaultValue", type:"string"},
		{name:"paramListOfValues", type:"string"},
		{name:"paramNoEdit", type:"boolean", useNull:true},
		{name:"dataSource", type:"string"},
		{name:"dsField", type:"string"},
		{name:"staticValue", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.report.ds.param.DsReportParamRtDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 