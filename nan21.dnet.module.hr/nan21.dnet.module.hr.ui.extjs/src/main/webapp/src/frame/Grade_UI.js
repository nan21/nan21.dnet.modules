Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/GradeDs", "nan21.dnet.module.hr.ui.extjs/dc/Grade"]);

Ext.define("net.nan21.dnet.module.hr.grade.frame.Grade_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.grade.frame.Grade_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.grade.frame.Grade_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.hr.grade.dc.Grade({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.hr.grade.dc.Grade$Filter",height:120})	 
		.addDcEditGridView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.hr.grade.dc.Grade$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlb", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Grades"}).end(); 	
	}

});  
