/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"payrollId", type:"int", useNull:true},
		{name:"active", type:"boolean"},
		{name:"processed", type:"boolean"},
		{name:"closed", type:"boolean"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"payrollId", type:"int", useNull:true},
		{name:"payrollId_From",type:"int", useNull:true},
		{name:"payrollId_To",type:"int", useNull:true},
		{name:"active", type:"boolean", useNull:true},
		{name:"processed", type:"boolean", useNull:true},
		{name:"closed", type:"boolean", useNull:true},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 