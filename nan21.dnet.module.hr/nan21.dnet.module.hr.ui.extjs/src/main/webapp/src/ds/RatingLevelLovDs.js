 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.RatingLevelLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"ratingScaleId",type:"int"}
	,	{name:"value",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.RatingLevelLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.RatingLevelLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"RatingLevelLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.RatingLevelLovDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.RatingLevelLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.RatingLevelLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 