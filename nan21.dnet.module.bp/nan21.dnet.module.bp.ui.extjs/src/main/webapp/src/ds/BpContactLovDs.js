 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.BpContactLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"bpartnerId",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.BpContactLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 