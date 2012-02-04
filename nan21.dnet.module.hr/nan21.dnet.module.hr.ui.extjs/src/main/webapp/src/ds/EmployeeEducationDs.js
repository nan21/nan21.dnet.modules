 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDs" ,{
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
		{name:"employeeId", type:"int", useNull:true},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"fromDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"toDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"institute", type:"string"},
		{name:"degree", type:"string"},
		{name:"notes", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDsFilter" ,{
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
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeId_From",type:"int", useNull:true},
		{name:"employeeId_To",type:"int", useNull:true},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"fromDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fromDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fromDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"toDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"toDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"toDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"institute", type:"string"},
		{name:"degree", type:"string"},
		{name:"notes", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeEducationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 