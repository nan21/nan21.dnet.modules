 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"employerId",type:"int", useNull:true },
		{name:"employerCode",type:"string" },
		{name:"businessObject",type:"string" },
		{name:"code",type:"string" },
		{name:"firstName",type:"string" },
		{name:"lastName",type:"string" },
		{name:"middleName",type:"string" },
		{name:"birthdate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"gender",type:"string" },
		{name:"maritalStatus",type:"string" },
		{name:"sinNo",type:"string" },
		{name:"ssnNo",type:"string" },
		{name:"hasDisability",type:"boolean" },
		{name:"firstHireDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"currentHireDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"officeEmail",type:"string" },
		{name:"citizenshipId",type:"int", useNull:true },
		{name:"citizenshipCode",type:"string" },
		{name:"passportNo",type:"string" },
		{name:"className",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"assignToPosition",type:"boolean" },
		{name:"gradeId",type:"int", useNull:true },
		{name:"gradeCode",type:"string" },
		{name:"jobId",type:"int", useNull:true },
		{name:"jobCode",type:"string" },
		{name:"jobName",type:"string" },
		{name:"positionId",type:"int", useNull:true },
		{name:"positionCode",type:"string" },
		{name:"positionName",type:"string" },
		{name:"posOrgId",type:"int", useNull:true },
		{name:"posOrgCode",type:"string" },
		{name:"organizationId",type:"int", useNull:true },
		{name:"organizationCode",type:"string" },
		{name:"baseSalary",type:"float", useNull:true },
		{name:"payrollId",type:"int", useNull:true },
		{name:"payroll",type:"string" }
	],
	validations: [  
		{field: "lastName", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 