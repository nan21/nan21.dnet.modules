 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
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
		{name:"planDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"releaseDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"projectVersionId", type:"int", useNull:true},
		{name:"projectVersion", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
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
		{name:"planDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"planDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"planDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"releaseDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"releaseDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"releaseDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"projectVersionId", type:"int", useNull:true},
		{name:"projectVersionId_From",type:"int", useNull:true},
		{name:"projectVersionId_To",type:"int", useNull:true},
		{name:"projectVersion", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectVersionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"hideReleased", type:"boolean"},
		{name:"hideDue", type:"boolean"}
	]
}); 
 