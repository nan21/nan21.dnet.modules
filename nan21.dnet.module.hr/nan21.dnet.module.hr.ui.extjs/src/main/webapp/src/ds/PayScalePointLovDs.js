 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDs = [
	{name:"name",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"payScaleId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.PayScalePointLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.PayScalePointLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PayScalePointLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.PayScalePointLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.PayScalePointLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 