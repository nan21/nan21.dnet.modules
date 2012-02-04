Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/IssueDs", "nan21.dnet.module.pj.ui.extjs/dc/Issue", "nan21.dnet.module.pj.ui.extjs/ds/IssueLinkDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueLink", "nan21.dnet.module.pj.ui.extjs/ds/IssueAttachmentDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueAttachment", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.pj.ui.extjs/ds/IssueTaskDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueTaskCtx","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueStatus","nan21.dnet.module.pj.ui.extjs/ds/IssuePriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssuePriorities","nan21.dnet.module.pj.ui.extjs/ds/IssueResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueResolutions","nan21.dnet.module.pj.ui.extjs/ds/IssueSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueSeverities","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionReleasedLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersionsReleased","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionPlannedLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersionsPlanned","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/IssueLovDs","nan21.dnet.module.pj.ui.extjs/lov/Issues","nan21.dnet.module.pj.ui.extjs/ds/IssueLinkTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueLinkTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskStatuses","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueStatus","nan21.dnet.module.pj.ui.extjs/ds/IssuePriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssuePriorities","nan21.dnet.module.pj.ui.extjs/ds/IssueResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueResolutions","nan21.dnet.module.pj.ui.extjs/ds/IssueSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueSeverities","nan21.dnet.module.ad.ui.extjs/ds/AssignableLovDs","nan21.dnet.module.ad.ui.extjs/lov/Assignables","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectComponentLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectComponents","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes","nan21.dnet.module.pj.ui.extjs/asgn/IssueAffectedVersions","nan21.dnet.module.pj.ui.extjs/asgn/IssueAffectedComponents"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.Issues_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.md.frame.Issues_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.md.frame.Issues_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("issue", new net.nan21.dnet.module.pj.md.dc.Issue({}))
		.addDc("link", new net.nan21.dnet.module.pj.md.dc.IssueLink({}))
		.addDc("atch", new net.nan21.dnet.module.pj.md.dc.IssueAttachment({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("task", new net.nan21.dnet.module.pj.md.dc.IssueTaskCtx({}))		
		.linkDc("link", "issue",{fields:[ {childField:"sourceIssueId", parentField:"id"} ]} )
		.linkDc("atch", "issue",{fields:[ {childField:"issueId", parentField:"id"} ]} )
		.linkDc("note", "issue",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("task", "issue",{fields:[ {childField:"issueId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnAsgnAffectedVersions",text:"Affected versions", tooltip:"Add affected versions",disabled:true
			,handler: this.onBtnAsgnAffectedVersions,scope:this,stateManager:{name:"record_is_clean", dc:"issue" }	})	
							 	
		.addButton({name:"btnAsgnAffectedComps",text:"Affected components", tooltip:"Add affected components",disabled:true
			,handler: this.onBtnAsgnAffectedComps,scope:this,stateManager:{name:"record_is_clean", dc:"issue" }	})	
							 	
		.addButton({name:"btnSaveLink",text:"Save", tooltip:"Save link",disabled:true
			,handler: this.onBtnSaveLink,scope:this,stateManager:{name:"record_is_dirty", dc:"link" }	})	
							 	
		.addButton({name:"btnCancelLink",text:"Cancel", tooltip:"Cancel",disabled:true
			,handler: this.onBtnCancelLink,scope:this,stateManager:{name:"record_is_dirty", dc:"link" }	})	
							 	
		.addButton({name:"btnTaskUi",text:"Tasks editor", tooltip:"Open standalone task editor frame",disabled:false
			,handler: this.onBtnTaskUi,scope:this	})	
							 	
		.addButton({name:"btnRoadmapUi",text:"Roadmap", tooltip:"Open roadmap frame",disabled:false
			,handler: this.onBtnRoadmapUi,scope:this	})	
							 	
		.addButton({name:"btnChangelogUi",text:"Changelog", tooltip:"Open changelog frame",disabled:false
			,handler: this.onBtnChangelogUi,scope:this	})	
							 	
		.addDcFilterFormView("issue",{ name:"issueFilter", xtype:"net.nan21.dnet.module.pj.md.dc.Issue$Filter",height:180})	 
		.addDcView("issue",{ name:"issueList", xtype:"net.nan21.dnet.module.pj.md.dc.Issue$List"})	 
		.addDcFormView("issue",{ name:"issueEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Issue$Edit",height:220,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAsgnAffectedVersions") ,this._elems_.get("btnAsgnAffectedComps") ]}]})	 
		.addDcFormView("issue",{ name:"issueEditText", xtype:"net.nan21.dnet.module.pj.md.dc.Issue$EditText",title:"Description"})	 
		.addDcView("link",{ name:"linkList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueLink$CtxList",title:"Links"})	 
		.addDcFormView("link",{ name:"linkCreate", xtype:"net.nan21.dnet.module.pj.md.dc.IssueLink$CtxCreate"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueAttachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addDcView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcView("task",{ name:"taskList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$List"})	 
		.addDcFormView("task",{ name:"taskEdit", xtype:"net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "tasksPanel",layout:"card", activeItem:0,title:"Tasks"})  	 
		.addPanel({name: "issueDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true,onActivateDoLayoutFor:["issueDetailsTab"]})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Comments"})  	 
		.addPanel({name: "taskEditWrapper", layout:"fit"})
		
		.addWindow({name:"wdwIssueLinkCreate", closable:true, closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("linkCreate")]
,title:"Create link",modal:true,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnSaveLink") ,this._elems_.get("btnCancelLink") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["issueFilter","issueList"] ,["north","center"])	
		.addChildrenTo("canvas2",["issueEdit","issueDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("issueDetailsTab", ["issueEditText","tasksPanel","atchEditList","linkList","notesPanel"]) 				 		
	 	.addChildrenTo("tasksPanel", ["taskList","taskEditWrapper"]) 				 		
	 	.addChildrenTo("taskEditWrapper", ["taskEdit"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbIssueList")	  	
	 	.addToolbarTo("canvas2","tlbIssueEdit")	  	
	 	.addToolbarTo("linkList","tlbLinkList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	 	.addToolbarTo("taskList","tlbTaskList")	  	
	 	.addToolbarTo("taskEditWrapper","tlbTaskEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbIssueList", {dc:"issue"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Issues"}).end()
			.beginToolbar("tlbIssueEdit", {dc:"issue"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addButtons([this._elems_.get("btnTaskUi") ,this._elems_.get("btnChangelogUi") ,this._elems_.get("btnRoadmapUi") ]).addSeparator().addSeparator().addTitle({"text":"Issue"}).end()
			.beginToolbar("tlbLinkList", {dc:"link"}).addQuery().addNew().addDeleteSelected().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Links"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Notes"}).end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbTaskList", {dc:"task"}).addQuery().addEdit({inContainer:"tasksPanel",showView:"taskEditWrapper"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Tasks"}).end()
			.beginToolbar("tlbTaskEdit", {dc:"task"}).addBack({inContainer:"tasksPanel",showView:"taskList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Task"}).end(); 	
	}


	,onBtnAsgnAffectedVersions: function() {
		this.showAsgnWindow(net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Ui ,{dc:"issue",objectIdField:"id"});
	}					 	

	,onBtnAsgnAffectedComps: function() {
		this.showAsgnWindow(net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Ui ,{dc:"issue",objectIdField:"id"});
	}					 	

	,onBtnSaveLink: function() {
this._getDc_("link").doSave();			 	
	}					 	

	,onBtnCancelLink: function() {
this._getDc_("link").doCancel();			 	
this._getWindow_("wdwIssueLinkCreate").close();			 	
	}					 	

	,onBtnTaskUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueTask_UI";
		
		getApplication().showFrameByName("nan21.dnet.module.pj.ui.extjs","net.nan21.dnet.module.pj.md.frame.IssueTask_UI");
		
		
	}					 	

	,onBtnRoadmapUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI";
		
		getApplication().showFrameByName("nan21.dnet.module.pj.ui.extjs","net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI");
		
		
	}					 	

	,onBtnChangelogUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI";
		
		getApplication().showFrameByName("nan21.dnet.module.pj.ui.extjs","net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI");
		
		
	}					 	
	,onUploadSuccess: function() {	
this._getDc_("atch").doQuery();			 	
	}
	,_whenCreateNewLink_: function() {	
this._getWindow_("wdwIssueLinkCreate").show();			 	
	}
	,onBtnUploadAttachment: function() {	
		var w=new dnet.core.base.FileUploadWindow({
    		_nameFieldValue_: this._getDc_("atch").getRecord().get("name"),
    		_p1Value_: this._getDc_("atch").getRecord().get("id"),
    		_uploadUrl_:"/nan21.dnet.core.web/upload/projectIssueAttachmentUpload",
    		_succesCallbackFn_ : this.onUploadSuccess,
    		_succesCallbackScope_: this
    	});w.show();
	}
	,onBtnViewAttachment: function() {	
		
		var url = this._getDc_("atch").getRecord().get("url");
		window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
	,_afterDefineDcs_: function() {	
		this._getDc_("link").on("afterDoNew", this._whenCreateNewLink_, this);
	}
	,_when_called_to_edit_: function(params) {	
		
		var issue = this._getDc_("issue");
		if (issue.isDirty()) {
			this._alert_dirty_();
			return;
		}
		issue.doClearQuery();
		issue.setFilterValue("code", params.code );
		issue.doQuery();
		this._showStackedViewElement_("main",1);
	}
});  
