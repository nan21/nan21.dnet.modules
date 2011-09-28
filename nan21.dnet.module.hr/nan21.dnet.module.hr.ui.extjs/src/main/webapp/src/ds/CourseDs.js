 
   	 
Ext.define("net.nan21.dnet.module.hr.training.ds.model.CourseDs" , {
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
		{name:"typeId",type:"int", useNull:true }, 		
		{name:"type",type:"string" }, 		
		{name:"intendedAudience",type:"string" }, 		
		{name:"deliveredCompetences",type:"string" }, 		
		{name:"requirements",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.training.ds.param.CourseDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 