 
   	 
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.model");
	net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityCallLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"eventType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.param");	
	net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventPriorityCallLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds");	
	net.nan21.dnet.module.bp.calendar.ds.CalendarEventPriorityCallLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CalendarEventPriorityCallLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityCallLovDs
				,paramFields: net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventPriorityCallLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.calendar.ds.CalendarEventPriorityCallLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 