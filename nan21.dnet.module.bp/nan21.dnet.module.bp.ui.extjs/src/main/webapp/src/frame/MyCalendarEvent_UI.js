Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/MyCalendarCallDs", "nan21.dnet.module.bp.ui.extjs/dc/Call", "nan21.dnet.module.bp.ui.extjs/ds/MyCalendarMeetingDs", "nan21.dnet.module.bp.ui.extjs/dc/Meeting", "nan21.dnet.module.bp.ui.extjs/ds/MyCalendarTaskDs", "nan21.dnet.module.bp.ui.extjs/dc/Task","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusCallLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusCall","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityCallLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesCall","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/ContactLovDs","nan21.dnet.module.bp.ui.extjs/lov/Contacts","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusMeetingLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusMeeting","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityMeetingLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesMeeting","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusTaskLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusTask","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityTaskLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesTask","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusCallLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusCall","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityCallLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesCall","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/ContactLovDs","nan21.dnet.module.bp.ui.extjs/lov/Contacts","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusMeetingLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusMeeting","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityMeetingLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesMeeting","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusTaskLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventStatusTask","nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityTaskLovDs","nan21.dnet.module.bp.ui.extjs/lov/CalendarEventPrioritiesTask","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners"]);

Ext.ns("net.nan21.dnet.module.bp.calendar.frame");
net.nan21.dnet.module.bp.calendar.frame.MyCalendarEvent_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.calendar.frame.MyCalendarEvent_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("callEvnt", new net.nan21.dnet.module.bp.calendar.dc.Call())
		.addDc("meetingEvnt", new net.nan21.dnet.module.bp.calendar.dc.Meeting())
		.addDc("taskEvnt", new net.nan21.dnet.module.bp.calendar.dc.Task())		;		
	}	 

	,_defineElements_: function() {					
			
		this._mainViewName_  = "_main_with_toc_";
		this._getBuilder_()
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addPanel({ name:"_toc_",xtype: 'treepanel',collapsible: true, region:"west", title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
			,minWidth:150, maxWidth:500
			,root: new Ext.tree.AsyncTreeNode({expanded: true,
            children: [{ text:"Calls", leaf: true , name:"canvas1"},{ text:"Meetings", leaf: true , name:"canvas2"},{ text:"Tasks", leaf: true , name:"canvas3"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addDcFilterFormView("callEvnt",{ name:"callEvntFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.Call$Filter",height:70})	 
		.addDcView("callEvnt",{ name:"callEvntList", xtype:"net.nan21.dnet.module.bp.calendar.dc.Call$List"})	 
		.addDcFormView("callEvnt",{ name:"callEvntEdit", xtype:"net.nan21.dnet.module.bp.calendar.dc.Call$Edit",height:200})	 
		.addDcFilterFormView("meetingEvnt",{ name:"meetingEvntFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.Meeting$Filter",height:70})	 
		.addDcView("meetingEvnt",{ name:"meetingEvntList", xtype:"net.nan21.dnet.module.bp.calendar.dc.Meeting$List"})	 
		.addDcFormView("meetingEvnt",{ name:"meetingEvntEdit", xtype:"net.nan21.dnet.module.bp.calendar.dc.Meeting$Edit",height:200})	 
		.addDcFilterFormView("taskEvnt",{ name:"taskEvntFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.Task$Filter",height:70})	 
		.addDcView("taskEvnt",{ name:"taskEvntList", xtype:"net.nan21.dnet.module.bp.calendar.dc.Task$List"})	 
		.addDcFormView("taskEvnt",{ name:"taskEvntEdit", xtype:"net.nan21.dnet.module.bp.calendar.dc.Task$Edit",height:200})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Calls",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Meetings",header:false})  	 
		.addPanel({name: "canvas3", layout:"border", defaults:{split:true},title:"Tasks",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2","canvas3"]) 				 		
		.addChildrenTo("canvas1",["callEvntFilter","callEvntList","callEvntEdit"] ,["north","center","south"])	
		.addChildrenTo("canvas2",["meetingEvntFilter","meetingEvntList","meetingEvntEdit"] ,["north","center","south"])	
		.addChildrenTo("canvas3",["taskEvntFilter","taskEvntList","taskEvntEdit"] ,["north","center","south"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","callEvntListTlb")	  	
	 	.addToolbarTo("callEvntEdit","callEvntEditTlb")	  	
	 	.addToolbarTo("canvas2","meetingEvntListTlb")	  	
	 	.addToolbarTo("meetingEvntEdit","meetingEvntEditTlb")	  	
	 	.addToolbarTo("canvas3","taskEvntListTlb")	  	
	 	.addToolbarTo("taskEvntEdit","taskEvntEditTlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("callEvntListTlb", {dc:"callEvnt"}).addQuery().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("callEvntEditTlb", {dc:"callEvnt"}).addSave().addNew().addCopy().addCancel().end()
			.beginToolbar("meetingEvntListTlb", {dc:"meetingEvnt"}).addQuery().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("meetingEvntEditTlb", {dc:"meetingEvnt"}).addSave().addNew().addCopy().addCancel().end()
			.beginToolbar("taskEvntListTlb", {dc:"taskEvnt"}).addQuery().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("taskEvntEditTlb", {dc:"taskEvnt"}).addSave().addNew().addCopy().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.bp.calendar.frame.MyCalendarEvent_UI", net.nan21.dnet.module.bp.calendar.frame.MyCalendarEvent_UI);   
