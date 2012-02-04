 
   	 
Ext.define("net.nan21.dnet.module.pj.base.ds.model.IssueTaskTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.pj.base.ds.model.IssueTaskTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.base.ds.param.IssueTaskTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 