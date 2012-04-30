 
   	 
Ext.define("net.nan21.dnet.module.bd.tx.ds.model.TxDocTypePOLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"category", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.tx.ds.model.TxDocTypePOLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"category", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.tx.ds.param.TxDocTypePOLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 