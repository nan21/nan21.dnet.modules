/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs" ,{
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
		{name:"owner", type:"string"},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"priority", type:"int", useNull:true},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDsFilter" ,{
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
		{name:"owner", type:"string"},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startTime_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startTime_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"priority", type:"int", useNull:true},
		{name:"priority_From",type:"int", useNull:true},
		{name:"priority_To",type:"int", useNull:true},
		{name:"dueDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dueDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActMyTaskDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 