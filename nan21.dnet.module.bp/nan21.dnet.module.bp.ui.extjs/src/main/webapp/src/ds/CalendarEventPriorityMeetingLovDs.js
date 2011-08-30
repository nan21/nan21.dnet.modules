 
   	 
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.model");
	net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityMeetingLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"eventType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.param");	
	net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventPriorityMeetingLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds");	
	net.nan21.dnet.module.bp.calendar.ds.CalendarEventPriorityMeetingLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CalendarEventPriorityMeetingLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityMeetingLovDs
				,paramFields: net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventPriorityMeetingLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.calendar.ds.CalendarEventPriorityMeetingLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 