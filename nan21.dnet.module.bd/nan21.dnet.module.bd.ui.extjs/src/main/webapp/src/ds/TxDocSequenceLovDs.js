 
   	 
Ext.define("net.nan21.dnet.module.bd.tx.ds.model.TxDocSequenceLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.tx.ds.model.TxDocSequenceLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.tx.ds.param.TxDocSequenceLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 