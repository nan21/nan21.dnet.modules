 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.WorkRequirementTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.WorkRequirementTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 