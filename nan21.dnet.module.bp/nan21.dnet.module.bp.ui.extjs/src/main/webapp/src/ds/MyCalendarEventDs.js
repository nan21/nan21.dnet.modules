 
   	 
Ext.define("net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarEventDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"subject",type:"string" },
		{name:"startDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"endDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"eventType",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"statusName",type:"string" },
		{name:"priorityId",type:"int", useNull:true },
		{name:"priorityName",type:"string" },
		{name:"bpartnerId",type:"int", useNull:true },
		{name:"bpartnerCode",type:"string" },
		{name:"createdBy",type:"string" },
		{name:"notes",type:"string" },
		{name:"location",type:"string" },
		{name:"url",type:"string" },
		{name:"reminder",type:"string" },
		{name:"allDay",type:"boolean" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true }
	],
	validations: [  
		{field: "subject", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarEventDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 