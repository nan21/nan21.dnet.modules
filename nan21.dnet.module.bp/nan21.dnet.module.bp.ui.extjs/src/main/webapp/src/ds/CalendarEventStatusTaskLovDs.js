 
   	 
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.model");
	net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusTaskLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"eventType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.param");	
	net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventStatusTaskLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds");	
	net.nan21.dnet.module.bp.calendar.ds.CalendarEventStatusTaskLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CalendarEventStatusTaskLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusTaskLovDs
				,paramFields: net.nan21.dnet.module.bp.calendar.ds.param.CalendarEventStatusTaskLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.calendar.ds.CalendarEventStatusTaskLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 