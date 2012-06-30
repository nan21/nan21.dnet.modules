/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActVariableDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"type", type:"string"},
		{name:"name", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"executionId", type:"string"},
		{name:"doubleValue", type:"float", useNull:true},
		{name:"longValue", type:"int", useNull:true},
		{name:"textValue", type:"string"},
		{name:"textValue2", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActVariableDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"type", type:"string"},
		{name:"name", type:"string"},
		{name:"processInstanceId", type:"string"},
		{name:"executionId", type:"string"},
		{name:"doubleValue", type:"float", useNull:true},
		{name:"doubleValue_From",type:"float", useNull:true},
		{name:"doubleValue_To",type:"float", useNull:true},
		{name:"longValue", type:"int", useNull:true},
		{name:"longValue_From",type:"int", useNull:true},
		{name:"longValue_To",type:"int", useNull:true},
		{name:"textValue", type:"string"},
		{name:"textValue2", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActVariableDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 