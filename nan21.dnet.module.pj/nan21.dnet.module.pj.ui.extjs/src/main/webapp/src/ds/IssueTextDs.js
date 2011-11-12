 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueTextDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"issueId",type:"int", useNull:true },
		{name:"issueTextTypeId",type:"int", useNull:true },
		{name:"issueTextType",type:"string" },
		{name:"content",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueTextDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"issueId",type:"int", useNull:true },
		{name:"issueTextTypeId",type:"int", useNull:true },
		{name:"issueTextType",type:"string" },
		{name:"content",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueTextDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 