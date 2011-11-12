 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.RatingLevelDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"value",type:"int", useNull:true },
		{name:"ratingScaleId",type:"int", useNull:true },
		{name:"ratingScale",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.hr.skill.ds.model.RatingLevelDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"value",type:"int", useNull:true },
		{name:"ratingScaleId",type:"int", useNull:true },
		{name:"ratingScale",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.RatingLevelDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 