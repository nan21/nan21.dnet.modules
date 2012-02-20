Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/OpportunityPriorityDs", "nan21.dnet.module.sd.ui.extjs/dc/OpportunityPriority", "nan21.dnet.module.sd.ui.extjs/ds/OpportunityStatusDs", "nan21.dnet.module.sd.ui.extjs/dc/OpportunityStatus", "nan21.dnet.module.sd.ui.extjs/ds/OpportunitySourceDs", "nan21.dnet.module.sd.ui.extjs/dc/OpportunitySource", "nan21.dnet.module.sd.ui.extjs/ds/OpportunityStageDs", "nan21.dnet.module.sd.ui.extjs/dc/OpportunityStage", "nan21.dnet.module.sd.ui.extjs/ds/OpportunityResultReasonDs", "nan21.dnet.module.sd.ui.extjs/dc/OpportunityResultReason"]);

Ext.define("net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("priority", new net.nan21.dnet.module.sd.opportunity.dc.OpportunityPriority({multiEdit:true}))
		.addDc("status", new net.nan21.dnet.module.sd.opportunity.dc.OpportunityStatus({multiEdit:true}))
		.addDc("source", new net.nan21.dnet.module.sd.opportunity.dc.OpportunitySource({multiEdit:true}))
		.addDc("stage", new net.nan21.dnet.module.sd.opportunity.dc.OpportunityStage({multiEdit:true}))
		.addDc("result", new net.nan21.dnet.module.sd.opportunity.dc.OpportunityResultReason({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("priority",{ name:"priorityFilter", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunityPriority$Filter",height:120})	 
		.addDcEditGridView("priority",{ name:"priorityEditList", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunityPriority$EditList", frame:true})	 
		.addDcFilterFormView("status",{ name:"statusFilter", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunityStatus$Filter",height:120})	 
		.addDcEditGridView("status",{ name:"statusEditList", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunityStatus$EditList", frame:true})	 
		.addDcFilterFormView("source",{ name:"sourceFilter", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunitySource$Filter",height:120})	 
		.addDcEditGridView("source",{ name:"sourceEditList", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunitySource$EditList", frame:true})	 
		.addDcFilterFormView("stage",{ name:"stageFilter", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunityStage$Filter",height:120})	 
		.addDcEditGridView("stage",{ name:"stageEditList", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunityStage$EditList", frame:true})	 
		.addDcFilterFormView("result",{ name:"resultFilter", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunityResultReason$Filter",height:120})	 
		.addDcEditGridView("result",{ name:"resultEditList", xtype:"net.nan21.dnet.module.sd.opportunity.dc.OpportunityResultReason$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasPriority", layout:"border", defaults:{split:true},title:"Priority",preventHeader:true})  	 
		.addPanel({name: "canvasStatus", layout:"border", defaults:{split:true},title:"Status",preventHeader:true})  	 
		.addPanel({name: "canvasSource", layout:"border", defaults:{split:true},title:"Lead source",preventHeader:true})  	 
		.addPanel({name: "canvasStage", layout:"border", defaults:{split:true},title:"Sales stage",preventHeader:true})  	 
		.addPanel({name: "canvasResult", layout:"border", defaults:{split:true},title:"Result reason",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasPriority","canvasStatus","canvasSource","canvasStage","canvasResult"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasPriority","canvasStatus","canvasSource","canvasStage","canvasResult"]) 				 		
		.addChildrenTo("canvasPriority",["priorityFilter","priorityEditList"] ,["north","center"])	
		.addChildrenTo("canvasStatus",["statusFilter","statusEditList"] ,["north","center"])	
		.addChildrenTo("canvasSource",["sourceFilter","sourceEditList"] ,["north","center"])	
		.addChildrenTo("canvasStage",["stageFilter","stageEditList"] ,["north","center"])	
		.addChildrenTo("canvasResult",["resultFilter","resultEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasPriority","tlbPriorityEditList")	  	
	 	.addToolbarTo("canvasStatus","tlbStatusEditList")	  	
	 	.addToolbarTo("canvasSource","tlbSourceEditList")	  	
	 	.addToolbarTo("canvasStage","tlbStageEditList")	  	
	 	.addToolbarTo("canvasResult","tlbResultEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPriorityEditList", {dc:"priority"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Priority"}).end()
			.beginToolbar("tlbStatusEditList", {dc:"status"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Status"}).end()
			.beginToolbar("tlbSourceEditList", {dc:"source"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Lead source"}).end()
			.beginToolbar("tlbStageEditList", {dc:"stage"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Sales stage"}).end()
			.beginToolbar("tlbResultEditList", {dc:"result"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Result reason"}).end(); 	
	}

});  
