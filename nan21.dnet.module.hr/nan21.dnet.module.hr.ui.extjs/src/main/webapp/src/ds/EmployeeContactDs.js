 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"employeeId", type:"int", useNull:true},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"gender", type:"string"},
		{name:"relationshipId", type:"int", useNull:true},
		{name:"relationship", type:"string"},
		{name:"isDependent", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeId_From",type:"int", useNull:true},
		{name:"employeeId_To",type:"int", useNull:true},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthdate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthdate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"gender", type:"string"},
		{name:"relationshipId", type:"int", useNull:true},
		{name:"relationshipId_From",type:"int", useNull:true},
		{name:"relationshipId_To",type:"int", useNull:true},
		{name:"relationship", type:"string"},
		{name:"isDependent", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeContactDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 