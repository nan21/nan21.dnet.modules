 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"code",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.JobLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 