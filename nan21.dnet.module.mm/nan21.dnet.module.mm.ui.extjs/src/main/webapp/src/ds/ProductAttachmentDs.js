 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"productId",type:"int", useNull:true }, 		
		{name:"typeId",type:"int", useNull:true }, 		
		{name:"type",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"location",type:"string" }, 		
		{name:"notes",type:"string" }, 		
		{name:"url",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAttachmentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 