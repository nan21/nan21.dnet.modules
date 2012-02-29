   

Ext.define("net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarEventDs",
	filterModel: "net.nan21.dnet.module.bp.calendar.ds.model.MyCalendarEventDsFilter",
	paramModel: "net.nan21.dnet.module.bp.calendar.ds.param.MyCalendarEventDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20",maxLength:255  })
		.addDateField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addDateField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addTextField({ name:"eventType", dataIndex:"eventType",anchor:"-20",maxLength:16  })
		.addNumberField({ name:"statusId",_sharedLabel_:true, dataIndex:"statusId",anchor:"-20"  })
		.addTextField({ name:"statusName",_sharedLabel_:true, dataIndex:"statusName",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"priorityId", dataIndex:"priorityId",anchor:"-20"  })
		.addTextField({ name:"priorityName", dataIndex:"priorityName",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"bpartnerId",_sharedLabel_:true, dataIndex:"bpartnerId",anchor:"-20"  })
		.addTextField({ name:"bpartnerCode",_sharedLabel_:true, dataIndex:"bpartnerCode",anchor:"-20",maxLength:32  })
		.addTextField({ name:"createdBy",_sharedLabel_:true, dataIndex:"createdBy",anchor:"-20",maxLength:32  })
		.addTextField({ name:"notes",_sharedLabel_:true, dataIndex:"notes",anchor:"-20",maxLength:4000  })
		.addTextField({ name:"location", dataIndex:"location",anchor:"-20",maxLength:4000  })
		.addTextField({ name:"url", dataIndex:"url",anchor:"-20",maxLength:400  })
		.addTextField({ name:"reminder", dataIndex:"reminder",anchor:"-20",maxLength:32  })
		.addBooleanField({ name:"allDay", dataIndex:"allDay",anchor:"-20"  })
		.addNumberField({ name:"id",_sharedLabel_:true, dataIndex:"id",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["subject","eventType","statusName","priorityName","bpartnerCode","createdBy","notes","location","url","reminder"])
		.addChildrenTo("col2",["subject","eventType","statusName","priorityName","bpartnerCode","createdBy","notes","location","url","reminder"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"eventType", dataIndex:"eventType",width:100 })   	
		.addTextColumn({ name:"subject", dataIndex:"subject",width:200 })   	
		.addDateColumn({ name:"startDate", dataIndex:"startDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addDateColumn({ name:"endDate", dataIndex:"endDate",format:Dnet.DATETIME_FORMAT})   	      	     
		.addTextColumn({ name:"statusName", dataIndex:"statusName",width:120 })   	
		.addTextColumn({ name:"priorityName", dataIndex:"priorityName",width:120 })   	
		.addTextColumn({ name:"reminder", dataIndex:"reminder",width:100 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$Create", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$Create",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCombo({ name:"eventType", xtype:"localcombo", dataIndex:"eventType",anchor:"-20" ,store:[ "call", "meeting", "task"]  })
		//containers
		.addPanel({ name:"main", layout:"form" , autoScroll:true, width:250})     
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["eventType"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$EditCall", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$EditCall",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:80,anchor:"-20"   })
		.addDateTimeField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,allowBlank:false})
		.addDateTimeField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,allowBlank:false})
		.addDateField({ name:"dueDate", dataIndex:"dueDate",anchor:"-20" })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusCall", dataIndex:"statusName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesCall", dataIndex:"priorityName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"contact", xtype:"net.nan21.dnet.module.bp.md.lovs.BpContacts", dataIndex:"contact",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "contactId"} ],filterFieldMapping: [{lovField:"bpartnerId", dsField: "bpartnerId"} ]  })
		//containers
		.addPanel({ name:"row1", layout:"form" , width:700})     
		.addPanel({ name:"col1", layout:"form" , width:280})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"row3", layout:"form" , width:700})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["row1" ,"row2" ,"row3" ])
		.addChildrenTo("row1",["subject"])
		.addChildrenTo("row2",["col1" ,"col2" ])
		.addChildrenTo("col1",["startDate","endDate","dueDate"])
		.addChildrenTo("col2",["statusName","priorityName","contact"])
		.addChildrenTo("row3",["notes"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$EditMeeting", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$EditMeeting",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:80,anchor:"-20"   })
		.addTextField({ name:"location", dataIndex:"location",anchor:"-20" ,maxLength:4000  })
		.addDateTimeField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,allowBlank:false})
		.addDateTimeField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,allowBlank:false})
		.addDateField({ name:"dueDate", dataIndex:"dueDate",anchor:"-20" })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting", dataIndex:"statusName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addNumberField({ name:"priorityId", dataIndex:"priorityId",anchor:"-20",noEdit:true   , style: "text-align:right;" })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesMeeting", dataIndex:"priorityName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		.addLov({ name:"contact", xtype:"net.nan21.dnet.module.bp.md.lovs.BpContacts", dataIndex:"contact",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "contactId"} ],filterFieldMapping: [{lovField:"bpartnerId", dsField: "bpartnerId"} ]  })
		//containers
		.addPanel({ name:"row1", layout:"form" , width:700})     
		.addPanel({ name:"col1", layout:"form" , width:280})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" ,width:250, defaults:{
labelAlign:"top"}})     
		.addPanel({ name:"row3", layout:"form" , width:700})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["row1" ,"row2" ,"row3" ])
		.addChildrenTo("row1",["subject"])
		.addChildrenTo("row2",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["startDate","endDate","dueDate"])
		.addChildrenTo("col2",["statusName","priorityName","contact"])
		.addChildrenTo("col3",["location"])
		.addChildrenTo("row3",["notes"])
;
	}	
});
 	

Ext.define("net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$EditTask", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.bp.calendar.dc.MyCalendarEvent$EditTask",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"subject", dataIndex:"subject",anchor:"-20" ,allowBlank:false,maxLength:255  })
		.addTextArea({ name:"notes", dataIndex:"notes",height:80,anchor:"-20"   })
		.addDateTimeField({ name:"startDate", dataIndex:"startDate",anchor:"-20" ,allowBlank:false})
		.addDateTimeField({ name:"endDate", dataIndex:"endDate",anchor:"-20" ,allowBlank:false})
		.addDateField({ name:"dueDate", dataIndex:"dueDate",anchor:"-20" })
		.addLov({ name:"statusName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusTask", dataIndex:"statusName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "statusId"} ]  })
		.addLov({ name:"priorityName", xtype:"net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesTask", dataIndex:"priorityName",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priorityId"} ]  })
		//containers
		.addPanel({ name:"row1", layout:"form" , width:700})     
		.addPanel({ name:"col1", layout:"form" , width:280})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"row3", layout:"form" , width:700})     
		.addPanel({ name:"main" , autoScroll:true })      	 
		.addPanel({ name:"row2",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["row1" ,"row2" ,"row3" ])
		.addChildrenTo("row1",["subject"])
		.addChildrenTo("row2",["col1" ,"col2" ])
		.addChildrenTo("col1",["startDate","endDate","dueDate"])
		.addChildrenTo("col2",["statusName","priorityName"])
		.addChildrenTo("row3",["notes"])
;
	}	
});
