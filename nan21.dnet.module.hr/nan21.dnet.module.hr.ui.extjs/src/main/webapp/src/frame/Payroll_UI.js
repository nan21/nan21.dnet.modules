Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/PayrollDs", "nan21.dnet.module.hr.ui.extjs/dc/Payroll", "nan21.dnet.module.hr.ui.extjs/ds/PayrollPeriodDs", "nan21.dnet.module.hr.ui.extjs/dc/PayrollPeriod"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.Payroll_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.payroll.frame.Payroll_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.Payroll_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("payroll", new net.nan21.dnet.module.hr.payroll.dc.Payroll({}))
		.addDc("period", new net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod({multiEdit:true}))		
		.linkDc("period", "payroll",{fields:[ {childField:"payrollId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("payroll",{ name:"payrollFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter",height:40})	 
		.addDcView("payroll",{ name:"payrollList", xtype:"net.nan21.dnet.module.hr.payroll.dc.Payroll$List"})	 
		.addDcFormView("payroll",{ name:"payrollEdit", xtype:"net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit",height:90})	 
		.addDcView("period",{ name:"periodCtxEditList", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["payrollFilter","payrollList"] ,["north","center"])	
		.addChildrenTo("canvas2",["payrollEdit","periodCtxEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbPayrollList")	  	
	 	.addToolbarTo("canvas2","tlbPayrollEdit")	  	
	 	.addToolbarTo("periodCtxEditList","tlbPeriodCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPayrollList", {dc:"payroll"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbPayrollEdit", {dc:"payroll"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbPeriodCtxEditList", {dc:"period"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}

});  
