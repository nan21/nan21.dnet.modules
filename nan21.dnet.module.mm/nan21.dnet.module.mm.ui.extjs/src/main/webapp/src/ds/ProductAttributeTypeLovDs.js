 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAttributeTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 