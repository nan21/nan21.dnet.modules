 
   	 
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.model");
	net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityTaskLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"eventType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.param");	
	net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventPriorityTaskLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds");	
	net.nan21.dnet.module.bp.calendar.ds.CalendarEventPriorityTaskLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CalendarEventPriorityTaskLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityTaskLovDs
				,paramFields: net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventPriorityTaskLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.calendar.ds.CalendarEventPriorityTaskLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 