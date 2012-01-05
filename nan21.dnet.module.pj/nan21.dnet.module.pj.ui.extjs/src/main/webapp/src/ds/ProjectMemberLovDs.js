 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectMemberLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"projectId", type:"int", useNull:true},
		{name:"roleId", type:"int", useNull:true},
		{name:"role", type:"string"},
		{name:"memberId", type:"int", useNull:true},
		{name:"member", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectMemberLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true},
		{name:"roleId", type:"int", useNull:true},
		{name:"roleId_From",type:"int", useNull:true},
		{name:"roleId_To",type:"int", useNull:true},
		{name:"role", type:"string"},
		{name:"memberId", type:"int", useNull:true},
		{name:"memberId_From",type:"int", useNull:true},
		{name:"memberId_To",type:"int", useNull:true},
		{name:"member", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectMemberLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 