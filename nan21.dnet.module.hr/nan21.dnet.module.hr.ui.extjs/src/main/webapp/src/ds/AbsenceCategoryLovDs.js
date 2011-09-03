 
   	 
Ext.ns("net.nan21.dnet.module.hr.time.ds.model");
	net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds.param");	
	net.nan21.dnet.module.hr.time.ds.param.AbsenceCategoryLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds");	
	net.nan21.dnet.module.hr.time.ds.AbsenceCategoryLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"AbsenceCategoryLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryLovDs
				,paramFields: net.nan21.dnet.module.hr.time.ds.param.AbsenceCategoryLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.time.ds.AbsenceCategoryLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 