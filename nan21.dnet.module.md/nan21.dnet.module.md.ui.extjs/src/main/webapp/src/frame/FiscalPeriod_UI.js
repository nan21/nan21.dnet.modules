Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/FiscalPeriodDs", "nan21.dnet.module.md.ui.extjs/dc/FiscalPeriod","nan21.dnet.module.md.ui.extjs/ds/FiscalYearLovDs","nan21.dnet.module.md.ui.extjs/lov/FiscalYears","nan21.dnet.module.md.ui.extjs/ds/FiscalYearLovDs","nan21.dnet.module.md.ui.extjs/lov/FiscalYears"]);

Ext.define("net.nan21.dnet.module.md.base.period.frame.FiscalPeriod_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.period.frame.FiscalPeriod_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.period.frame.FiscalPeriod_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("period", new net.nan21.dnet.module.md.base.period.dc.FiscalPeriod({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("period",{ name:"periodFilter", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$Filter"})	 
		.addDcEditGridView("period",{ name:"periodEditList", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["periodFilter","periodEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbPeriodList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPeriodList", {dc:"period"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Fiscal periods"}).end(); 	
	}

});  
