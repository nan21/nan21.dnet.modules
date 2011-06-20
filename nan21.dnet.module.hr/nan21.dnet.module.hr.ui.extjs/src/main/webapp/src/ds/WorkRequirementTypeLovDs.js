 
   	 
Ext.ns("net.nan21.dnet.module.hr.job.ds.model");
	net.nan21.dnet.module.hr.job.ds.model.WorkRequirementTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds.param");	
	net.nan21.dnet.module.hr.job.ds.param.WorkRequirementTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds");	
	net.nan21.dnet.module.hr.job.ds.WorkRequirementTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WorkRequirementTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.job.ds.model.WorkRequirementTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.job.ds.param.WorkRequirementTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.job.ds.WorkRequirementTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 