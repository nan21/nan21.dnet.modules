 
   	 
Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"name",type:"string" }, 		
		{name:"code",type:"string" }, 		
		{name:"active",type:"boolean" }, 		
		{name:"notes",type:"string" }, 		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"iso3",type:"string" }, 		
		{name:"standardPrecision",type:"int", useNull:true }, 		
		{name:"symbol",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.currency.ds.param.CurrencyDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 