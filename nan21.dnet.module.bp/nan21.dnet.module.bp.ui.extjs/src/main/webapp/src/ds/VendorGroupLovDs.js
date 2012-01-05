 
   	 
Ext.define("net.nan21.dnet.module.bp.base.ds.model.VendorGroupLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bp.base.ds.model.VendorGroupLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.base.ds.param.VendorGroupLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 