 
   	 
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.model");
	net.nan21.dnet.module.hr.payroll.ds.model.ElementCategoryLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.param");	
	net.nan21.dnet.module.hr.payroll.ds.param.ElementCategoryLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds");	
	net.nan21.dnet.module.hr.payroll.ds.ElementCategoryLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ElementCategoryLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.payroll.ds.model.ElementCategoryLovDs
				,paramFields: net.nan21.dnet.module.hr.payroll.ds.param.ElementCategoryLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.payroll.ds.ElementCategoryLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 