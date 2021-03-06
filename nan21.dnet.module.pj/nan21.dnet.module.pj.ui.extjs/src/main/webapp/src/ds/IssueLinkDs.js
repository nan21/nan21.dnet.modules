/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueLinkDs" ,{
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
		{name:"sourceIssueId", type:"int", useNull:true},
		{name:"sourceIssue", type:"string"},
		{name:"sourceSummary", type:"string"},
		{name:"targetIssueId", type:"int", useNull:true},
		{name:"targetIssue", type:"string"},
		{name:"targetSummary", type:"string"},
		{name:"linkTypeId", type:"int", useNull:true},
		{name:"linkType", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueLinkDsFilter" ,{
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
		{name:"sourceIssueId", type:"int", useNull:true},
		{name:"sourceIssueId_From",type:"int", useNull:true},
		{name:"sourceIssueId_To",type:"int", useNull:true},
		{name:"sourceIssue", type:"string"},
		{name:"sourceSummary", type:"string"},
		{name:"targetIssueId", type:"int", useNull:true},
		{name:"targetIssueId_From",type:"int", useNull:true},
		{name:"targetIssueId_To",type:"int", useNull:true},
		{name:"targetIssue", type:"string"},
		{name:"targetSummary", type:"string"},
		{name:"linkTypeId", type:"int", useNull:true},
		{name:"linkTypeId_From",type:"int", useNull:true},
		{name:"linkTypeId_To",type:"int", useNull:true},
		{name:"linkType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueLinkDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 