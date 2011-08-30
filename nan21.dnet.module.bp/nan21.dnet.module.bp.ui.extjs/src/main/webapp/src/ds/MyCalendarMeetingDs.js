 
   	 
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.model");
	net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarMeetingDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"subject",type:"string"}
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
	,	{name:"eminder",type:"string"}
	,	{name:"allDay",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.param");	
	net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarMeetingDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds");	
	net.nan21.dnet.module.bp.calendar.ds.MyCalendarMeetingDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"MyCalendarMeetingDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarMeetingDs
				,paramFields: net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarMeetingDsParam				 
			});
		 	net.nan21.dnet.module.bp.calendar.ds.MyCalendarMeetingDs.superclass.constructor.call(this, config);
		}	 
	});  
 