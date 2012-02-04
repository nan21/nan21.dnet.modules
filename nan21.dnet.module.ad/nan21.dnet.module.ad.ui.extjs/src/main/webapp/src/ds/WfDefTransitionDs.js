 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"processId", type:"int", useNull:true},
		{name:"process", type:"string"},
		{name:"sourceId", type:"int", useNull:true},
		{name:"source", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"target", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
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
		{name:"processId", type:"int", useNull:true},
		{name:"processId_From",type:"int", useNull:true},
		{name:"processId_To",type:"int", useNull:true},
		{name:"process", type:"string"},
		{name:"sourceId", type:"int", useNull:true},
		{name:"sourceId_From",type:"int", useNull:true},
		{name:"sourceId_To",type:"int", useNull:true},
		{name:"source", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetId_From",type:"int", useNull:true},
		{name:"targetId_To",type:"int", useNull:true},
		{name:"target", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.WfDefTransitionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 