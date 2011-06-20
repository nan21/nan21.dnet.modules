 
   	 
Ext.ns("net.nan21.dnet.module.hr.job.ds.model");
	net.nan21.dnet.module.hr.job.ds.model.JobLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds.param");	
	net.nan21.dnet.module.hr.job.ds.param.JobLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds");	
	net.nan21.dnet.module.hr.job.ds.JobLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"JobLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.job.ds.model.JobLovDs
				,paramFields: net.nan21.dnet.module.hr.job.ds.param.JobLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.job.ds.JobLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 