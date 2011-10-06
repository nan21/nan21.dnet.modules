Dnet.doImport(["", "nan21.dnet.module.bp.ui.extjs/ds/MyCalendarCallDs", "nan21.dnet.module.bp.ui.extjs/dc/Call", "nan21.dnet.module.bp.ui.extjs/ds/MyCalendarMeetingDs", "nan21.dnet.module.bp.ui.extjs/dc/Meeting", "nan21.dnet.module.bp.ui.extjs/ds/MyCalendarTaskDs", "nan21.dnet.module.bp.ui.extjs/dc/Task","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusCallLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusCall","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityCallLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesCall","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.bp.ui.extjs/lov/BpContacts","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusMeetingLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusMeeting","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityMeetingLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesMeeting","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusTaskLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusTask","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityTaskLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesTask","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusCallLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusCall","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityCallLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesCall","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.bp.ui.extjs/lov/BpContacts","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusMeetingLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusMeeting","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityMeetingLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesMeeting","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusTaskLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusTask","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityTaskLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesTask","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners"]);

Ext.define("net.nan21.dnet.module.bp.calendar.frame.MyCalendarEvent_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bp.calendar.frame.MyCalendarEvent_UI",
	
	 _name_ : "net.nan21.dnet.module.bp.calendar.frame.MyCalendarEvent_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("callEvnt", new net.nan21.dnet.module.bp.calendar.dc.Call({}))
		.addDc("meetingEvnt", new net.nan21.dnet.module.bp.calendar.dc.Meeting({}))
		.addDc("taskEvnt", new net.nan21.dnet.module.bp.calendar.dc.Task({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("callEvnt",{ name:"callEvntFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.Call$Filter",height:80})	 
		.addDcView("callEvnt",{ name:"callEvntList", xtype:"net.nan21.dnet.module.bp.calendar.dc.Call$List"})	 
		.addDcFormView("callEvnt",{ name:"callEvntEdit", xtype:"net.nan21.dnet.module.bp.calendar.dc.Call$Edit",height:200})	 
		.addDcFilterFormView("meetingEvnt",{ name:"meetingEvntFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.Meeting$Filter",height:80})	 
		.addDcView("meetingEvnt",{ name:"meetingEvntList", xtype:"net.nan21.dnet.module.bp.calendar.dc.Meeting$List"})	 
		.addDcFormView("meetingEvnt",{ name:"meetingEvntEdit", xtype:"net.nan21.dnet.module.bp.calendar.dc.Meeting$Edit",height:200})	 
		.addDcFilterFormView("taskEvnt",{ name:"taskEvntFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.Task$Filter",height:80})	 
		.addDcView("taskEvnt",{ name:"taskEvntList", xtype:"net.nan21.dnet.module.bp.calendar.dc.Task$List"})	 
		.addDcFormView("taskEvnt",{ name:"taskEvntEdit", xtype:"net.nan21.dnet.module.bp.calendar.dc.Task$Edit",height:200})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCall", layout:"border", defaults:{split:true},title:"Calls",preventHeader:true})  	 
		.addPanel({name: "canvasMeeting", layout:"border", defaults:{split:true},title:"Meetings",preventHeader:true})  	 
		.addPanel({name: "canvasTask", layout:"border", defaults:{split:true},title:"Tasks",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasCall","canvasMeeting","canvasTask"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCall","canvasMeeting","canvasTask"]) 				 		
		.addChildrenTo("canvasCall",["callEvntFilter","callEvntList","callEvntEdit"] ,["north","center","south"])	
		.addChildrenTo("canvasMeeting",["meetingEvntFilter","meetingEvntList","meetingEvntEdit"] ,["north","center","south"])	
		.addChildrenTo("canvasTask",["taskEvntFilter","taskEvntList","taskEvntEdit"] ,["north","center","south"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCall","callEvntListTlb")	  	
	 	.addToolbarTo("callEvntEdit","callEvntEditTlb")	  	
	 	.addToolbarTo("canvasMeeting","meetingEvntListTlb")	  	
	 	.addToolbarTo("meetingEvntEdit","meetingEvntEditTlb")	  	
	 	.addToolbarTo("canvasTask","taskEvntListTlb")	  	
	 	.addToolbarTo("taskEvntEdit","taskEvntEditTlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("callEvntListTlb", {dc:"callEvnt"}).addQuery().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Calls"}).end()
			.beginToolbar("callEvntEditTlb", {dc:"callEvnt"}).addSave().addNew().addCopy().addCancel().end()
			.beginToolbar("meetingEvntListTlb", {dc:"meetingEvnt"}).addQuery().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Meetings"}).end()
			.beginToolbar("meetingEvntEditTlb", {dc:"meetingEvnt"}).addSave().addNew().addCopy().addCancel().end()
			.beginToolbar("taskEvntListTlb", {dc:"taskEvnt"}).addQuery().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Tasks"}).end()
			.beginToolbar("taskEvntEditTlb", {dc:"taskEvnt"}).addSave().addNew().addCopy().addCancel().end(); 	
	}

});  
