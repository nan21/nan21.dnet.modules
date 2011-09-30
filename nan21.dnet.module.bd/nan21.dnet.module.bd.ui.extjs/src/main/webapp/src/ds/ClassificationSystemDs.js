 
   	 
Ext.define("net.nan21.dnet.module.bd.standards.ds.model.ClassificationSystemDs" , {
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
		{name:"version",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.standards.ds.param.ClassificationSystemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 