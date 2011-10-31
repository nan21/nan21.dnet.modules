Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/ItemTaskDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemTask", "nan21.dnet.module.pj.ui.extjs/ds/ItemDs", "nan21.dnet.module.pj.ui.extjs/dc/Item", "nan21.dnet.module.pj.ui.extjs/ds/ItemLinkDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemLink", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note","nan21.dnet.module.pj.ui.extjs/ds/ItemTaskTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTaskTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemTaskStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTaskStatuses","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/ItemTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemStatus","nan21.dnet.module.pj.ui.extjs/ds/ItemPriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemPriorities","nan21.dnet.module.pj.ui.extjs/ds/ItemResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemResolutions","nan21.dnet.module.pj.ui.extjs/ds/ItemSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemSeverities","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ItemTaskTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTaskTypes","nan21.dnet.module.pj.ui.extjs/ds/ItemTaskStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemTaskStatuses","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ItemPriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemPriorities","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.ItemTask_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.md.frame.ItemTask_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.md.frame.ItemTask_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("task", new net.nan21.dnet.module.pj.md.dc.ItemTask({}))
		.addDc("item", new net.nan21.dnet.module.pj.md.dc.Item({}))
		.addDc("link", new net.nan21.dnet.module.pj.md.dc.ItemLink({multiEdit:true}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))		
		.linkDc("item", "task",{fetchMode:"auto",fields:[ {childField:"id", parentField:"itemId"} ]} )
		.linkDc("link", "task",{fields:[ {childField:"sourceItemId", parentField:"itemId"} ]} )
		.linkDc("atch", "task",{fields:[ {childField:"targetId", parentField:"itemId"},{childField:"targetType", parentField:"itemBusinessObject"} ]} )
		.linkDc("note", "task",{fields:[ {childField:"targetId", parentField:"itemId"},{childField:"targetType", parentField:"itemClassName"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addDcFilterFormView("task",{ name:"taskFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ItemTask$Filter"})	 
		.addDcView("task",{ name:"taskList", xtype:"net.nan21.dnet.module.pj.md.dc.ItemTask$List"})	 
		.addDcFormView("task",{ name:"taskEdit", xtype:"net.nan21.dnet.module.pj.md.dc.ItemTask$Edit",height:180})	 
		.addDcFormView("item",{ name:"itemEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Item$Edit"})	 
		.addDcFormView("item",{ name:"itemEditText", xtype:"net.nan21.dnet.module.pj.md.dc.Item$EditText",width:"100%"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addDcView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcFilterFormView("link",{ name:"linkFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ItemLink$Filter"})	 
		.addDcView("link",{ name:"linkEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ItemLink$CtxList",title:"Links"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "taskDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Comments"})  	 
		.addPanel({name: "itemInfoPanel",title:"Issue info"})
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["taskFilter","taskList"] ,["north","center"])	
		.addChildrenTo("canvas2",["taskEdit","taskDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("taskDetailsTab", ["itemInfoPanel","atchEditList","linkEditList","notesPanel"]) 				 		
	 	.addChildrenTo("itemInfoPanel", ["itemEdit","itemEditText"]) 				 		
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
			.beginToolbar("tlbTaskEdit", {dc:"task"}).addSave().addCancel().addPrevRec().addNextRec().end()
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
