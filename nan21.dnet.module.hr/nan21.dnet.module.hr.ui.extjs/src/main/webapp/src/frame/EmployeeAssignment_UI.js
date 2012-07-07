Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeAssignmentDs", "nan21.dnet.module.hr.ui.extjs/dc/EmployeeAssignment","nan21.dnet.module.hr.ui.extjs/ds/EmploymentTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/EmploymentTypes","nan21.dnet.module.hr.ui.extjs/ds/PositionLovDs","nan21.dnet.module.hr.ui.extjs/lov/Positions","nan21.dnet.module.hr.ui.extjs/ds/JobLovDs","nan21.dnet.module.hr.ui.extjs/lov/Jobs","nan21.dnet.module.hr.ui.extjs/ds/GradeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Grades","nan21.dnet.module.bd.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/Organizations","nan21.dnet.module.hr.ui.extjs/ds/PayrollLovDs","nan21.dnet.module.hr.ui.extjs/lov/Payrolls","nan21.dnet.module.hr.ui.extjs/ds/EmployeeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Employees","nan21.dnet.module.hr.ui.extjs/ds/EmployeeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Employees","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.hr.ui.extjs/ds/EmploymentTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/EmploymentTypes","nan21.dnet.module.hr.ui.extjs/ds/JobLovDs","nan21.dnet.module.hr.ui.extjs/lov/Jobs","nan21.dnet.module.hr.ui.extjs/ds/PositionLovDs","nan21.dnet.module.hr.ui.extjs/lov/Positions","nan21.dnet.module.hr.ui.extjs/ds/PayrollLovDs","nan21.dnet.module.hr.ui.extjs/lov/Payrolls"]);

Ext.define("net.nan21.dnet.module.hr.employee.frame.EmployeeAssignment_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.employee.frame.EmployeeAssignment_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.employee.frame.EmployeeAssignment_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("asgn", new net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("asgn",{ name:"asgnFilter", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$Filter"})	 
		.addDcGridView("asgn",{ name:"asgnList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$List"})	 
		.addDcGridView("asgn",{ name:"asgnCtxList", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$CtxList"})	 
		.addDcFormView("asgn",{ name:"asgnEdit", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$Edit"})	 
		.addDcFormView("asgn",{ name:"asgnEditEmployee", xtype:"net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$EditEmployee",height:50})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["asgnFilter","asgnList"] ,["north","center"])	
		.addChildrenTo("canvas2",["asgnEditEmployee","asgnEdit"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbAsgnList")	  	
	 	.addToolbarTo("canvas2","tlbAsgnEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAsgnList", {dc:"asgn"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Assignments"}).end()
			.beginToolbar("tlbAsgnEdit", {dc:"asgn"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Assignment"}).end(); 	
	}

});  
