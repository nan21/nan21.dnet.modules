 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs" , {
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
		{name:"assignee",type:"string" },
		{name:"startTime",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"endTime",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"duration",type:"int", useNull:true },
		{name:"priority",type:"int", useNull:true },
		{name:"dueDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT }
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDsFilter" , {
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
		{name:"assignee",type:"string" },
		{name:"startTime",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"endTime",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"duration",type:"int", useNull:true },
		{name:"priority",type:"int", useNull:true },
		{name:"dueDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 	
		{name:"hideActive",type:"boolean"},	
		{name:"hideCompleted",type:"boolean"}
	]
}); 
 