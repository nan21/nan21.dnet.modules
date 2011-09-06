Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceDs", "nan21.dnet.module.hr.ui.extjs/dc/Absence","nan21.dnet.module.hr.ui.extjs/ds/EmployeeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Employees","nan21.dnet.module.hr.ui.extjs/ds/AbsenceTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/AbsenceTypes","nan21.dnet.module.hr.ui.extjs/ds/AbsenceReasonLovDs","nan21.dnet.module.hr.ui.extjs/lov/AbsenceReasons","nan21.dnet.module.hr.ui.extjs/ds/EmployeeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Employees","nan21.dnet.module.hr.ui.extjs/ds/AbsenceTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/AbsenceTypes","nan21.dnet.module.hr.ui.extjs/ds/AbsenceReasonLovDs","nan21.dnet.module.hr.ui.extjs/lov/AbsenceReasons"]);

Ext.ns("net.nan21.dnet.module.hr.time.frame");
net.nan21.dnet.module.hr.time.frame.Absence_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.time.frame.Absence_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("absence", new net.nan21.dnet.module.hr.time.dc.Absence())		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("absence",{ name:"absenceFilter", xtype:"net.nan21.dnet.module.hr.time.dc.Absence$Filter"})	 
		.addDcView("absence",{ name:"absenceList", xtype:"net.nan21.dnet.module.hr.time.dc.Absence$List"})	 
		.addDcFormView("absence",{ name:"absenceEdit", xtype:"net.nan21.dnet.module.hr.time.dc.Absence$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},header:false})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["absenceFilter","absenceList"] ,["north","center"])	
		.addChildrenTo("canvas2",["absenceEdit"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbAbsenceList")	  	
	 	.addToolbarTo("canvas2","tlbAbsenceEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAbsenceList", {dc:"absence"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbAbsenceEdit", {dc:"absence"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.hr.time.frame.Absence_UI", net.nan21.dnet.module.hr.time.frame.Absence_UI);   
