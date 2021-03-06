Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/PayrollElementDs", "nan21.dnet.module.hr.ui.extjs/dc/PayrollElement", "nan21.dnet.module.bd.ui.extjs/ds/ElementInputDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementInput", "nan21.dnet.module.bd.ui.extjs/ds/ElementFormulaDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementFormula","nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs","nan21.dnet.module.bd.ui.extjs/lov/Engines","nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementTypes","nan21.dnet.module.md.ui.extjs/ds/AccItemLovDs","nan21.dnet.module.md.ui.extjs/lov/AccItems","nan21.dnet.module.hr.ui.extjs/ds/PayrollElementSourceLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayrollElementsSource","nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs","nan21.dnet.module.bd.ui.extjs/lov/Engines","nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementTypes","nan21.dnet.module.bd.ui.extjs/ds/ElementLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementsCode"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("elem", new net.nan21.dnet.module.hr.payroll.dc.PayrollElement({}))
		.addDc("input", new net.nan21.dnet.module.bd.elem.dc.ElementInput({multiEdit:true}))
		.addDc("formula", new net.nan21.dnet.module.bd.elem.dc.ElementFormula({multiEdit:true}))		
		.linkDc("input", "elem",{fields:[ {childField:"elementId", parentField:"id"},{childField:"engineId", parentField:"engineId"} ]} )
		.linkDc("formula", "elem",{fetchMode:"auto",fields:[ {childField:"elementId", parentField:"id"},{childField:"engineId", parentField:"engineId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("elem",{ name:"elemFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Filter",height:120})	 
		.addDcGridView("elem",{ name:"elemList", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollElement$List"})	 
		.addDcFormView("elem",{ name:"elemEdit", xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Edit",height:170})	 
		.addDcEditGridView("input",{ name:"inputEditList", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementInput$CtxEditList", frame:true,title:"Input values"})	 
		.addDcEditGridView("formula",{ name:"formulaList", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementFormula$CtxEditList", frame:true,width:300})	 
		.addDcFormView("formula",{ name:"formulaEdit", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementFormula$EditExpression"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "formulaPanel", layout:"border", defaults:{split:true},title:"Formula"})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["elemFilter","elemList"] ,["north","center"])	
		.addChildrenTo("canvas2",["elemEdit","detailsTab"] ,["north","center"])	
	 	.addChildrenTo("detailsTab", ["inputEditList","formulaPanel"]) 				 		
		.addChildrenTo("formulaPanel",["formulaList","formulaEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbElemList")	  	
	 	.addToolbarTo("canvas2","tlbElemmEdit")	  	
	 	.addToolbarTo("inputEditList","tlbInputEditList")	  	
	 	.addToolbarTo("formulaPanel","tlbFormulaList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemList", {dc:"elem"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Elements"}).end()
			.beginToolbar("tlbElemmEdit", {dc:"elem"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Element"}).end()
			.beginToolbar("tlbInputEditList", {dc:"input"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Input values"}).end()
			.beginToolbar("tlbFormulaList", {dc:"formula"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Formula"}).end(); 	
	}

});  
