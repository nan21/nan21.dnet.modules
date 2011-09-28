 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"dsName",type:"string" }, 		
		{name:"queryAllowed",type:"boolean" }, 		
		{name:"insertAllowed",type:"boolean" }, 		
		{name:"updateAllowed",type:"boolean" }, 		
		{name:"deleteAllowed",type:"boolean" }, 		
		{name:"importAllowed",type:"boolean" }, 		
		{name:"exportAllowed",type:"boolean" }, 		
		{name:"accessControlId",type:"int", useNull:true }, 		
		{name:"accessControl",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.DsAccessControlDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 