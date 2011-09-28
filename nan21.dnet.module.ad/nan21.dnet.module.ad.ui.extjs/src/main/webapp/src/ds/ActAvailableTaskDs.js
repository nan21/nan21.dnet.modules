 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActAvailableTaskDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"string" }, 		
		{name:"processId",type:"string" }, 		
		{name:"process",type:"string" }, 		
		{name:"taskKey",type:"string" }, 		
		{name:"processInstanceId",type:"string" }, 		
		{name:"executionId",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"description",type:"string" }, 		
		{name:"owner",type:"string" }, 		
		{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"priority",type:"int", useNull:true }, 		
		{name:"dueDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActAvailableTaskDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 