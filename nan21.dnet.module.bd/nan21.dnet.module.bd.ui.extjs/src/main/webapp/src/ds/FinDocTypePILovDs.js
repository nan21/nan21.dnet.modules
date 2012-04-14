 
   	 
Ext.define("net.nan21.dnet.module.bd.fin.ds.model.FinDocTypePILovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"category", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.fin.ds.model.FinDocTypePILovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"category", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.fin.ds.param.FinDocTypePILovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 