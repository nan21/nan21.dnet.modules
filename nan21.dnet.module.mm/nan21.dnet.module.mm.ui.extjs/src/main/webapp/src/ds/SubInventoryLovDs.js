 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.SubInventoryLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"inventoryId",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.SubInventoryLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 