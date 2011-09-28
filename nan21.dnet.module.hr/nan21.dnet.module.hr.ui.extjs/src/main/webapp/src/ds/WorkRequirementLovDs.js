 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.WorkRequirementLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.WorkRequirementLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 