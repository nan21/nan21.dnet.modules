 
   	 
Ext.define("net.nan21.dnet.module.bp.base.ds.model.CustomerGroupLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bp.base.ds.param.CustomerGroupLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 