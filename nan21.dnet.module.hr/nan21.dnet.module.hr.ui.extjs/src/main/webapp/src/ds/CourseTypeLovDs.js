 
   	 
Ext.ns("net.nan21.dnet.module.hr.training.ds.model");
	net.nan21.dnet.module.hr.training.ds.model.CourseTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds.param");	
	net.nan21.dnet.module.hr.training.ds.param.CourseTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds");	
	net.nan21.dnet.module.hr.training.ds.CourseTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CourseTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.training.ds.model.CourseTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.training.ds.param.CourseTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.training.ds.CourseTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 