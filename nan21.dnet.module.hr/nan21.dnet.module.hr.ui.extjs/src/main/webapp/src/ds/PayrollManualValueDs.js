/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollManualValueDs" ,{
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
		{name:"elementId", type:"int", useNull:true},
		{name:"element", type:"string"},
		{name:"elementName", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"dataType", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeName", type:"string"},
		{name:"periodId", type:"int", useNull:true},
		{name:"period", type:"string"},
		{name:"periodStart", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"value", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollManualValueDsFilter" ,{
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
		{name:"elementId", type:"int", useNull:true},
		{name:"elementId_From",type:"int", useNull:true},
		{name:"elementId_To",type:"int", useNull:true},
		{name:"element", type:"string"},
		{name:"elementName", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"dataType", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeId_From",type:"int", useNull:true},
		{name:"employeeId_To",type:"int", useNull:true},
		{name:"employeeName", type:"string"},
		{name:"periodId", type:"int", useNull:true},
		{name:"periodId_From",type:"int", useNull:true},
		{name:"periodId_To",type:"int", useNull:true},
		{name:"period", type:"string"},
		{name:"periodStart", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodStart_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodStart_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"periodEnd_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"value", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollManualValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 