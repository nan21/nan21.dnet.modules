 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"projectId",type:"int", useNull:true },
		{name:"project",type:"string" },
		{name:"projectName",type:"string" },
		{name:"code",type:"string" },
		{name:"summary",type:"string" },
		{name:"description",type:"string" },
		{name:"dueDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"resolutionDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"status",type:"string" },
		{name:"priorityId",type:"int", useNull:true },
		{name:"priority",type:"string" },
		{name:"resolutionId",type:"int", useNull:true },
		{name:"resolution",type:"string" },
		{name:"severityId",type:"int", useNull:true },
		{name:"severity",type:"string" },
		{name:"assigneeId",type:"int", useNull:true },
		{name:"assignee",type:"string" },
		{name:"assigneeRoleId",type:"int", useNull:true },
		{name:"assigneeRole",type:"string" },
		{name:"className",type:"string" },
		{name:"reportedVersionId",type:"int", useNull:true },
		{name:"reportedVersion",type:"string" },
		{name:"targetVersionId",type:"int", useNull:true },
		{name:"targetVersion",type:"string" },
		{name:"fixedInVersionId",type:"int", useNull:true },
		{name:"fixedInVersion",type:"string" },
		{name:"businessObject",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"projectId",type:"int", useNull:true },
		{name:"project",type:"string" },
		{name:"projectName",type:"string" },
		{name:"code",type:"string" },
		{name:"summary",type:"string" },
		{name:"description",type:"string" },
		{name:"dueDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"resolutionDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"status",type:"string" },
		{name:"priorityId",type:"int", useNull:true },
		{name:"priority",type:"string" },
		{name:"resolutionId",type:"int", useNull:true },
		{name:"resolution",type:"string" },
		{name:"severityId",type:"int", useNull:true },
		{name:"severity",type:"string" },
		{name:"assigneeId",type:"int", useNull:true },
		{name:"assignee",type:"string" },
		{name:"assigneeRoleId",type:"int", useNull:true },
		{name:"assigneeRole",type:"string" },
		{name:"className",type:"string" },
		{name:"reportedVersionId",type:"int", useNull:true },
		{name:"reportedVersion",type:"string" },
		{name:"targetVersionId",type:"int", useNull:true },
		{name:"targetVersion",type:"string" },
		{name:"fixedInVersionId",type:"int", useNull:true },
		{name:"fixedInVersion",type:"string" },
		{name:"businessObject",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 