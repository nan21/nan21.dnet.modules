 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"processId",type:"int", useNull:true }, 		
		{name:"process",type:"string" }, 		
		{name:"sourceId",type:"int", useNull:true }, 		
		{name:"source",type:"string" }, 		
		{name:"targetId",type:"int", useNull:true }, 		
		{name:"target",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.WfDefTransitionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 