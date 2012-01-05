Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/JobTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/JobType", "nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/WorkRequirementType", "nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementDs", "nan21.dnet.module.hr.ui.extjs/dc/WorkRequirement","nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/WorkRequirementTypes","nan21.dnet.module.hr.ui.extjs/ds/WorkRequirementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/WorkRequirementTypes"]);

Ext.define("net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("jobType", new net.nan21.dnet.module.hr.job.dc.JobType({multiEdit:true}))
		.addDc("wrType", new net.nan21.dnet.module.hr.job.dc.WorkRequirementType({multiEdit:true}))
		.addDc("wr", new net.nan21.dnet.module.hr.job.dc.WorkRequirement({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("jobType",{ name:"jobTypeFilter", xtype:"net.nan21.dnet.module.hr.job.dc.JobType$Filter",height:120})	 
		.addDcView("jobType",{ name:"jobTypeEditList", xtype:"net.nan21.dnet.module.hr.job.dc.JobType$EditList", frame:true})	 
		.addDcFilterFormView("wrType",{ name:"wrTypeFilter", xtype:"net.nan21.dnet.module.hr.job.dc.WorkRequirementType$Filter",height:120})	 
		.addDcView("wrType",{ name:"wrTypeEditList", xtype:"net.nan21.dnet.module.hr.job.dc.WorkRequirementType$EditList", frame:true})	 
		.addDcFilterFormView("wr",{ name:"wrFilter", xtype:"net.nan21.dnet.module.hr.job.dc.WorkRequirement$Filter",height:120})	 
		.addDcView("wr",{ name:"wrEditList", xtype:"net.nan21.dnet.module.hr.job.dc.WorkRequirement$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasJobType", layout:"border", defaults:{split:true},title:"Job types",preventHeader:true})  	 
		.addPanel({name: "canvasWrType", layout:"border", defaults:{split:true},title:"Work requirement types",preventHeader:true})  	 
		.addPanel({name: "canvasWr", layout:"border", defaults:{split:true},title:"Work requirement",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasJobType","canvasWr","canvasWrType"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasJobType","canvasWr","canvasWrType"]) 				 		
		.addChildrenTo("canvasJobType",["jobTypeFilter","jobTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasWrType",["wrTypeFilter","wrTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasWr",["wrFilter","wrEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasJobType","tlbJobType")	  	
	 	.addToolbarTo("canvasWrType","tlbWrType")	  	
	 	.addToolbarTo("canvasWr","tlbWr")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobType", {dc:"jobType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Job types"}).end()
			.beginToolbar("tlbWrType", {dc:"wrType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Work requirement types"}).end()
			.beginToolbar("tlbWr", {dc:"wr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Work requirement"}).end(); 	
	}

});  
