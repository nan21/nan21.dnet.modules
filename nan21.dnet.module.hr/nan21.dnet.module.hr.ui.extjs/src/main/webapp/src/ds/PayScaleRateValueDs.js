 
   	 
Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"scaleRateId",type:"int", useNull:true }, 		
		{name:"scalePointId",type:"int", useNull:true }, 		
		{name:"scalePointCode",type:"string" }, 		
		{name:"value",type:"float", useNull:true }, 		
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 