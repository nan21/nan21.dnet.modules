 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueDs" ,{
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
		{name:"projectId", type:"int", useNull:true},
		{name:"project", type:"string"},
		{name:"projectName", type:"string"},
		{name:"code", type:"string"},
		{name:"summary", type:"string"},
		{name:"description", type:"string"},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"resolutionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"status", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"priority", type:"string"},
		{name:"resolutionId", type:"int", useNull:true},
		{name:"resolution", type:"string"},
		{name:"severityId", type:"int", useNull:true},
		{name:"severity", type:"string"},
		{name:"assigneeId", type:"int", useNull:true},
		{name:"assignee", type:"string"},
		{name:"assigneeRoleId", type:"int", useNull:true},
		{name:"assigneeRole", type:"string"},
		{name:"reportedVersionId", type:"int", useNull:true},
		{name:"reportedVersion", type:"string"},
		{name:"targetVersionId", type:"int", useNull:true},
		{name:"targetVersion", type:"string"},
		{name:"fixedInVersionId", type:"int", useNull:true},
		{name:"fixedInVersion", type:"string"},
		{name:"businessObject", type:"string"}
	],
	validations: [  
		{field: "summary", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueDsFilter" ,{
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
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true},
		{name:"project", type:"string"},
		{name:"projectName", type:"string"},
		{name:"code", type:"string"},
		{name:"summary", type:"string"},
		{name:"description", type:"string"},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"resolutionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"resolutionDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"resolutionDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"statusId_From",type:"int", useNull:true},
		{name:"statusId_To",type:"int", useNull:true},
		{name:"status", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"priorityId_From",type:"int", useNull:true},
		{name:"priorityId_To",type:"int", useNull:true},
		{name:"priority", type:"string"},
		{name:"resolutionId", type:"int", useNull:true},
		{name:"resolutionId_From",type:"int", useNull:true},
		{name:"resolutionId_To",type:"int", useNull:true},
		{name:"resolution", type:"string"},
		{name:"severityId", type:"int", useNull:true},
		{name:"severityId_From",type:"int", useNull:true},
		{name:"severityId_To",type:"int", useNull:true},
		{name:"severity", type:"string"},
		{name:"assigneeId", type:"int", useNull:true},
		{name:"assigneeId_From",type:"int", useNull:true},
		{name:"assigneeId_To",type:"int", useNull:true},
		{name:"assignee", type:"string"},
		{name:"assigneeRoleId", type:"int", useNull:true},
		{name:"assigneeRoleId_From",type:"int", useNull:true},
		{name:"assigneeRoleId_To",type:"int", useNull:true},
		{name:"assigneeRole", type:"string"},
		{name:"reportedVersionId", type:"int", useNull:true},
		{name:"reportedVersionId_From",type:"int", useNull:true},
		{name:"reportedVersionId_To",type:"int", useNull:true},
		{name:"reportedVersion", type:"string"},
		{name:"targetVersionId", type:"int", useNull:true},
		{name:"targetVersionId_From",type:"int", useNull:true},
		{name:"targetVersionId_To",type:"int", useNull:true},
		{name:"targetVersion", type:"string"},
		{name:"fixedInVersionId", type:"int", useNull:true},
		{name:"fixedInVersionId_From",type:"int", useNull:true},
		{name:"fixedInVersionId_To",type:"int", useNull:true},
		{name:"fixedInVersion", type:"string"},
		{name:"businessObject", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"affectedVersionId", type:"int", useNull:true},
		{name:"affectedVersion", type:"string"},
		{name:"affectedComponentId", type:"int", useNull:true},
		{name:"affectedComponent", type:"string"}
	]
}); 
 