 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectAttachmentDs" ,{
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
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"category", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"project", type:"string"},
		{name:"name", type:"string"},
		{name:"location", type:"string"},
		{name:"notes", type:"string"},
		{name:"url", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectAttachmentDsFilter" ,{
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
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"category", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true},
		{name:"project", type:"string"},
		{name:"name", type:"string"},
		{name:"location", type:"string"},
		{name:"notes", type:"string"},
		{name:"url", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectAttachmentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 