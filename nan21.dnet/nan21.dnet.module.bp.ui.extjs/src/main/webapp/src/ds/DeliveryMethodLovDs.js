 
   	 
Ext.define("net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.base.ds.param.DeliveryMethodLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 