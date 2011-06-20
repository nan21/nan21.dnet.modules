 
   	 
Ext.ns("net.nan21.dnet.module.hr.job.ds.model");
	net.nan21.dnet.module.hr.job.ds.model.WorkRequirementLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds.param");	
	net.nan21.dnet.module.hr.job.ds.param.WorkRequirementLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds");	
	net.nan21.dnet.module.hr.job.ds.WorkRequirementLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WorkRequirementLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.job.ds.model.WorkRequirementLovDs
				,paramFields: net.nan21.dnet.module.hr.job.ds.param.WorkRequirementLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.job.ds.WorkRequirementLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 