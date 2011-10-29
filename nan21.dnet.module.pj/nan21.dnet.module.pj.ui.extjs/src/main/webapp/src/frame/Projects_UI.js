Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/ProjectDs", "nan21.dnet.module.pj.ui.extjs/dc/Project", "nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectVersion","nan21.dnet.module.pj.ui.extjs/ds/ProjectTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectTypes","nan21.dnet.module.pj.ui.extjs/ds/ProjectTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectTypes"]);

Ext.define("net.nan21.dnet.module.pj.base.frame.Projects_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.base.frame.Projects_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.base.frame.Projects_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("project", new net.nan21.dnet.module.pj.md.dc.Project({}))
		.addDc("version", new net.nan21.dnet.module.pj.md.dc.ProjectVersion({multiEdit:true}))		
		.linkDc("version", "project",{fields:[ {childField:"projectId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("project",{ name:"projectFilter", xtype:"net.nan21.dnet.module.pj.md.dc.Project$Filter",height:80})	 
		.addDcView("project",{ name:"projectList", xtype:"net.nan21.dnet.module.pj.md.dc.Project$List"})	 
		.addDcFormView("project",{ name:"projectEdit", xtype:"net.nan21.dnet.module.pj.md.dc.Project$Edit",height:120})	 
		.addDcFilterFormView("version",{ name:"versionFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectVersion$Filter"})	 
		.addDcView("version",{ name:"versionEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectVersion$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["projectFilter","projectList"] ,["north","center"])	
		.addChildrenTo("canvas2",["projectEdit","versionEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbProjectList")	  	
	 	.addToolbarTo("canvas2","tlbProjectEdit")	  	
	 	.addToolbarTo("versionEditList","tlbVersionEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProjectList", {dc:"project"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbProjectEdit", {dc:"project"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbVersionEditList", {dc:"version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}

});  
