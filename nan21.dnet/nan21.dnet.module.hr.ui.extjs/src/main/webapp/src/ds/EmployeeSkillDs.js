 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDs" ,{
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
		{name:"employeeId", type:"int", useNull:true},
		{name:"skillId", type:"int", useNull:true},
		{name:"skill", type:"string"},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"skillLevelId", type:"int", useNull:true},
		{name:"skillLevel", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDsFilter" ,{
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
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeId_From",type:"int", useNull:true},
		{name:"employeeId_To",type:"int", useNull:true},
		{name:"skillId", type:"int", useNull:true},
		{name:"skillId_From",type:"int", useNull:true},
		{name:"skillId_To",type:"int", useNull:true},
		{name:"skill", type:"string"},
		{name:"ratingScaleId", type:"int", useNull:true},
		{name:"ratingScaleId_From",type:"int", useNull:true},
		{name:"ratingScaleId_To",type:"int", useNull:true},
		{name:"skillLevelId", type:"int", useNull:true},
		{name:"skillLevelId_From",type:"int", useNull:true},
		{name:"skillLevelId_To",type:"int", useNull:true},
		{name:"skillLevel", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.EmployeeSkillDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 