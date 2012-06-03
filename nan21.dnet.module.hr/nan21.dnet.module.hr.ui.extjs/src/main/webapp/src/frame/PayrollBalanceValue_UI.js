Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/PayrollBalanceValueDs", "nan21.dnet.module.hr.ui.extjs/dc/PayrollBalanceValue", "nan21.dnet.module.hr.ui.extjs/ds/PayrollElementValueDs", "nan21.dnet.module.hr.ui.extjs/dc/PayrollElementValue","nan21.dnet.module.hr.ui.extjs/ds/PayrollElementBalanceLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollElementsBalance","nan21.dnet.module.hr.ui.extjs/ds/PayrollElementSourceLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollElementsSource","nan21.dnet.module.md.ui.extjs/ds/AccItemLovDs","nan21.dnet.module.md.ui.extjs/lov/AccItems","nan21.dnet.module.hr.ui.extjs/ds/PayrollPeriodLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollPeriods","nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementTypes","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.PayrollBalanceValue_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.payroll.frame.PayrollBalanceValue_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.PayrollBalanceValue_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("elemval", new net.nan21.dnet.module.hr.payroll.dc.PayrollBalanceValue({}))
		.addDc("details", new net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue({}))		
		.linkDc("details", "elemval",{fields:[ {childField:"periodId", parentField:"periodId"},{childField:"elementId", parentField:"sourceElementId"},{childField:"employerId", parentField:"employerId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("elemval",{ name:"elemvalFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollBalanceValue$Filter",height:110})	 
		.addDcGridView("elemval",{ name:"elemvalList", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollBalanceValue$List"})	 
		.addDcGridView("details",{ name:"detailsList", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue$CtxListBalance",height:200})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["elemvalFilter","elemvalList","detailsList"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbElemvalList")	  	
	 	.addToolbarTo("detailsList","tlbDetailsList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemvalList", {dc:"elemval"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Payroll values : balances"}).end()
			.beginToolbar("tlbDetailsList", {dc:"details"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Details"}).end(); 	
	}

});  
