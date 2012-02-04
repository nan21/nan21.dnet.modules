 
   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"payrollId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"payrollId", type:"int", useNull:true},
		{name:"payrollId_From",type:"int", useNull:true},
		{name:"payrollId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 