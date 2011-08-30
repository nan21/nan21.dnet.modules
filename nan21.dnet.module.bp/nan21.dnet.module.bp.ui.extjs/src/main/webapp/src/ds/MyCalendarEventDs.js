 
   	 
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.model");
	net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarEventDs = [
	{name:"subject",type:"string"}
	,	{name:"startDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"eventType",type:"string"}
	,	{name:"statusId",type:"int"}
	,	{name:"statusName",type:"string"}
	,	{name:"priorityId",type:"int"}
	,	{name:"priorityName",type:"string"}
	,	{name:"bpartnerId",type:"int"}
	,	{name:"bpartnerCode",type:"string"}
	,	{name:"createdBy",type:"string"}
	,	{name:"notes",type:"string"}
	,	{name:"location",type:"string"}
	,	{name:"url",type:"string"}
	,	{name:"reminder",type:"string"}
	,	{name:"allDay",type:"boolean"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.param");	
	net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarEventDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds");	
	net.nan21.dnet.module.bp.calendar.ds.MyCalendarEventDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"MyCalendarEventDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarEventDs
				,paramFields: net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarEventDsParam				 
			});
		 	net.nan21.dnet.module.bp.calendar.ds.MyCalendarEventDs.superclass.constructor.call(this, config);
		}	 
	});  
 