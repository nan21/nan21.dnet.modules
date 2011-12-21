 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueAttachmentDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"category",type:"string" },
		{name:"issueId",type:"int", useNull:true },
		{name:"issue",type:"string" },
		{name:"name",type:"string" },
		{name:"location",type:"string" },
		{name:"notes",type:"string" },
		{name:"url",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.IssueAttachmentDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"category",type:"string" },
		{name:"issueId",type:"int", useNull:true },
		{name:"issue",type:"string" },
		{name:"name",type:"string" },
		{name:"location",type:"string" },
		{name:"notes",type:"string" },
		{name:"url",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.IssueAttachmentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 