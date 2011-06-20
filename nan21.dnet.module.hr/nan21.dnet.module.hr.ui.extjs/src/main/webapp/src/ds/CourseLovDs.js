 
   	 
Ext.ns("net.nan21.dnet.module.hr.training.ds.model");
	net.nan21.dnet.module.hr.training.ds.model.CourseLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds.param");	
	net.nan21.dnet.module.hr.training.ds.param.CourseLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds");	
	net.nan21.dnet.module.hr.training.ds.CourseLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CourseLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.training.ds.model.CourseLovDs
				,paramFields: net.nan21.dnet.module.hr.training.ds.param.CourseLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.training.ds.CourseLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 