 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsFieldLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }, 		
		{name:"dataSourceId",type:"int", useNull:true }, 		
		{name:"dataSourceName",type:"string" }, 		
		{name:"dataType",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDsFieldLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 