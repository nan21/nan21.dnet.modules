 
   	 
Ext.ns("net.nan21.dnet.module.hr.job.ds.model");
	net.nan21.dnet.module.hr.job.ds.model.PositionLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds.param");	
	net.nan21.dnet.module.hr.job.ds.param.PositionLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds");	
	net.nan21.dnet.module.hr.job.ds.PositionLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PositionLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.job.ds.model.PositionLovDs
				,paramFields: net.nan21.dnet.module.hr.job.ds.param.PositionLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.job.ds.PositionLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 