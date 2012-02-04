 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectComponentLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"projectId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectComponentLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectComponentLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 