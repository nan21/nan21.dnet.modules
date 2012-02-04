 
   	 
Ext.define("net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarMeetingDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"subject", type:"string"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventType", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"statusName", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"priorityName", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerCode", type:"string"},
		{name:"createdBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"location", type:"string"},
		{name:"url", type:"string"},
		{name:"eminder", type:"string"},
		{name:"allDay", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarMeetingDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"subject", type:"string"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventType", type:"string"},
		{name:"statusId", type:"int", useNull:true},
		{name:"statusId_From",type:"int", useNull:true},
		{name:"statusId_To",type:"int", useNull:true},
		{name:"statusName", type:"string"},
		{name:"priorityId", type:"int", useNull:true},
		{name:"priorityId_From",type:"int", useNull:true},
		{name:"priorityId_To",type:"int", useNull:true},
		{name:"priorityName", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerId_From",type:"int", useNull:true},
		{name:"bpartnerId_To",type:"int", useNull:true},
		{name:"bpartnerCode", type:"string"},
		{name:"createdBy", type:"string"},
		{name:"notes", type:"string"},
		{name:"location", type:"string"},
		{name:"url", type:"string"},
		{name:"eminder", type:"string"},
		{name:"allDay", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarMeetingDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 