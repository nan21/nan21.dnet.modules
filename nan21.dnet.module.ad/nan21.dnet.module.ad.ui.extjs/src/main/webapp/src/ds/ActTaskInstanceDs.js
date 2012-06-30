/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"string"},
		{name:"processId", type:"string"},
		{name:"process", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"taskKey", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"executionId", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"assignee", type:"string"},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"duration", type:"int", useNull:true},
		{name:"durationText", type:"string"},
		{name:"priority", type:"int", useNull:true},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"string"},
		{name:"processId", type:"string"},
		{name:"process", type:"string"},
		{name:"taskKey", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"executionId", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"assignee", type:"string"},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startTime_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startTime_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endTime_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endTime_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"duration", type:"int", useNull:true},
		{name:"duration_From",type:"int", useNull:true},
		{name:"duration_To",type:"int", useNull:true},
		{name:"durationText", type:"string"},
		{name:"priority", type:"int", useNull:true},
		{name:"priority_From",type:"int", useNull:true},
		{name:"priority_To",type:"int", useNull:true},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"hideActive", type:"boolean"},
		{name:"hideCompleted", type:"boolean"}
	]
}); 
 