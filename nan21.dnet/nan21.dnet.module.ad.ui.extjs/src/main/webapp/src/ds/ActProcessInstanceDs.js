 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"processId", type:"string"},
		{name:"process", type:"string"},
		{name:"processVersion", type:"int", useNull:true},
		{name:"startTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startedBy", type:"string"},
		{name:"startAction", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDsFilter" ,{
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
		{name:"startedBy", type:"string"},
		{name:"startAction", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"processFullName", type:"string"},
		{name:"reasonToKill", type:"string"},
		{name:"from", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"to", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
}); 
 