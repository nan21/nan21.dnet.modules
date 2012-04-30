 
   	 
Ext.define("net.nan21.dnet.module.bd.tx.ds.model.TxDocTypePILovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"category", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.tx.ds.model.TxDocTypePILovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"category", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.tx.ds.param.TxDocTypePILovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 