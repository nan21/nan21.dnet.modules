 
   	 
Ext.define("net.nan21.dnet.module.bd.standards.ds.model.ClassificationCodeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"code",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }, 		
		{name:"classSystemId",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.standards.ds.param.ClassificationCodeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 