/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs" ,{
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
		{name:"code", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"employerCode", type:"string"},
		{name:"businessObject", type:"string"},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"gender", type:"string"},
		{name:"maritalStatus", type:"string"},
		{name:"sinNo", type:"string"},
		{name:"ssnNo", type:"string"},
		{name:"hasDisability", type:"boolean"},
		{name:"firstHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currentHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"officeEmail", type:"string"},
		{name:"citizenshipId", type:"int", useNull:true},
		{name:"citizenshipCode", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"className", type:"string"}
	],
	validations: [  
		{field: "firstName", type: 'presence'}, 
		{field: "lastName", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeDsFilter" ,{
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
		{name:"code", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"employerId_From",type:"int", useNull:true},
		{name:"employerId_To",type:"int", useNull:true},
		{name:"employerCode", type:"string"},
		{name:"businessObject", type:"string"},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthdate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthdate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"gender", type:"string"},
		{name:"maritalStatus", type:"string"},
		{name:"sinNo", type:"string"},
		{name:"ssnNo", type:"string"},
		{name:"hasDisability", type:"boolean", useNull:true},
		{name:"firstHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"firstHireDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"firstHireDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currentHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currentHireDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currentHireDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"officeEmail", type:"string"},
		{name:"citizenshipId", type:"int", useNull:true},
		{name:"citizenshipId_From",type:"int", useNull:true},
		{name:"citizenshipId_To",type:"int", useNull:true},
		{name:"citizenshipCode", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"className", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 