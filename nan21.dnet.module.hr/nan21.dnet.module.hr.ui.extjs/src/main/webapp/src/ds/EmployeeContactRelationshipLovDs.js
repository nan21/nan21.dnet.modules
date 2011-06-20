 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactRelationshipLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmployeeContactRelationshipLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmployeeContactRelationshipLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmployeeContactRelationshipLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactRelationshipLovDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmployeeContactRelationshipLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmployeeContactRelationshipLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 