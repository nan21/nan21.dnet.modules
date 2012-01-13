Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/IssueRoadmapDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueRoadmap", "nan21.dnet.module.pj.ui.extjs/ds/IssueDs", "nan21.dnet.module.pj.ui.extjs/dc/Issue","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueTypes","nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs","nan21.dnet.module.pj.ui.extjs/lov/IssueStatus","nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs","nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("issue", new net.nan21.dnet.module.pj.md.dc.IssueRoadmap({}))
		.addDc("issueInfo", new net.nan21.dnet.module.pj.md.dc.Issue({}))		
		.linkDc("issueInfo", "issue",{fetchMode:"auto",fields:[ {childField:"id", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnIssueUi",text:"Edit issue", tooltip:"Show current issue in editor frame",disabled:true
			,handler: this.onBtnIssueUi,scope:this,stateManager:{name:"selected_one", dc:"issue" }	})	
							 	
		.addDcFilterFormView("issue",{ name:"issueFilter", xtype:"net.nan21.dnet.module.pj.md.dc.IssueRoadmap$Filter",height:80})	 
		.addDcView("issue",{ name:"issueList", xtype:"net.nan21.dnet.module.pj.md.dc.IssueRoadmap$List"})	 
		.addDcFormView("issueInfo",{ name:"infoView", xtype:"net.nan21.dnet.module.pj.md.dc.Issue$View",height:200})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["issueFilter","issueList","infoView"] ,["north","center","south"])	
	 	.addToolbarTo("main","tlbIssueList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbIssueList", {dc:"issue"}).addQuery().addSeparator().addSeparator().addButtons([this._elems_.get("btnIssueUi") ]).addSeparator().addSeparator().addTitle({"text":"Roadmap"}).end(); 	
	}


	,onBtnIssueUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.Issues_UI";
				
		getApplication().showFrame(frame,{
	 		url:Dnet.buildUiPath(bundle, frame, false),  	 		 
	 		params: {
	 			code: this._getDc_("issue").getRecord().get("code")	 			
		    }, 				      
	 		callback: function (params) {	           
	          this._when_called_to_edit_(params);                                    
			} 				    
	  	});
		
		
	}					 	
});  
