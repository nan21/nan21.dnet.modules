/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueRoadmapDs" ,{
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
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"status", type:"string"},
		{name:"code", type:"string"},
		{name:"summary", type:"string"},
		{name:"targetVersionId", type:"int", useNull:true},
		{name:"targetVersion", type:"string"},
		{name:"targetVersionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fixedInVersionId", type:"int", useNull:true},
		{name:"fixedInVersion", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueRoadmapDsFilter" ,{
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
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"statusId_From",type:"int", useNull:true},
		{name:"statusId_To",type:"int", useNull:true},
		{name:"status", type:"string"},
		{name:"code", type:"string"},
		{name:"summary", type:"string"},
		{name:"targetVersionId", type:"int", useNull:true},
		{name:"targetVersionId_From",type:"int", useNull:true},
		{name:"targetVersionId_To",type:"int", useNull:true},
		{name:"targetVersion", type:"string"},
		{name:"targetVersionDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"targetVersionDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"targetVersionDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fixedInVersionId", type:"int", useNull:true},
		{name:"fixedInVersionId_From",type:"int", useNull:true},
		{name:"fixedInVersionId_To",type:"int", useNull:true},
		{name:"fixedInVersion", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueRoadmapDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 