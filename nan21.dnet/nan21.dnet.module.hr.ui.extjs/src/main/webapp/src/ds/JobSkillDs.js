 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.JobSkillDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"competenceId", type:"int", useNull:true},
		{name:"competence", type:"string"},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"requiredLevelId", type:"int", useNull:true},
		{name:"requiredLevel", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.hr.skill.ds.model.JobSkillDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobId_From",type:"int", useNull:true},
		{name:"jobId_To",type:"int", useNull:true},
		{name:"competenceId", type:"int", useNull:true},
		{name:"competenceId_From",type:"int", useNull:true},
		{name:"competenceId_To",type:"int", useNull:true},
		{name:"competence", type:"string"},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"ratingScaleId_From",type:"int", useNull:true},
		{name:"ratingScaleId_To",type:"int", useNull:true},
		{name:"requiredLevelId", type:"int", useNull:true},
		{name:"requiredLevelId_From",type:"int", useNull:true},
		{name:"requiredLevelId_To",type:"int", useNull:true},
		{name:"requiredLevel", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.JobSkillDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 