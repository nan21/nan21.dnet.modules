Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/FiscalYearDs", "nan21.dnet.module.md.ui.extjs/dc/FiscalYear", "nan21.dnet.module.md.ui.extjs/ds/FiscalPeriodDs", "nan21.dnet.module.md.ui.extjs/dc/FiscalPeriod","nan21.dnet.module.bd.ui.extjs/ds/CalendarLovDs","nan21.dnet.module.bd.ui.extjs/lov/Calendars","nan21.dnet.module.bd.ui.extjs/ds/CalendarLovDs","nan21.dnet.module.bd.ui.extjs/lov/Calendars"]);

Ext.define("net.nan21.dnet.module.md.base.period.frame.FiscalYear_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.period.frame.FiscalYear_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.period.frame.FiscalYear_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("year", new net.nan21.dnet.module.md.base.period.dc.FiscalYear({multiEdit:true}))
		.addDc("period", new net.nan21.dnet.module.md.base.period.dc.FiscalPeriod({multiEdit:true}))		
		.linkDc("period", "year",{fields:[ {childField:"yearId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("year",{ name:"yearFilter", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalYear$Filter"})	 
		.addDcEditGridView("year",{ name:"yearEditList", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalYear$EditList", frame:true})	 
		.addDcEditGridView("period",{ name:"periodEditList", xtype:"net.nan21.dnet.module.md.base.period.dc.FiscalPeriod$CtxEditList", frame:true,height:240})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["yearFilter","yearEditList","periodEditList"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbYearList")	  	
	 	.addToolbarTo("periodEditList","tlbPeriodList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbYearList", {dc:"year"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Fiscal years"}).end()
			.beginToolbar("tlbPeriodList", {dc:"period"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Periods"}).end(); 	
	}

});  
