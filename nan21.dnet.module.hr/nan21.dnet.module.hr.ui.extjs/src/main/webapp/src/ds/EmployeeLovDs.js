 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmployeeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"firstName",type:"string"}
	,	{name:"lastName",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"code",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmployeeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmployeeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmployeeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmployeeLovDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmployeeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmployeeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 