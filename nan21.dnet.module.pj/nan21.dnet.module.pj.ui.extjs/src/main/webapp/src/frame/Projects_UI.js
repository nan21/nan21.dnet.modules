Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/ProjectDs", "nan21.dnet.module.pj.ui.extjs/dc/Project", "nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectVersion", "nan21.dnet.module.pj.ui.extjs/ds/ProjectComponentDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectComponent", "nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectMember","nan21.dnet.module.pj.ui.extjs/ds/ProjectTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectTypes","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectTypes","nan21.dnet.module.pj.ui.extjs/ds/ProjectMemberLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectMembers","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.ad.ui.extjs/ds/AssignableLovDs","nan21.dnet.module.ad.ui.extjs/lov/Assignables","nan21.dnet.module.pj.ui.extjs/ds/ProjectRoleLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectRoles"]);

Ext.define("net.nan21.dnet.module.pj.base.frame.Projects_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.base.frame.Projects_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.base.frame.Projects_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("project", new net.nan21.dnet.module.pj.md.dc.Project({}))
		.addDc("version", new net.nan21.dnet.module.pj.md.dc.ProjectVersion({multiEdit:true}))
		.addDc("component", new net.nan21.dnet.module.pj.md.dc.ProjectComponent({multiEdit:true}))
		.addDc("member", new net.nan21.dnet.module.pj.md.dc.ProjectMember({multiEdit:true}))		
		.linkDc("version", "project",{fields:[ {childField:"projectId", parentField:"id"} ]} )
		.linkDc("component", "project",{fields:[ {childField:"projectId", parentField:"id"} ]} )
		.linkDc("member", "project",{fields:[ {childField:"projectId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("project",{ name:"projectFilter", xtype:"net.nan21.dnet.module.pj.md.dc.Project$Filter",height:80})	 
		.addDcView("project",{ name:"projectList", xtype:"net.nan21.dnet.module.pj.md.dc.Project$List"})	 
		.addDcFormView("project",{ name:"projectEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Project$Edit",height:140})	 
		.addDcFilterFormView("version",{ name:"versionFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectVersion$Filter"})	 
		.addDcView("version",{ name:"versionEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectVersion$CtxEditList", frame:true,title:"Versions"})	 
		.addDcFilterFormView("component",{ name:"componentFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectComponent$Filter"})	 
		.addDcView("component",{ name:"componentEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectComponent$CtxEditList", frame:true,title:"Components"})	 
		.addDcView("member",{ name:"memberEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectMember$CtxEditList", frame:true,title:"Team"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "projectDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["projectFilter","projectList"] ,["north","center"])	
		.addChildrenTo("canvas2",["projectEdit","projectDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("projectDetailsTab", ["memberEditList","versionEditList","componentEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbProjectList")	  	
	 	.addToolbarTo("canvas2","tlbProjectEdit")	  	
	 	.addToolbarTo("versionEditList","tlbVersionEditList")	  	
	 	.addToolbarTo("componentEditList","tlbComponentEditList")	  	
	 	.addToolbarTo("memberEditList","tlbMemberEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProjectList", {dc:"project"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbProjectEdit", {dc:"project"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbVersionEditList", {dc:"version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Versions"}).end()
			.beginToolbar("tlbComponentEditList", {dc:"component"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Components"}).end()
			.beginToolbar("tlbMemberEditList", {dc:"member"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Team"}).end(); 	
	}

});  
