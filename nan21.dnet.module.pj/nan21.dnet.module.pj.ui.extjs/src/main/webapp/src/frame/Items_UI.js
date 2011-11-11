Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/ItemDs", "nan21.dnet.module.pj.ui.extjs/dc/Item", "nan21.dnet.module.pj.ui.extjs/ds/ItemLinkDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemLink", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.pj.ui.extjs/ds/ItemTaskDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemTaskCtx","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/ItemTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemStatus","nan21.dnet.module.pj.ui.extjs/ds/ItemPriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemPriorities","nan21.dnet.module.pj.ui.extjs/ds/ItemResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemResolutions","nan21.dnet.module.pj.ui.extjs/ds/ItemSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemSeverities","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ItemLinkTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemLinkTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemTaskTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTaskTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemTaskStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTaskStatuses","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/ItemTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemStatus","nan21.dnet.module.pj.ui.extjs/ds/ItemPriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemPriorities","nan21.dnet.module.pj.ui.extjs/ds/ItemResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemResolutions","nan21.dnet.module.pj.ui.extjs/ds/ItemSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemSeverities","nan21.dnet.module.ad.ui.extjs/ds/AssignableLovDs","nan21.dnet.module.ad.ui.extjs/lov/Assignables","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes","nan21.dnet.module.pj.ui.extjs/asgn/ItemAffectedVersions","nan21.dnet.module.pj.ui.extjs/asgn/ItemAffectedComponents"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.Items_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.md.frame.Items_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.md.frame.Items_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("item", new net.nan21.dnet.module.pj.md.dc.Item({}))
		.addDc("link", new net.nan21.dnet.module.pj.md.dc.ItemLink({}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("task", new net.nan21.dnet.module.pj.md.dc.ItemTaskCtx({}))		
		.linkDc("link", "item",{fields:[ {childField:"sourceItemId", parentField:"id"} ]} )
		.linkDc("atch", "item",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"businessObject"} ]} )
		.linkDc("note", "item",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("task", "item",{fields:[ {childField:"itemId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnAsgnAffectedVersions",text:"Affected versions", tooltip:"Add affected versions",disabled:true
			,handler: this.onBtnAsgnAffectedVersions,scope:this,stateManager:{name:"record_is_clean", dc:"item" }	})	
							 	
		.addButton({name:"btnAsgnAffectedComps",text:"Affected components", tooltip:"Add affected components",disabled:true
			,handler: this.onBtnAsgnAffectedComps,scope:this,stateManager:{name:"record_is_clean", dc:"item" }	})	
							 	
		.addButton({name:"btnSaveLink",text:"Save", tooltip:"Save link",disabled:true
			,handler: this.onBtnSaveLink,scope:this,stateManager:{name:"record_is_dirty", dc:"link" }	})	
							 	
		.addButton({name:"btnCancelLink",text:"Cancel", tooltip:"Cancel",disabled:true
			,handler: this.onBtnCancelLink,scope:this,stateManager:{name:"record_is_dirty", dc:"link" }	})	
							 	
		.addDcFilterFormView("item",{ name:"itemFilter", xtype:"net.nan21.dnet.module.pj.md.dc.Item$Filter",height:160})	 
		.addDcView("item",{ name:"itemList", xtype:"net.nan21.dnet.module.pj.md.dc.Item$List"})	 
		.addDcFormView("item",{ name:"itemEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Item$Edit",height:250,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAsgnAffectedVersions") ,this._elems_.get("btnAsgnAffectedComps") ]}]})	 
		.addDcFormView("item",{ name:"itemEditText", xtype:"net.nan21.dnet.module.pj.md.dc.Item$EditText",title:"Description"})	 
		.addDcView("link",{ name:"linkList", xtype:"net.nan21.dnet.module.pj.md.dc.ItemLink$CtxList",title:"Links"})	 
		.addDcFormView("link",{ name:"linkCreate", xtype:"net.nan21.dnet.module.pj.md.dc.ItemLink$CtxCreate"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addDcView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcView("task",{ name:"taskList", xtype:"net.nan21.dnet.module.pj.md.dc.ItemTaskCtx$List"})	 
		.addDcFormView("task",{ name:"taskEdit", xtype:"net.nan21.dnet.module.pj.md.dc.ItemTaskCtx$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "tasksPanel",layout:"card", activeItem:0,title:"Tasks"})  	 
		.addPanel({name: "itemDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true,onActivateDoLayoutFor:["itemDetailsTab"]})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Comments"})  	 
		.addPanel({name: "taskEditWrapper", layout:"fit"})
		
		.addWindow({name:"wdwItemLinkCreate", closable:true, closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("linkCreate")]
,title:"Create link",modal:true,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnSaveLink") ,this._elems_.get("btnCancelLink") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["itemFilter","itemList"] ,["north","center"])	
		.addChildrenTo("canvas2",["itemEdit","itemDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("itemDetailsTab", ["itemEditText","tasksPanel","atchEditList","linkList","notesPanel"]) 				 		
	 	.addChildrenTo("tasksPanel", ["taskList","taskEditWrapper"]) 				 		
	 	.addChildrenTo("taskEditWrapper", ["taskEdit"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbItemList")	  	
	 	.addToolbarTo("canvas2","tlbItemEdit")	  	
	 	.addToolbarTo("linkList","tlbLinkList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	 	.addToolbarTo("taskList","tlbTaskList")	  	
	 	.addToolbarTo("taskEditWrapper","tlbTaskEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbItemList", {dc:"item"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbItemEdit", {dc:"item"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbLinkList", {dc:"link"}).addQuery().addNew().addDeleteSelected().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Links"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbTaskList", {dc:"task"}).addQuery().addEdit({inContainer:"tasksPanel",showView:"taskEditWrapper"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbTaskEdit", {dc:"task"}).addBack({inContainer:"tasksPanel",showView:"taskList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().end(); 	
	}


	,onBtnAsgnAffectedVersions: function() {
		this.showAsgnWindow(net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Ui ,{dc:"item",objectIdField:"id"});
	}					 	

	,onBtnAsgnAffectedComps: function() {
		this.showAsgnWindow(net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Ui ,{dc:"item",objectIdField:"id"});
	}					 	

	,onBtnSaveLink: function() {
this._getDc_("link").doSave();			 	
	}					 	

	,onBtnCancelLink: function() {
this._getDc_("link").doCancel();			 	
this._getWindow_("wdwItemLinkCreate").close();			 	
	}					 	
	,onUploadSuccess: function() {	
this._getDc_("atch").doQuery();			 	
	}
	,_whenCreateNewLink_: function() {	
this._getWindow_("wdwItemLinkCreate").show();			 	
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
	,_afterDefineDcs_: function() {	
		this._getDc_("link").on("afterDoNew", this._whenCreateNewLink_, this);
	}
});  
