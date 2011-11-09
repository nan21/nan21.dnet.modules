Dnet.doImport(["", "nan21.dnet.module.pj.ui.extjs/ds/ItemCategoryDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemCategory", "nan21.dnet.module.pj.ui.extjs/ds/ItemTypeDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemType", "nan21.dnet.module.pj.ui.extjs/ds/ItemStatusDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemStatus", "nan21.dnet.module.pj.ui.extjs/ds/ItemPriorityDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemPriority", "nan21.dnet.module.pj.ui.extjs/ds/ItemSeverityDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemSeverity", "nan21.dnet.module.pj.ui.extjs/ds/ItemResolutionDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemResolution", "nan21.dnet.module.pj.ui.extjs/ds/ItemLinkTypeDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemLinkType", "nan21.dnet.module.pj.ui.extjs/ds/ItemTaskTypeDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemTaskType", "nan21.dnet.module.pj.ui.extjs/ds/ItemTaskStatusDs", "nan21.dnet.module.pj.ui.extjs/dc/ItemTaskStatus","nan21.dnet.module.pj.ui.extjs/ds/ItemCategoryLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemCategories","nan21.dnet.module.pj.ui.extjs/ds/ItemCategoryLovDs","nan21.dnet.module.pj.ui.extjs/lov/ItemCategories"]);

