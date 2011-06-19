 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.GradeRateLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.GradeRateLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.GradeRateLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"GradeRateLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.GradeRateLovDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.GradeRateLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.GradeRateLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 