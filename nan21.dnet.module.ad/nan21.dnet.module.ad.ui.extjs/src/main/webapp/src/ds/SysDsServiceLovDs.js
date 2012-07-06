/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsServiceLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"dataSourceId", type:"int", useNull:true},
		{name:"dataSourceName", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDsServiceLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"dataSourceId", type:"int", useNull:true},
		{name:"dataSourceId_From",type:"int", useNull:true},
		{name:"dataSourceId_To",type:"int", useNull:true},
		{name:"dataSourceName", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDsServiceLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 