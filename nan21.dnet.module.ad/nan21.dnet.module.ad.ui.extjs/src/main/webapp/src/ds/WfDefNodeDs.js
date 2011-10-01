 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"assignToUser",type:"string" },
		{name:"assignToGroup",type:"string" },
		{name:"startWithPrevious",type:"boolean" },
		{name:"taskType",type:"string" },
		{name:"processId",type:"int", useNull:true },
		{name:"process",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "taskType", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 