 
   	 
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.model");
	net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusCallLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"eventType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.param");	
	net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventStatusCallLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds");	
	net.nan21.dnet.module.bp.calendar.ds.CalendarEventStatusCallLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CalendarEventStatusCallLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusCallLovDs
				,paramFields: net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventStatusCallLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.calendar.ds.CalendarEventStatusCallLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 