 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAccountDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"organizationId",type:"int", useNull:true }, 		
		{name:"organizationCode",type:"string" }, 		
		{name:"groupId",type:"int", useNull:true }, 		
		{name:"groupCode",type:"string" }, 		
		{name:"productId",type:"int", useNull:true }, 		
		{name:"productCode",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 