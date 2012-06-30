/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"payrollId", type:"int", useNull:true},
		{name:"payrollName", type:"string"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"processed", type:"boolean"},
		{name:"closed", type:"boolean"}
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "startDate", type: 'presence'}, 
		{field: "endDate", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
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
		{name:"payrollId", type:"int", useNull:true},
		{name:"payrollId_From",type:"int", useNull:true},
		{name:"payrollId_To",type:"int", useNull:true},
		{name:"payrollName", type:"string"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"processed", type:"boolean", useNull:true},
		{name:"closed", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 