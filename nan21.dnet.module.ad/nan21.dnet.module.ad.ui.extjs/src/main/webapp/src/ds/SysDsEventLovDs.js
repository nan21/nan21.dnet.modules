 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsEventLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"dataSourceId",type:"int", useNull:true }, 		
		{name:"dataSourceName",type:"string" }, 		
		{name:"name",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDsEventLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 