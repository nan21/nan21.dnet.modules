Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/PayrollElementDs", "nan21.dnet.module.hr.ui.extjs/dc/PayrollElement","nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs","nan21.dnet.module.bd.ui.extjs/lov/Engines","nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementTypes","nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs","nan21.dnet.module.bd.ui.extjs/lov/Engines","nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementTypes","nan21.dnet.module.hr.ui.extjs/ds/PayrollElementSourceLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollElementsSource","nan21.dnet.module.md.ui.extjs/ds/AccItemLovDs","nan21.dnet.module.md.ui.extjs/lov/AccItems"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.PayrollElements_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.payroll.frame.PayrollElements_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.PayrollElements_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("elem", new net.nan21.dnet.module.hr.payroll.dc.PayrollElement({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("elem",{ name:"elemFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Filter",height:120})	 
		.addDcEditGridView("elem",{ name:"elemList", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollElement$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["elemFilter","elemList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbElemList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemList", {dc:"elem"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Elements"}).end(); 	
	}

});  
