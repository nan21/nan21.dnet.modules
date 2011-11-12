 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueTaskDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"summary",type:"string" },
		{name:"description",type:"string" },
		{name:"issueId",type:"int", useNull:true },
		{name:"issue",type:"string" },
		{name:"issueSummary",type:"string" },
		{name:"issuePriorityId",type:"int", useNull:true },
		{name:"issuePriority",type:"string" },
		{name:"issueTypeId",type:"int", useNull:true },
		{name:"issueType",type:"string" },
		{name:"issueStatusId",type:"int", useNull:true },
		{name:"issueStatus",type:"string" },
		{name:"issueSeverityId",type:"int", useNull:true },
		{name:"issueSeverity",type:"string" },
		{name:"issuePrioritySequenceNo",type:"int", useNull:true },
		{name:"issueBusinessObject",type:"string" },
		{name:"issueClassName",type:"string" },
		{name:"projectId",type:"int", useNull:true },
		{name:"project",type:"string" },
		{name:"projectName",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"status",type:"string" },
		{name:"assigneeId",type:"int", useNull:true },
		{name:"assignee",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueTaskDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"summary",type:"string" },
		{name:"description",type:"string" },
		{name:"issueId",type:"int", useNull:true },
		{name:"issue",type:"string" },
		{name:"issueSummary",type:"string" },
		{name:"issuePriorityId",type:"int", useNull:true },
		{name:"issuePriority",type:"string" },
		{name:"issueTypeId",type:"int", useNull:true },
		{name:"issueType",type:"string" },
		{name:"issueStatusId",type:"int", useNull:true },
		{name:"issueStatus",type:"string" },
		{name:"issueSeverityId",type:"int", useNull:true },
		{name:"issueSeverity",type:"string" },
		{name:"issuePrioritySequenceNo",type:"int", useNull:true },
		{name:"issueBusinessObject",type:"string" },
		{name:"issueClassName",type:"string" },
		{name:"projectId",type:"int", useNull:true },
		{name:"project",type:"string" },
		{name:"projectName",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"status",type:"string" },
		{name:"assigneeId",type:"int", useNull:true },
		{name:"assignee",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueTaskDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 