Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectVersion","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects","nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs","nan21.dnet.module.pj.ui.extjs/lov/Projects"]);

Ext.define("net.nan21.dnet.module.pj.base.frame.ProjectVersions_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.base.frame.ProjectVersions_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.base.frame.ProjectVersions_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("version", new net.nan21.dnet.module.pj.md.dc.ProjectVersion({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnRoadmapUi",text:"Roadmap", tooltip:"Show roadmap for selected version",disabled:true
			,handler: this.onBtnRoadmapUi,scope:this,stateManager:{name:"selected_one", dc:"version" }	})	
							 	
		.addButton({name:"btnChangelogUi",text:"Changelog", tooltip:"Show Changelog for selected version",disabled:true
			,handler: this.onBtnChangelogUi,scope:this,stateManager:{name:"selected_one", dc:"version" }	})	
							 	
		.addDcFilterFormView("version",{ name:"versionFilter", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectVersion$Filter"})	 
		.addDcEditGridView("version",{ name:"versionEditList", xtype:"net.nan21.dnet.module.pj.md.dc.ProjectVersion$EditList", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnRoadmapUi") ,this._elems_.get("btnChangelogUi") ]}]})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["versionFilter","versionEditList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbVersionEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbVersionEditList", {dc:"version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Project versions"}).end(); 	
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
});  
