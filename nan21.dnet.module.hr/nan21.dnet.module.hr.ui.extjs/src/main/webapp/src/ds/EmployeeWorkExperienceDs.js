 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmployeeWorkExperienceDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"employeeId",type:"int"}
	,	{name:"fromDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"toDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"institute",type:"string"}
	,	{name:"notes",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmployeeWorkExperienceDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmployeeWorkExperienceDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmployeeWorkExperienceDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmployeeWorkExperienceDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmployeeWorkExperienceDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmployeeWorkExperienceDs.superclass.constructor.call(this, config);
		}	 
	});  
 