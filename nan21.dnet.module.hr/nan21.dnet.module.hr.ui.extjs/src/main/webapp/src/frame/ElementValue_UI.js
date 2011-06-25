Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/ElementValueDs", "nan21.dnet.module.hr.ui.extjs/dc/ElementValue","nan21.dnet.module.hr.ui.extjs/ds/ElementLovDs","nan21.dnet.module.hr.ui.extjs/lov/Elements","nan21.dnet.module.hr.ui.extjs/ds/EmployeeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Employees","nan21.dnet.module.hr.ui.extjs/ds/PayrollPeriodLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollPeriods"]);

Ext.ns("net.nan21.dnet.module.hr.payroll.frame");
net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("expval", new net.nan21.dnet.module.hr.payroll.dc.ElementValue())		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("expval",{ name:"expvalFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementValue$Filter"})	 
		.addDcView("expval",{ name:"expvalList", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementValue$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["expvalFilter","expvalList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbExpvalList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbExpvalList", {dc:"expval"}).addLoad().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI", net.nan21.dnet.module.hr.payroll.frame.ElementValue_UI);   
