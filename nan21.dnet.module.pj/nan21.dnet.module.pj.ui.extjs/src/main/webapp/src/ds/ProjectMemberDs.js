 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectMemberDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"projectId",type:"int", useNull:true },
		{name:"project",type:"string" },
		{name:"projectName",type:"string" },
		{name:"roleId",type:"int", useNull:true },
		{name:"role",type:"string" },
		{name:"memberId",type:"int", useNull:true },
		{name:"member",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectMemberDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"projectId",type:"int", useNull:true },
		{name:"project",type:"string" },
		{name:"projectName",type:"string" },
		{name:"roleId",type:"int", useNull:true },
		{name:"role",type:"string" },
		{name:"memberId",type:"int", useNull:true },
		{name:"member",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectMemberDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 