/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.activity.ds.model.CalendarEventPriorityTaskLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"eventType", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.activity.ds.model.CalendarEventPriorityTaskLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"eventType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.activity.ds.param.CalendarEventPriorityTaskLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 