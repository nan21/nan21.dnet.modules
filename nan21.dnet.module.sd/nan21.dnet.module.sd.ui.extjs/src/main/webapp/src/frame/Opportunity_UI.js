Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/OpportunityDs", "nan21.dnet.module.sd.ui.extjs/dc/Opportunity", "nan21.dnet.module.md.ui.extjs/ds/MyCalendarEventDs", "nan21.dnet.module.md.ui.extjs/dc/MyCalendarEvent", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName","nan21.dnet.module.sd.ui.extjs/ds/OpportunityStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunityStatuses","nan21.dnet.module.sd.ui.extjs/ds/OpportunityPriorityLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunityPriorities","nan21.dnet.module.sd.ui.extjs/ds/OpportunityStageLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunityStages","nan21.dnet.module.sd.ui.extjs/ds/OpportunitySourceLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunitySources","nan21.dnet.module.sd.ui.extjs/ds/OpportunityResultReasonLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunityResultReasons","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.ad.ui.extjs/ds/AssignableLovDs","nan21.dnet.module.ad.ui.extjs/lov/Assignables","nan21.dnet.module.md.ui.extjs/ds/CalendarEventStatusCallLovDs","nan21.dnet.module.md.ui.extjs/lov/CalendarEventStatusCall","nan21.dnet.module.md.ui.extjs/ds/CalendarEventPriorityCallLovDs","nan21.dnet.module.md.ui.extjs/lov/CalendarEventPrioritiesCall","nan21.dnet.module.md.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.md.ui.extjs/lov/BpContacts","nan21.dnet.module.md.ui.extjs/ds/CalendarEventStatusMeetingLovDs","nan21.dnet.module.md.ui.extjs/lov/CalendarEventStatusMeeting","nan21.dnet.module.md.ui.extjs/ds/CalendarEventPriorityMeetingLovDs","nan21.dnet.module.md.ui.extjs/lov/CalendarEventPrioritiesMeeting","nan21.dnet.module.md.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.md.ui.extjs/lov/BpContacts","nan21.dnet.module.md.ui.extjs/ds/CalendarEventStatusTaskLovDs","nan21.dnet.module.md.ui.extjs/lov/CalendarEventStatusTask","nan21.dnet.module.md.ui.extjs/ds/CalendarEventPriorityTaskLovDs","nan21.dnet.module.md.ui.extjs/lov/CalendarEventPrioritiesTask","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName","nan21.dnet.module.sd.ui.extjs/ds/OpportunityStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunityStatuses","nan21.dnet.module.sd.ui.extjs/ds/OpportunityPriorityLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunityPriorities","nan21.dnet.module.sd.ui.extjs/ds/OpportunityStageLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunityStages","nan21.dnet.module.sd.ui.extjs/ds/OpportunitySourceLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunitySources","nan21.dnet.module.sd.ui.extjs/ds/OpportunityResultReasonLovDs","nan21.dnet.module.sd.ui.extjs/lov/OpportunityResultReasons","nan21.dnet.module.ad.ui.extjs/ds/AssignableLovDs","nan21.dnet.module.ad.ui.extjs/lov/Assignables","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.sd.opportunity.frame.Opportunity_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.opportunity.frame.Opportunity_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.opportunity.frame.Opportunity_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("opportunity", new net.nan21.dnet.module.sd.opportunity.dc.Opportunity({}))
		.addDc("event", new net.nan21.dnet.module.md.activity.dc.MyCalendarEvent({}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))		
		.linkDc("event", "opportunity",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("note", "opportunity",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("atch", "opportunity",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"entityFQN"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnCreateEventContinue",text:"Continue", tooltip:"Continue",disabled:false
			,handler: this.onBtnCreateEventContinue,scope:this	})	
							 	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addDcFilterFormView("opportunity",{ name:"opportunityFilter", xtype:"net.nan21.dnet.module.sd.opportunity.dc.Opportunity$Filter",height:150})	 
		.addDcGridView("opportunity",{ name:"opportunityList", xtype:"net.nan21.dnet.module.sd.opportunity.dc.Opportunity$List"})	 
		.addDcFormView("opportunity",{ name:"opportunityEdit", xtype:"net.nan21.dnet.module.sd.opportunity.dc.Opportunity$Edit",height:220})	 
		.addDcGridView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcEditGridView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addDcGridView("event",{ name:"eventList", xtype:"net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$List"})	 
		.addDcFormView("event",{ name:"eventEditCall", xtype:"net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$EditCall",title:"Call"})	 
		.addDcFormView("event",{ name:"eventEditMeeting", xtype:"net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$EditMeeting",title:"Meeting"})	 
		.addDcFormView("event",{ name:"eventEditTask", xtype:"net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$EditTask",title:"Task"})	 
		.addDcFormView("event",{ name:"eventCreate", xtype:"net.nan21.dnet.module.md.activity.dc.MyCalendarEvent$Create"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "eventPanel",layout:"card", activeItem:0,title:"Events"})  	 
		.addPanel({name: "eventEditPanel",layout:"card", activeItem:0})  	 

		.addPanel({name: "opportunityDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Notes"})  	 
		
		.addWindow({name:"wdwEventCreate", closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("eventCreate")]
,title:"Select type",modal:true,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnCreateEventContinue") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["opportunityFilter","opportunityList"] ,["north","center"])	
		.addChildrenTo("canvas2",["opportunityEdit","opportunityDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("opportunityDetailsTab", ["eventPanel","atchEditList","notesPanel"]) 				 		
	 	.addChildrenTo("eventPanel", ["eventList","eventEditPanel"]) 				 		
	 	.addChildrenTo("eventEditPanel", ["eventEditCall","eventEditMeeting","eventEditTask"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbOpportunityList")	  	
	 	.addToolbarTo("canvas2","tlbOpportunityEdit")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	 	.addToolbarTo("eventList","tlbCalendarList")	  	
	 	.addToolbarTo("eventEditPanel","tlbCalendarEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOpportunityList", {dc:"opportunity"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Opportunities"}).end()
			.beginToolbar("tlbOpportunityEdit", {dc:"opportunity"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Opportunity"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().addReports().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().addReports().end()
			.beginToolbar("tlbCalendarList", {dc:"event"}).addQuery().addEdit({inContainer:"eventPanel",showView:"eventEditPanel"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Events"}).end()
			.beginToolbar("tlbCalendarEdit", {dc:"event"}).addBack({inContainer:"eventPanel",showView:"eventList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Event"}).end(); 	
	}


	,onBtnCreateEventContinue: function() {
		this._getWindow_("wdwEventCreate").close();			 	
		this._selectEventEditorForm_();
	}					 	
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();			 	
	}
	,_whenCreateNewEvent_: function() {	
		this._getWindow_("wdwEventCreate").show();			 	
	}
	,onBtnViewAttachment: function() {	
		
		var url = this._getDc_("atch").getRecord().get("url");
		window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
	,onBtnUploadAttachment: function() {	
		var w=new dnet.core.base.FileUploadWindow({
    		_nameFieldValue_: this._getDc_("atch").getRecord().get("name"),
    		_p1Value_: this._getDc_("atch").getRecord().get("id"),
    		_uploadUrl_:"/nan21.dnet.core.web/upload/adDataAttachment",
    		_succesCallbackFn_ : this.onUploadSuccess,
    		_succesCallbackScope_: this
    	});w.show();
	}
	,_eventRecordChanged_: function(evnt) {	
		
    	//if (this._getElement_("eventPanel").getLayout().getActiveItem().name == "eventEditPanel") {
    		this._selectEventEditorForm_();
    	//}
    
	}
	,_selectEventEditorForm_: function() {	
		
    	var rec = this._getDc_("event").getRecord();
    	if (rec == null) {
    		return;
    	}
		var eventType = rec.get("eventType"); 
		if(eventType == "call") {
			this._showStackedViewElement_("eventEditPanel", "eventEditCall");
		}	
		if(eventType == "meeting") {
			this._showStackedViewElement_("eventEditPanel", "eventEditMeeting");
		}
		if(eventType == "task") {
			this._showStackedViewElement_("eventEditPanel", "eventEditTask");
		}
	}
	,_afterDefineDcs_: function() {	
		
    	this._getDc_("event").on("afterDoNew", this._whenCreateNewEvent_, this);
    	this._getDc_("event").on("recordChange", this._eventRecordChanged_, this);
	}
});  
