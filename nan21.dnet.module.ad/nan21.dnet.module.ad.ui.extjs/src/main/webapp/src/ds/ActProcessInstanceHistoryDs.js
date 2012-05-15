/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"processId", type:"string"},
		{name:"process", type:"string"},
		{name:"processVersion", type:"int", useNull:true},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"duration", type:"int", useNull:true},
		{name:"startedBy", type:"string"},
		{name:"startAction", type:"string"},
		{name:"endAction", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"processId", type:"string"},
		{name:"process", type:"string"},
		{name:"processVersion", type:"int", useNull:true},
		{name:"processVersion_From",type:"int", useNull:true},
		{name:"processVersion_To",type:"int", useNull:true},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startTime_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startTime_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endTime_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endTime_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"duration", type:"int", useNull:true},
		{name:"duration_From",type:"int", useNull:true},
		{name:"duration_To",type:"int", useNull:true},
		{name:"startedBy", type:"string"},
		{name:"startAction", type:"string"},
		{name:"endAction", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceHistoryDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"processFullName", type:"string"}
	]
}); 
 