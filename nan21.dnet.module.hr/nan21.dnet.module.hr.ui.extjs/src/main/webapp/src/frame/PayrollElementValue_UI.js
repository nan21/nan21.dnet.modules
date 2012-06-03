Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/PayrollElementValueDs", "nan21.dnet.module.hr.ui.extjs/dc/PayrollElementValue","nan21.dnet.module.bd.ui.extjs/ds/ElementSetLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementSets","nan21.dnet.module.hr.ui.extjs/ds/PayrollElementSourceLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollElementsSource","nan21.dnet.module.hr.ui.extjs/ds/EmployeeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Employees","nan21.dnet.module.hr.ui.extjs/ds/PayrollPeriodLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollPeriods","nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementTypes","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.PayrollElementValue_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.payroll.frame.PayrollElementValue_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.PayrollElementValue_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("elemval", new net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("elemval",{ name:"elemvalFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue$Filter",height:120})	 
		.addDcGridView("elemval",{ name:"elemvalList", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["elemvalFilter","elemvalList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbElemvalList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemvalList", {dc:"elemval"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Payroll values : elements"}).end(); 	
	}

});  
