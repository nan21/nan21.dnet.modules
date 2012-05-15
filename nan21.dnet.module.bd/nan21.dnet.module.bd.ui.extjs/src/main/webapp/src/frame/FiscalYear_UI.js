Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/FiscalYearDs", "nan21.dnet.module.bd.ui.extjs/dc/FiscalYear","nan21.dnet.module.bd.ui.extjs/ds/CalendarLovDs","nan21.dnet.module.bd.ui.extjs/lov/Calendars","nan21.dnet.module.bd.ui.extjs/ds/CalendarLovDs","nan21.dnet.module.bd.ui.extjs/lov/Calendars"]);

Ext.define("net.nan21.dnet.module.bd.tx.frame.FiscalYear_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.tx.frame.FiscalYear_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.tx.frame.FiscalYear_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("year", new net.nan21.dnet.module.bd.tx.dc.FiscalYear({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("year",{ name:"yearFilter", xtype:"net.nan21.dnet.module.bd.tx.dc.FiscalYear$Filter"})	 
		.addDcEditGridView("year",{ name:"yearEditList", xtype:"net.nan21.dnet.module.bd.tx.dc.FiscalYear$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["yearFilter","yearEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbYearList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbYearList", {dc:"year"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().end(); 	
	}

});  
