 
   	 
Ext.ns("net.nan21.dnet.module.hr.job.ds.model");
	net.nan21.dnet.module.hr.job.ds.model.JobTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds.param");	
	net.nan21.dnet.module.hr.job.ds.param.JobTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds");	
	net.nan21.dnet.module.hr.job.ds.JobTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"JobTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.job.ds.model.JobTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.job.ds.param.JobTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.job.ds.JobTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 