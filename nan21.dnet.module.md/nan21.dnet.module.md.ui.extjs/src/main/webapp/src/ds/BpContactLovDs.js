/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpContactLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpContactLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerId_From",type:"int", useNull:true},
		{name:"bpartnerId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.BpContactLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 