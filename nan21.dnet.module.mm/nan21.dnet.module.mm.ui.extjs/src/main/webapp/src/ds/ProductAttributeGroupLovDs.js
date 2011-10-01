 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAttributeGroupLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 