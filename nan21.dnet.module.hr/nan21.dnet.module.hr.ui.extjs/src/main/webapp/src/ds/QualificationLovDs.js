 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.QualificationLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.QualificationLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.QualificationLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"QualificationLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.QualificationLovDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.QualificationLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.QualificationLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 