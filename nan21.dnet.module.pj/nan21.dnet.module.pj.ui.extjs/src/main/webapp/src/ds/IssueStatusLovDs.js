 
   	 
Ext.define("net.nan21.dnet.module.pj.base.ds.model.IssueStatusLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.pj.base.ds.model.IssueStatusLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.base.ds.param.IssueStatusLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 