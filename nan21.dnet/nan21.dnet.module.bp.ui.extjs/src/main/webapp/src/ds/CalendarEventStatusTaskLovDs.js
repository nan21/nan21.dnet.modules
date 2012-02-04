 
   	 
Ext.define("net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusTaskLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"eventType", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusTaskLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"eventType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventStatusTaskLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 