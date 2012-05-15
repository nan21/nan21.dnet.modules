/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.UiViewStateRTLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"cmp", type:"string"},
		{name:"cmpType", type:"string"},
		{name:"stateValue", type:"string"},
		{name:"owner", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.UiViewStateRTLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"cmp", type:"string"},
		{name:"cmpType", type:"string"},
		{name:"stateValue", type:"string"},
		{name:"owner", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.UiViewStateRTLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"hideMine", type:"boolean"},
		{name:"hideOthers", type:"boolean"}
	]
}); 
 