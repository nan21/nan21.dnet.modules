 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"employeeId",type:"int"}
	,	{name:"firstName",type:"string"}
	,	{name:"lastName",type:"string"}
	,	{name:"birthdate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"gender",type:"string"}
	,	{name:"relationshipId",type:"int"}
	,	{name:"relationship",type:"string"}
	,	{name:"isDependent",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmployeeContactDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmployeeContactDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmployeeContactDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmployeeContactDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmployeeContactDs.superclass.constructor.call(this, config);
		}	 
	});  
 