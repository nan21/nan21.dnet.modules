Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/ElementFormulaDs", "nan21.dnet.module.md.ui.extjs/dc/ElementFormula","nan21.dnet.module.md.ui.extjs/ds/ElementLovDs","nan21.dnet.module.md.ui.extjs/lov/ElementsCode","nan21.dnet.module.md.ui.extjs/ds/ElementLovDs","nan21.dnet.module.md.ui.extjs/lov/ElementsCode"]);

Ext.define("net.nan21.dnet.module.md.base.elem.frame.ElementFormulas_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.elem.frame.ElementFormulas_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.elem.frame.ElementFormulas_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("formula", new net.nan21.dnet.module.md.base.elem.dc.ElementFormula({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("formula",{ name:"formulaFilter", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementFormula$Filter",height:120})	 
		.addDcEditGridView("formula",{ name:"formulaList", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementFormula$EditList", frame:true})	 
		.addDcFormView("formula",{ name:"formulaEdit", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementFormula$EditExpression",width:350})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["formulaFilter","formulaList","formulaEdit"] ,["north","center","east"])	
	 	.addToolbarTo("canvas1","tlbInputList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInputList", {dc:"formula"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Element formulas"}).end(); 	
	}

});  
