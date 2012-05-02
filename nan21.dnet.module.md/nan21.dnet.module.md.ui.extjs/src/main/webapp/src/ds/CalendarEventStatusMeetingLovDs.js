 
   	 
Ext.define("net.nan21.dnet.module.md.activity.ds.model.CalendarEventStatusMeetingLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"eventType", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.activity.ds.model.CalendarEventStatusMeetingLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"eventType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.activity.ds.param.CalendarEventStatusMeetingLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 