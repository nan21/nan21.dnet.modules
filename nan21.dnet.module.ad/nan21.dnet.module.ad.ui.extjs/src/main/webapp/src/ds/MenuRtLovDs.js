/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MenuRtLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"title", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MenuRtLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"title", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.MenuRtLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 