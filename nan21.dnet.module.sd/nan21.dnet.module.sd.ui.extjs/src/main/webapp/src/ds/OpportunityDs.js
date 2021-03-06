/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"accountId", type:"int", useNull:true},
		{name:"account", type:"string"},
		{name:"closeDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"probability", type:"float", useNull:true},
		{name:"amount", type:"float", useNull:true},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"status", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"priority", type:"string"},
		{name:"salesStageId", type:"int", useNull:true},
		{name:"salesStage", type:"string"},
		{name:"leadSourceId", type:"int", useNull:true},
		{name:"leadSource", type:"string"},
		{name:"campaign", type:"string"},
		{name:"resultReasonId", type:"int", useNull:true},
		{name:"resultReason", type:"string"},
		{name:"resultNote", type:"string"},
		{name:"assignedToId", type:"int", useNull:true},
		{name:"assignedTo", type:"string"},
		{name:"className", type:"string"},
		{name:"businessObject", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"accountId", type:"int", useNull:true},
		{name:"accountId_From",type:"int", useNull:true},
		{name:"accountId_To",type:"int", useNull:true},
		{name:"account", type:"string"},
		{name:"closeDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"closeDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"closeDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"probability", type:"float", useNull:true},
		{name:"probability_From",type:"float", useNull:true},
		{name:"probability_To",type:"float", useNull:true},
		{name:"amount", type:"float", useNull:true},
		{name:"amount_From",type:"float", useNull:true},
		{name:"amount_To",type:"float", useNull:true},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"statusId_From",type:"int", useNull:true},
		{name:"statusId_To",type:"int", useNull:true},
		{name:"status", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"priorityId_From",type:"int", useNull:true},
		{name:"priorityId_To",type:"int", useNull:true},
		{name:"priority", type:"string"},
		{name:"salesStageId", type:"int", useNull:true},
		{name:"salesStageId_From",type:"int", useNull:true},
		{name:"salesStageId_To",type:"int", useNull:true},
		{name:"salesStage", type:"string"},
		{name:"leadSourceId", type:"int", useNull:true},
		{name:"leadSourceId_From",type:"int", useNull:true},
		{name:"leadSourceId_To",type:"int", useNull:true},
		{name:"leadSource", type:"string"},
		{name:"campaign", type:"string"},
		{name:"resultReasonId", type:"int", useNull:true},
		{name:"resultReasonId_From",type:"int", useNull:true},
		{name:"resultReasonId_To",type:"int", useNull:true},
		{name:"resultReason", type:"string"},
		{name:"resultNote", type:"string"},
		{name:"assignedToId", type:"int", useNull:true},
		{name:"assignedToId_From",type:"int", useNull:true},
		{name:"assignedToId_To",type:"int", useNull:true},
		{name:"assignedTo", type:"string"},
		{name:"className", type:"string"},
		{name:"businessObject", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.opportunity.ds.param.OpportunityDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 