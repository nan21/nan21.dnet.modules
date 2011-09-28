 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.RegionDs" , {
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
		{name:"iso",type:"string" }, 		
		{name:"countryId",type:"int", useNull:true }, 		
		{name:"countryCode",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.RegionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 