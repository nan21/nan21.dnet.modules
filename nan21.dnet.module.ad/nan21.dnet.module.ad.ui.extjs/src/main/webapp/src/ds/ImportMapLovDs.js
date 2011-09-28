 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ImportMapLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.ImportMapLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 