 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemTaskDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"summary",type:"string" },
		{name:"description",type:"string" },
		{name:"itemId",type:"int", useNull:true },
		{name:"item",type:"string" },
		{name:"priorityId",type:"int", useNull:true },
		{name:"priority",type:"string" },
		{name:"prioritySequenceNo",type:"int", useNull:true },
		{name:"itemBusinessObject",type:"string" },
		{name:"itemClassName",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"status",type:"string" },
		{name:"assigneeId",type:"int", useNull:true },
		{name:"assignee",type:"string" }
	],
	validations: [  
		{field: "summary", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemTaskDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"summary",type:"string" },
		{name:"description",type:"string" },
		{name:"itemId",type:"int", useNull:true },
		{name:"item",type:"string" },
		{name:"priorityId",type:"int", useNull:true },
		{name:"priority",type:"string" },
		{name:"prioritySequenceNo",type:"int", useNull:true },
		{name:"itemBusinessObject",type:"string" },
		{name:"itemClassName",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"status",type:"string" },
		{name:"assigneeId",type:"int", useNull:true },
		{name:"assignee",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ItemTaskDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 