 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EducationTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EducationTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EducationTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EducationTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EducationTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EducationTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EducationTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 