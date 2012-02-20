 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.UiViewStateDs" ,{
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
		{name:"name", type:"string"},
		{name:"cmp", type:"string"},
		{name:"cmpType", type:"string"},
		{name:"stateValue", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.UiViewStateDsFilter" ,{
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
		{name:"name", type:"string"},
		{name:"cmp", type:"string"},
		{name:"cmpType", type:"string"},
		{name:"stateValue", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.UiViewStateDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 