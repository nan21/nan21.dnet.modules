 
   	 
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.model");
	net.nan21.dnet.module.hr.payroll.ds.model.ElementLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.param");	
	net.nan21.dnet.module.hr.payroll.ds.param.ElementLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds");	
	net.nan21.dnet.module.hr.payroll.ds.ElementLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ElementLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.payroll.ds.model.ElementLovDs
				,paramFields: net.nan21.dnet.module.hr.payroll.ds.param.ElementLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.payroll.ds.ElementLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 