 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueLinkDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceIssueId",type:"int", useNull:true },
		{name:"sourceIssue",type:"string" },
		{name:"sourceSummary",type:"string" },
		{name:"targetIssueId",type:"int", useNull:true },
		{name:"targetIssue",type:"string" },
		{name:"targetSummary",type:"string" },
		{name:"linkTypeId",type:"int", useNull:true },
		{name:"linkType",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueLinkDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceIssueId",type:"int", useNull:true },
		{name:"sourceIssue",type:"string" },
		{name:"sourceSummary",type:"string" },
		{name:"targetIssueId",type:"int", useNull:true },
		{name:"targetIssue",type:"string" },
		{name:"targetSummary",type:"string" },
		{name:"linkTypeId",type:"int", useNull:true },
		{name:"linkType",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueLinkDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 