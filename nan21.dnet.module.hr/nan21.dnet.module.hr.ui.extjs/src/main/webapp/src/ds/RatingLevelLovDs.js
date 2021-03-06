/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.RatingLevelLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"value", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.hr.skill.ds.model.RatingLevelLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"ratingScaleId_From",type:"int", useNull:true},
		{name:"ratingScaleId_To",type:"int", useNull:true},
		{name:"value", type:"int", useNull:true},
		{name:"value_From",type:"int", useNull:true},
		{name:"value_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.RatingLevelLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 