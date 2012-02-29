Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/IssueDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueMnt","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueStatus","nan21.dnet.module.pj.ui.extjs/ds/IssuePriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssuePriorities","nan21.dnet.module.pj.ui.extjs/ds/IssueResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueResolutions","nan21.dnet.module.pj.ui.extjs/ds/IssueSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueSeverities","nan21.dnet.module.ad.ui.extjs/ds/AssignableLovDs","nan21.dnet.module.ad.ui.extjs/lov/Assignables","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectComponentLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectComponents","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueStatus","nan21.dnet.module.pj.ui.extjs/ds/IssuePriorityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssuePriorities","nan21.dnet.module.pj.ui.extjs/ds/IssueSeverityLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueSeverities","nan21.dnet.module.ad.ui.extjs/ds/AssignableLovDs","nan21.dnet.module.ad.ui.extjs/lov/Assignables","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions","nan21.dnet.module.pj.ui.extjs/ds/IssueResolutionLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueResolutions"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.IssuesMnt_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.md.frame.IssuesMnt_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.md.frame.IssuesMnt_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("issue", new net.nan21.dnet.module.pj.md.dc.IssueMnt({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("issue",{ name:"issueFilter", xtype:"net.nan21.dnet.module.pj.md.dc.IssueMnt$Filter",height:180})	 
		.addDcEditGridView("issue",{ name:"issueList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueMnt$EditList", frame:true})	 
		.addDcFormView("issue",{ name:"issueViewText", xtype:"net.nan21.dnet.module.pj.md.dc.IssueMnt$EditText",height:120,title:"Description", collapsible:true, collapsed:true})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["issueFilter","issueList","issueViewText"] ,["north","center","south"])	
	 	.addToolbarTo("main","tlbIssueList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbIssueList", {dc:"issue"}).addQuery().addSave().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Issue maintenance"}).end(); 	
	}

});  
