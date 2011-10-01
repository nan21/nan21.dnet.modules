 
   	 
Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.uom.ds.param.UomTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 