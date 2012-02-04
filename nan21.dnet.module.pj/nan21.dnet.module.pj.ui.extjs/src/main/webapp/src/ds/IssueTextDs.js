 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueTextDs" ,{
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
		{name:"issueId", type:"int", useNull:true},
		{name:"issueTextTypeId", type:"int", useNull:true},
		{name:"issueTextType", type:"string"},
		{name:"content", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueTextDsFilter" ,{
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
		{name:"issueId", type:"int", useNull:true},
		{name:"issueId_From",type:"int", useNull:true},
		{name:"issueId_To",type:"int", useNull:true},
		{name:"issueTextTypeId", type:"int", useNull:true},
		{name:"issueTextTypeId_From",type:"int", useNull:true},
		{name:"issueTextTypeId_To",type:"int", useNull:true},
		{name:"issueTextType", type:"string"},
		{name:"content", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueTextDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 