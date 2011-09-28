 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"string" }, 		
		{name:"key",type:"string" }, 		
		{name:"fullName",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"category",type:"string" }, 		
		{name:"resourceName",type:"string" }, 		
		{name:"diagramResourceName",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"deploymentId",type:"string" }, 		
		{name:"hasStartForm",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 	
		{name:"deployment",type:"string"}
	]
}); 
 