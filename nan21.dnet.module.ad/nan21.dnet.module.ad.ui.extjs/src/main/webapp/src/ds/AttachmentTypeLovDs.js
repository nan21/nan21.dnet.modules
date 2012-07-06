/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"useInContext", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"useInContext", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.data.ds.param.AttachmentTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 