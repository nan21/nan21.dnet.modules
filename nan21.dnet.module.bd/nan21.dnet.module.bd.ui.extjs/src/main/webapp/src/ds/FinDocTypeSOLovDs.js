 
   	 
Ext.define("net.nan21.dnet.module.bd.fin.ds.model.FinDocTypeSOLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"category", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.fin.ds.model.FinDocTypeSOLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"category", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.fin.ds.param.FinDocTypeSOLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 