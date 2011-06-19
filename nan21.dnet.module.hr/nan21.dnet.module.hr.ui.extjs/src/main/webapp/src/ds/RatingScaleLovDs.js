 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.RatingScaleLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.RatingScaleLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.RatingScaleLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"RatingScaleLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.RatingScaleLovDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.RatingScaleLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.RatingScaleLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 