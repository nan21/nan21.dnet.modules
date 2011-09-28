 
   	 
Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"code",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.uom.ds.param.UomLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 