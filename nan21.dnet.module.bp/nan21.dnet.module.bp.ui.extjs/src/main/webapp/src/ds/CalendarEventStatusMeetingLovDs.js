 
   	 
Ext.define("net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusMeetingLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }, 		
		{name:"eventType",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventStatusMeetingLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 