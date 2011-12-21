 
   	 
Ext.define("net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarTaskDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"subject",type:"string" },
		{name:"startDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"endDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"dueDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"eventType",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"statusName",type:"string" },
		{name:"priorityId",type:"int", useNull:true },
		{name:"priorityName",type:"string" },
		{name:"bpartnerId",type:"int", useNull:true },
		{name:"bpartnerCode",type:"string" },
		{name:"contactId",type:"int", useNull:true },
		{name:"contactName",type:"string" },
		{name:"createdBy",type:"string" },
		{name:"notes",type:"string" },
		{name:"location",type:"string" },
		{name:"url",type:"string" },
		{name:"reminder",type:"string" },
		{name:"allDay",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarTaskDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"subject",type:"string" },
		{name:"startDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"endDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"dueDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"eventType",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"statusName",type:"string" },
		{name:"priorityId",type:"int", useNull:true },
		{name:"priorityName",type:"string" },
		{name:"bpartnerId",type:"int", useNull:true },
		{name:"bpartnerCode",type:"string" },
		{name:"contactId",type:"int", useNull:true },
		{name:"contactName",type:"string" },
		{name:"createdBy",type:"string" },
		{name:"notes",type:"string" },
		{name:"location",type:"string" },
		{name:"url",type:"string" },
		{name:"reminder",type:"string" },
		{name:"allDay",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarTaskDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 