Ext.define("net.nan21.dnet.module.pj.base.frame.ItemBaseData_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.pj.base.frame.ItemBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.pj.base.frame.ItemBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("categ", new net.nan21.dnet.module.pj.base.dc.ItemCategory({multiEdit:true}))
		.addDc("type", new net.nan21.dnet.module.pj.base.dc.ItemType({multiEdit:true}))
		.addDc("status", new net.nan21.dnet.module.pj.base.dc.ItemStatus({multiEdit:true}))
		.addDc("priority", new net.nan21.dnet.module.pj.base.dc.ItemPriority({multiEdit:true}))
		.addDc("severity", new net.nan21.dnet.module.pj.base.dc.ItemSeverity({multiEdit:true}))
		.addDc("resolution", new net.nan21.dnet.module.pj.base.dc.ItemResolution({multiEdit:true}))
		.addDc("linktype", new net.nan21.dnet.module.pj.base.dc.ItemLinkType({multiEdit:true}))
		.addDc("tasktype", new net.nan21.dnet.module.pj.base.dc.ItemTaskType({multiEdit:true}))
		.addDc("taskstatus", new net.nan21.dnet.module.pj.base.dc.ItemTaskStatus({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("categ",{ name:"categFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemCategory$Filter",height:40})	 
		.addDcView("categ",{ name:"categEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemCategory$EditList", frame:true})	 
		.addDcFilterFormView("type",{ name:"typeFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemType$Filter",height:40})	 
		.addDcView("type",{ name:"typeEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemType$EditList", frame:true})	 
		.addDcFilterFormView("status",{ name:"statusFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemStatus$Filter",height:40})	 
		.addDcView("status",{ name:"statusEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemStatus$EditList", frame:true})	 
		.addDcFilterFormView("priority",{ name:"priorityFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemPriority$Filter",height:40})	 
		.addDcView("priority",{ name:"priorityEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemPriority$EditList", frame:true})	 
		.addDcFilterFormView("severity",{ name:"severityFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemSeverity$Filter",height:40})	 
		.addDcView("severity",{ name:"severityEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemSeverity$EditList", frame:true})	 
		.addDcFilterFormView("resolution",{ name:"resolutionFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemResolution$Filter",height:40})	 
		.addDcView("resolution",{ name:"resolutionEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemResolution$EditList", frame:true})	 
		.addDcFilterFormView("linktype",{ name:"linktypeFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemLinkType$Filter",height:40})	 
		.addDcView("linktype",{ name:"linktypeEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemLinkType$EditList", frame:true})	 
		.addDcFilterFormView("tasktype",{ name:"tasktypeFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemTaskType$Filter",height:40})	 
		.addDcView("tasktype",{ name:"tasktypeEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemTaskType$EditList", frame:true})	 
		.addDcFilterFormView("taskstatus",{ name:"taskstatusFilter", xtype:"net.nan21.dnet.module.pj.base.dc.ItemTaskStatus$Filter",height:40})	 
		.addDcView("taskstatus",{ name:"taskstatusEditList", xtype:"net.nan21.dnet.module.pj.base.dc.ItemTaskStatus$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCategory", layout:"border", defaults:{split:true},title:"Issue category",preventHeader:true})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Issue type",preventHeader:true})  	 
		.addPanel({name: "canvasStatus", layout:"border", defaults:{split:true},title:"Issue status",preventHeader:true})  	 
		.addPanel({name: "canvasPriority", layout:"border", defaults:{split:true},title:"Issue priority",preventHeader:true})  	 
		.addPanel({name: "canvasSeverity", layout:"border", defaults:{split:true},title:"Issue severity",preventHeader:true})  	 
		.addPanel({name: "canvasResolution", layout:"border", defaults:{split:true},title:"Issue resolution",preventHeader:true})  	 
		.addPanel({name: "canvasLinktype", layout:"border", defaults:{split:true},title:"Issue link type",preventHeader:true})  	 
		.addPanel({name: "canvasTasktype", layout:"border", defaults:{split:true},title:"Task type",preventHeader:true})  	 
		.addPanel({name: "canvasTaskstatus", layout:"border", defaults:{split:true},title:"Task status",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasCategory","canvasType","canvasStatus","canvasPriority","canvasSeverity","canvasResolution","canvasLinktype","canvasTasktype","canvasTaskstatus"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCategory","canvasType","canvasStatus","canvasPriority","canvasSeverity","canvasResolution","canvasLinktype","canvasTasktype","canvasTaskstatus"]) 				 		
		.addChildrenTo("canvasCategory",["categFilter","categEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["typeFilter","typeEditList"] ,["north","center"])	
		.addChildrenTo("canvasStatus",["statusFilter","statusEditList"] ,["north","center"])	
		.addChildrenTo("canvasPriority",["priorityFilter","priorityEditList"] ,["north","center"])	
		.addChildrenTo("canvasSeverity",["severityFilter","severityEditList"] ,["north","center"])	
		.addChildrenTo("canvasResolution",["resolutionFilter","resolutionEditList"] ,["north","center"])	
		.addChildrenTo("canvasLinktype",["linktypeFilter","linktypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasTasktype",["tasktypeFilter","tasktypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasTaskstatus",["taskstatusFilter","taskstatusEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCategory","tlbCategEditList")	  	
	 	.addToolbarTo("canvasType","tlbTypeEditList")	  	
	 	.addToolbarTo("canvasStatus","tlbStatusEditList")	  	
	 	.addToolbarTo("canvasPriority","tlbPriorityEditList")	  	
	 	.addToolbarTo("canvasSeverity","tlbSeverityEditList")	  	
	 	.addToolbarTo("canvasResolution","tlbResolutionEditList")	  	
	 	.addToolbarTo("canvasLinktype","tlbLinktypeEditList")	  	
	 	.addToolbarTo("canvasTasktype","tlbTasktypeEditList")	  	
	 	.addToolbarTo("canvasTaskstatus","tlbTaskstatusEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCategEditList", {dc:"categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Issue category"}).end()
			.beginToolbar("tlbTypeEditList", {dc:"type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Issue type"}).end()
			.beginToolbar("tlbStatusEditList", {dc:"status"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Issue status"}).end()
			.beginToolbar("tlbPriorityEditList", {dc:"priority"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Issue priority"}).end()
			.beginToolbar("tlbSeverityEditList", {dc:"severity"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Issue severity"}).end()
			.beginToolbar("tlbResolutionEditList", {dc:"resolution"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Issue resolution"}).end()
			.beginToolbar("tlbLinktypeEditList", {dc:"linktype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Issue link type"}).end()
			.beginToolbar("tlbTasktypeEditList", {dc:"tasktype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Task type"}).end()
			.beginToolbar("tlbTaskstatusEditList", {dc:"taskstatus"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Task status"}).end(); 	
	}

});  
