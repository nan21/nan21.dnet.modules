 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDataSourceLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDataSourceLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 