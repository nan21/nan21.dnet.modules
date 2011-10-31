 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"projectId",type:"int", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"projectId",type:"int", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectVersionLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 