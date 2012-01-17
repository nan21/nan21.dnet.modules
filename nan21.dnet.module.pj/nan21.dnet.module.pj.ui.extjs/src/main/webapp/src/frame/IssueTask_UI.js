Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/IssueTaskDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueTask", "nan21.dnet.module.pj.ui.extjs/ds/IssueDs", "nan21.dnet.module.pj.ui.extjs/dc/Issue", "nan21.dnet.module.pj.ui.extjs/ds/IssueLinkDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueLink", "nan21.dnet.module.pj.ui.extjs/ds/IssueAttachmentDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueAttachment", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskStatuses","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/IssueLovDs","nan21.dnet.module.pj.ui.extjs/lov/Issues","nan21.dnet.module.pj.ui.extjs/ds/IssueSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueSeverities","nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueStatus","nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTypes","nan21.dnet.module.pj.ui.extjs/ds/IssuePriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssuePriorities","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskStatuses","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/IssueLovDs","nan21.dnet.module.pj.ui.extjs/lov/Issues","nan21.dnet.module.pj.ui.extjs/ds/IssueLovDs","nan21.dnet.module.pj.ui.extjs/lov/Issues","nan21.dnet.module.pj.ui.extjs/ds/IssueLinkTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueLinkTypes"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.IssueTask_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.md.frame.IssueTask_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.md.frame.IssueTask_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("task", new net.nan21.dnet.module.pj.md.dc.IssueTask({}))
		.addDc("issue", new net.nan21.dnet.module.pj.md.dc.Issue({}))
		.addDc("link", new net.nan21.dnet.module.pj.md.dc.IssueLink({multiEdit:true}))
		.addDc("atch", new net.nan21.dnet.module.pj.md.dc.IssueAttachment({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))		
		.linkDc("issue", "task",{fetchMode:"auto",fields:[ {childField:"id", parentField:"issueId"} ]} )
		.linkDc("link", "task",{fields:[ {childField:"sourceIssueId", parentField:"issueId"} ]} )
		.linkDc("atch", "issue",{fields:[ {childField:"issueId", parentField:"id"} ]} )
		.linkDc("note", "task",{fields:[ {childField:"targetId", parentField:"issueId"},{childField:"targetType", parentField:"issueClassName"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnIssueUi",text:"Edit issue", tooltip:"Show current issue in editor frame",disabled:true
			,handler: this.onBtnIssueUi,scope:this,stateManager:{name:"selected_one", dc:"issue" }	})	
							 	
		.addDcFilterFormView("task",{ name:"taskFilter", xtype:"net.nan21.dnet.module.pj.md.dc.IssueTask$Filter",height:180})	 
		.addDcView("task",{ name:"taskList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueTask$List"})	 
		.addDcFormView("task",{ name:"taskEdit", xtype:"net.nan21.dnet.module.pj.md.dc.IssueTask$Edit",height:180})	 
		.addDcFormView("issue",{ name:"issueEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Issue$View"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueAttachment$CtxList",title:"Issue attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ]}]})	 
		.addDcView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcFilterFormView("link",{ name:"linkFilter", xtype:"net.nan21.dnet.module.pj.md.dc.IssueLink$Filter"})	 
		.addDcView("link",{ name:"linkEditList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueLink$CtxList",title:"Issue links"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "taskDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Comments"})  	 
		.addPanel({name: "issueInfoPanel", layout:"fit",title:"Issue info"})
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["taskFilter","taskList"] ,["north","center"])	
		.addChildrenTo("canvas2",["taskEdit","taskDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("taskDetailsTab", ["issueInfoPanel","atchEditList","linkEditList","notesPanel"]) 				 		
	 	.addChildrenTo("issueInfoPanel", ["issueEdit"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbTaskList")	  	
	 	.addToolbarTo("canvas2","tlbTaskEdit")	  	
	 	.addToolbarTo("linkEditList","tlbLinkList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTaskList", {dc:"task"}).addQuery().addEdit().addSeparator().addSeparator().addTitle({"text":"Issue tasks"}).end()
			.beginToolbar("tlbTaskEdit", {dc:"task"}).addBack().addSave().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addButtons([this._elems_.get("btnIssueUi") ]).addSeparator().addSeparator().addTitle({"text":"Issue task"}).end()
			.beginToolbar("tlbLinkList", {dc:"link"}).addQuery().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Issue links"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Issue attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().end(); 	
	}


	,onBtnIssueUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.Issues_UI";
				
		getApplication().showFrame(frame,{
	 		url:Dnet.buildUiPath(bundle, frame, false),  	 		 
	 		params: {
	 			code: this._getDc_("task").getRecord().get("issue")	 			
		    }, 				      
	 		callback: function (params) {	           
	          this._when_called_to_edit_(params);                                    
			} 				    
	  	});
		
		
	}					 	
	,onUploadSuccess: function() {	
this._getDc_("atch").doQuery();			 	
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
	,onBtnViewAttachment: function() {	
		
		var url = this._getDc_("atch").getRecord().get("url");
		window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
});  
