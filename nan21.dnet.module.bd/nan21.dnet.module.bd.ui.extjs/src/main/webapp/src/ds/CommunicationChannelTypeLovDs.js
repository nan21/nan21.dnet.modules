 
   	 
Ext.define("net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 