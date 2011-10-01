 
   	 
Ext.define("net.nan21.dnet.module.bp.base.ds.model.PaymentMethodLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bp.base.ds.param.PaymentMethodLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 