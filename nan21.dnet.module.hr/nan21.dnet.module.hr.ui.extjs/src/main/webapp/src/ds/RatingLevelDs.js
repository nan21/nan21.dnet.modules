 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.RatingLevelDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"value",type:"int"}
	,	{name:"ratingScaleId",type:"int"}
	,	{name:"ratingScale",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.RatingLevelDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.RatingLevelDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"RatingLevelDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.RatingLevelDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.RatingLevelDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.RatingLevelDs.superclass.constructor.call(this, config);
		}	 
	});  
 