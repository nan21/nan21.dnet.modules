 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.PositionDs" , {
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
		{name:"jobId",type:"int", useNull:true }, 		
		{name:"jobCode",type:"string" }, 		
		{name:"organizationId",type:"int", useNull:true }, 		
		{name:"organizationCode",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.PositionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 