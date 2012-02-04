Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/ProjectDs", "nan21.dnet.module.pj.ui.extjs/dc/Project", "nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectVersion", "nan21.dnet.module.pj.ui.extjs/ds/ProjectComponentDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectComponent", "nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectMember", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.pj.ui.extjs/ds/ProjectTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectTypes","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectTypes","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes","nan21.dnet.module.ad.ui.extjs/ds/AssignableLovDs","nan21.dnet.module.ad.ui.extjs/lov/Assignables","nan21.dnet.module.pj.ui.extjs/ds/ProjectRoleLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectRoles"]);

Ext.define("net.nan21.dnet.module.pj.base.frame.Projects_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.base.frame.Projects_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.base.frame.Projects_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("project", new net.nan21.dnet.module.pj.md.dc.Project({}))
		.addDc("version", new net.nan21.dnet.module.pj.md.dc.ProjectVersion({multiEdit:true}))
		.addDc("component", new net.nan21.dnet.module.pj.md.dc.ProjectComponent({multiEdit:true}))
		.addDc("member", new net.nan21.dnet.module.pj.md.dc.ProjectMember({multiEdit:true}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))		
		.linkDc("version", "project",{fields:[ {childField:"projectId", parentField:"id"} ]} )
		.linkDc("component", "project",{fields:[ {childField:"projectId", parentField:"id"} ]} )
		.linkDc("member", "project",{fields:[ {childField:"projectId", parentField:"id"} ]} )
		.linkDc("atch", "project",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"entityFQN"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnRoadmapUi",text:"Roadmap", tooltip:"Show roadmap for selected version",disabled:true
			,handler: this.onBtnRoadmapUi,scope:this,stateManager:{name:"selected_one", dc:"version" }	})	
							 	
		.addButton({name:"btnChangelogUi",text:"Changelog", tooltip:"Show Changelog for selected version",disabled:true
			,handler: this.onBtnChangelogUi,scope:this,stateManager:{name:"selected_one", dc:"version" }	})	
							 	
		.addDcFilterFormView("project",{ name:"projectFilter", xtype:"net.nan21.dnet.module.pj.md.dc.Project$Filter",height:140})	 
		.addDcView("project",{ name:"projectList", xtype:"net.nan21.dnet.module.pj.md.dc.Project$List"})	 
		.addDcFormView("project",{ name:"projectEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Project$Edit",height:180})	 
		.addDcFilterFormView("version",{ name:"versionFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectVersion$Filter"})	 
		.addDcView("version",{ name:"versionEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectVersion$CtxEditList", frame:true,title:"Versions",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnRoadmapUi") ,this._elems_.get("btnChangelogUi") ]}]})	 
		.addDcFilterFormView("component",{ name:"componentFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectComponent$Filter"})	 
		.addDcView("component",{ name:"componentEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectComponent$CtxEditList", frame:true,title:"Components"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addDcView("member",{ name:"memberEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectMember$CtxEditList", frame:true,title:"Team"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "projectDetailsTab", xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["projectFilter","projectList"] ,["north","center"])	
		.addChildrenTo("canvas2",["projectEdit","projectDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("projectDetailsTab", ["memberEditList","versionEditList","componentEditList","atchEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbProjectList")	  	
	 	.addToolbarTo("canvas2","tlbProjectEdit")	  	
	 	.addToolbarTo("versionEditList","tlbVersionEditList")	  	
	 	.addToolbarTo("componentEditList","tlbComponentEditList")	  	
	 	.addToolbarTo("memberEditList","tlbMemberEditList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProjectList", {dc:"project"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Projects"}).end()
			.beginToolbar("tlbProjectEdit", {dc:"project"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Project"}).end()
			.beginToolbar("tlbVersionEditList", {dc:"version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Versions"}).end()
			.beginToolbar("tlbComponentEditList", {dc:"component"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Components"}).end()
			.beginToolbar("tlbMemberEditList", {dc:"member"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Team"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end(); 	
	}


	,onBtnRoadmapUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI";
				
		getApplication().showFrame(frame,{
	 		url:Dnet.buildUiPath(bundle, frame, false),  	 		 
	 		params: {
	 			targetVersionId: this._getDc_("version").getRecord().get("id")	 			,
	 			targetVersion: this._getDc_("version").getRecord().get("name")	 			,
	 			projectId: this._getDc_("version").getRecord().get("projectId")	 			,
	 			project: this._getDc_("version").getRecord().get("project")	 			
		    }, 				      
	 		callback: function (params) {	           
	          this._when_called_to_query_(params);                                    
			} 				    
	  	});
		
		
	}					 	

	,onBtnChangelogUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI";
				
		getApplication().showFrame(frame,{
	 		url:Dnet.buildUiPath(bundle, frame, false),  	 		 
	 		params: {
	 			fixedInVersion: this._getDc_("version").getRecord().get("id")	 			,
	 			fixedInVersion: this._getDc_("version").getRecord().get("name")	 			,
	 			projectId: this._getDc_("version").getRecord().get("projectId")	 			,
	 			project: this._getDc_("version").getRecord().get("project")	 			
		    }, 				      
	 		callback: function (params) {	           
	          this._when_called_to_query_(params);                                    
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
