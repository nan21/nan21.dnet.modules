Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/IssueTaskDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueTask", "nan21.dnet.module.pj.ui.extjs/ds/IssueDs", "nan21.dnet.module.pj.ui.extjs/dc/Issue", "nan21.dnet.module.pj.ui.extjs/ds/IssueLinkDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueLink", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskStatuses","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueStatus","nan21.dnet.module.pj.ui.extjs/ds/IssuePriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssuePriorities","nan21.dnet.module.pj.ui.extjs/ds/IssueResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueResolutions","nan21.dnet.module.pj.ui.extjs/ds/IssueSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueSeverities","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/IssueLovDs","nan21.dnet.module.pj.ui.extjs/lov/Issues","nan21.dnet.module.pj.ui.extjs/ds/IssueSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueSeverities","nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueStatus","nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTypes","nan21.dnet.module.pj.ui.extjs/ds/IssuePriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssuePriorities","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueTaskStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTaskStatuses","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/IssueLovDs","nan21.dnet.module.pj.ui.extjs/lov/Issues","nan21.dnet.module.pj.ui.extjs/ds/IssueLovDs","nan21.dnet.module.pj.ui.extjs/lov/Issues","nan21.dnet.module.pj.ui.extjs/ds/IssueLinkTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueLinkTypes","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.IssueTask_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.md.frame.IssueTask_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.md.frame.IssueTask_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("task", new net.nan21.dnet.module.pj.md.dc.IssueTask({}))
		.addDc("issue", new net.nan21.dnet.module.pj.md.dc.Issue({}))
		.addDc("link", new net.nan21.dnet.module.pj.md.dc.IssueLink({multiEdit:true}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))		
		.linkDc("issue", "task",{fetchMode:"auto",fields:[ {childField:"id", parentField:"issueId"} ]} )
		.linkDc("link", "task",{fields:[ {childField:"sourceIssueId", parentField:"issueId"} ]} )
		.linkDc("atch", "task",{fields:[ {childField:"targetId", parentField:"issueId"},{childField:"targetType", parentField:"issueBusinessObject"} ]} )
		.linkDc("note", "task",{fields:[ {childField:"targetId", parentField:"issueId"},{childField:"targetType", parentField:"issueClassName"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addDcFilterFormView("task",{ name:"taskFilter", xtype:"net.nan21.dnet.module.pj.md.dc.IssueTask$Filter",height:150})	 
		.addDcView("task",{ name:"taskList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueTask$List"})	 
		.addDcFormView("task",{ name:"taskEdit", xtype:"net.nan21.dnet.module.pj.md.dc.IssueTask$Edit",height:180})	 
		.addDcFormView("issue",{ name:"issueEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Issue$Edit"})	 
		.addDcFormView("issue",{ name:"issueEditText", xtype:"net.nan21.dnet.module.pj.md.dc.Issue$EditText",width:"100%"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addDcView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcFilterFormView("link",{ name:"linkFilter", xtype:"net.nan21.dnet.module.pj.md.dc.IssueLink$Filter"})	 
		.addDcView("link",{ name:"linkEditList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueLink$CtxList",title:"Links"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "taskDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Comments"})  	 
		.addPanel({name: "issueInfoPanel",title:"Issue info"})
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["taskFilter","taskList"] ,["north","center"])	
		.addChildrenTo("canvas2",["taskEdit","taskDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("taskDetailsTab", ["issueInfoPanel","atchEditList","linkEditList","notesPanel"]) 				 		
	 	.addChildrenTo("issueInfoPanel", ["issueEdit","issueEditText"]) 				 		
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
			.beginToolbar("tlbTaskList", {dc:"task"}).addQuery().addEdit().end()
			.beginToolbar("tlbTaskEdit", {dc:"task"}).addBack().addSave().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbLinkList", {dc:"link"}).addQuery().addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Links"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().end(); 	
	}

	,onUploadSuccess: function() {	
this._getDc_("atch").doQuery();			 	
	}
	,onBtnUploadAttachment: function() {	
		var w=new dnet.base.FileUploadWindow({
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
