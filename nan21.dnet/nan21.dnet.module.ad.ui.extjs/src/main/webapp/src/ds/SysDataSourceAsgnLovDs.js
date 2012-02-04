 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDataSourceAsgnLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDataSourceAsgnLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDataSourceAsgnLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 