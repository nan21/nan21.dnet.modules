/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsFieldLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"dataSourceId", type:"int", useNull:true},
		{name:"dataSourceName", type:"string"},
		{name:"dataType", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsFieldLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"dataSourceId", type:"int", useNull:true},
		{name:"dataSourceId_From",type:"int", useNull:true},
		{name:"dataSourceId_To",type:"int", useNull:true},
		{name:"dataSourceName", type:"string"},
		{name:"dataType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDsFieldLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 