 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
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
		{name:"planDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"releaseDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"projectVersionId",type:"int", useNull:true },
		{name:"projectVersion",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"description",type:"string" },
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
		{name:"planDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"releaseDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"projectVersionId",type:"int", useNull:true },
		{name:"projectVersion",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectVersionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 