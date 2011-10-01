 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeWorkExperienceDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"employeeId",type:"int", useNull:true },
		{name:"fromDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"toDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"institute",type:"string" },
		{name:"notes",type:"string" }
	],
	validations: [ 
	]
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeWorkExperienceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 