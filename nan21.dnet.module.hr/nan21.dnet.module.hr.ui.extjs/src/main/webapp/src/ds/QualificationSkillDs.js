 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"qualificationId", type:"int", useNull:true},
		{name:"skillId", type:"int", useNull:true},
		{name:"skill", type:"string"},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"requiredLevelId", type:"int", useNull:true},
		{name:"requiredLevel", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"qualificationId", type:"int", useNull:true},
		{name:"qualificationId_From",type:"int", useNull:true},
		{name:"qualificationId_To",type:"int", useNull:true},
		{name:"skillId", type:"int", useNull:true},
		{name:"skillId_From",type:"int", useNull:true},
		{name:"skillId_To",type:"int", useNull:true},
		{name:"skill", type:"string"},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"ratingScaleId_From",type:"int", useNull:true},
		{name:"ratingScaleId_To",type:"int", useNull:true},
		{name:"requiredLevelId", type:"int", useNull:true},
		{name:"requiredLevelId_From",type:"int", useNull:true},
		{name:"requiredLevelId_To",type:"int", useNull:true},
		{name:"requiredLevel", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.QualificationSkillDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 