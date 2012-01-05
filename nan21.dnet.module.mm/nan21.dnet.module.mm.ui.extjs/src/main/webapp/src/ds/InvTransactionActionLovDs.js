 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionActionLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionActionLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionActionLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 