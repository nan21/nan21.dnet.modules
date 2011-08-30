 
   	 
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.model");
	net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarCallDs = [
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
	,	{name:"contactId",type:"int"}
	,	{name:"contact",type:"string"}
	,	{name:"createdBy",type:"string"}
	,	{name:"notes",type:"string"}
	,	{name:"location",type:"string"}
	,	{name:"url",type:"string"}
	,	{name:"reminder",type:"string"}
	,	{name:"allDay",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds.param");	
	net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarCallDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.calendar.ds");	
	net.nan21.dnet.module.bp.calendar.ds.MyCalendarCallDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"MyCalendarCallDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarCallDs
				,paramFields: net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarCallDsParam				 
			});
		 	net.nan21.dnet.module.bp.calendar.ds.MyCalendarCallDs.superclass.constructor.call(this, config);
		}	 
	});  
 