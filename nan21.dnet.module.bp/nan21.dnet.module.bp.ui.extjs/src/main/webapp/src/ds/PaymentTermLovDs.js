 
   	 
Ext.define("net.nan21.dnet.module.bp.base.ds.model.PaymentTermLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bp.base.ds.param.PaymentTermLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 