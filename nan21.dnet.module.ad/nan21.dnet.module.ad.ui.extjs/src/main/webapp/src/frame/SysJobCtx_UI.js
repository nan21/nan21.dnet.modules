Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/SysJobCtxDs", "nan21.dnet.module.ad.ui.extjs/dc/SysJobCtx", "nan21.dnet.module.ad.ui.extjs/ds/SysJobCtxParamDs", "nan21.dnet.module.ad.ui.extjs/dc/SysJobCtxParam", "nan21.dnet.module.ad.ui.extjs/ds/SysTimerDs", "nan21.dnet.module.ad.ui.extjs/dc/SysTimer","nan21.dnet.module.ad.ui.extjs/ds/SysJobLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysJob","nan21.dnet.module.ad.ui.extjs/ds/SysJobLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysJob"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysJobCtx_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.system.frame.SysJobCtx_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.system.frame.SysJobCtx_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("job", new net.nan21.dnet.module.ad.system.dc.SysJobCtx({multiEdit:true}))
		.addDc("params", new net.nan21.dnet.module.ad.system.dc.SysJobCtxParam({multiEdit:true}))
		.addDc("schedule", new net.nan21.dnet.module.ad.system.dc.SysTimer({}))		
		.linkDc("params", "job",{fields:[ {childField:"jobCtxId", parentField:"id"} ]} )
		.linkDc("schedule", "job",{fields:[ {childField:"jobCtxId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("job",{ name:"jobFilter", xtype:"net.nan21.dnet.module.ad.system.dc.SysJobCtx$Filter",height:80})	 
		.addDcEditGridView("job",{ name:"jobEditList", xtype:"net.nan21.dnet.module.ad.system.dc.SysJobCtx$EditList", frame:true})	 
		.addDcEditGridView("params",{ name:"paramsEditList", xtype:"net.nan21.dnet.module.ad.system.dc.SysJobCtxParam$CtxEditList", frame:true,title:"Parameter values"})	 
		.addDcGridView("schedule",{ name:"scheduleEditList", xtype:"net.nan21.dnet.module.ad.system.dc.SysTimer$CtxListJob",title:"Execution schedule"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "theDetails", layout:"accordion", activeItem:0, id:Ext.id(),width:600}) 	  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["jobFilter","jobEditList","theDetails"] ,["north","center","east"])	
	 	.addChildrenTo("theDetails", ["paramsEditList","scheduleEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbJobEditList")	  	
	 	.addToolbarTo("paramsEditList","tlbParamsEditList")	  	
	 	.addToolbarTo("scheduleEditList","tlbScheduleEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobEditList", {dc:"job"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().end()
			.beginToolbar("tlbParamsEditList", {dc:"params"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Parameter values"}).end()
			.beginToolbar("tlbScheduleEditList", {dc:"schedule"}).addQuery().addDeleteSelected().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Execution schedule"}).end(); 	
	}

});  
