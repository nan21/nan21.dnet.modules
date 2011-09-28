 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"code",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 