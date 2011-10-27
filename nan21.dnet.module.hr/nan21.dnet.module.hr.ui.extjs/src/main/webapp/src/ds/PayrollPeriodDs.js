 
   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"startDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"endDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"payrollId",type:"int", useNull:true },
		{name:"payrollName",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "startDate", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"startDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"endDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"payrollId",type:"int", useNull:true },
		{name:"payrollName",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 