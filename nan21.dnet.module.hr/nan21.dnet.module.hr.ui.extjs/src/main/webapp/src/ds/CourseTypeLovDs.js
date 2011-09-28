 
   	 
Ext.define("net.nan21.dnet.module.hr.training.ds.model.CourseTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.training.ds.param.CourseTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 