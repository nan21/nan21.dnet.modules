 
   	 
Ext.ns("net.nan21.dnet.module.hr.training.ds.model");
	net.nan21.dnet.module.hr.training.ds.model.CourseCategoryLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds.param");	
	net.nan21.dnet.module.hr.training.ds.param.CourseCategoryLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds");	
	net.nan21.dnet.module.hr.training.ds.CourseCategoryLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CourseCategoryLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.training.ds.model.CourseCategoryLovDs
				,paramFields: net.nan21.dnet.module.hr.training.ds.param.CourseCategoryLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.training.ds.CourseCategoryLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 