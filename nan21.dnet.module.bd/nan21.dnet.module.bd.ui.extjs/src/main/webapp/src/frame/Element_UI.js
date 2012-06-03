Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/ElementDs", "nan21.dnet.module.bd.ui.extjs/dc/Element", "nan21.dnet.module.bd.ui.extjs/ds/ElementInputDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementInput", "nan21.dnet.module.bd.ui.extjs/ds/ElementFormulaDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementFormula","nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs","nan21.dnet.module.bd.ui.extjs/lov/Engines","nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementTypes","nan21.dnet.module.bd.ui.extjs/ds/ElementLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementsCode"]);

Ext.define("net.nan21.dnet.module.bd.elem.frame.Element_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.elem.frame.Element_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.elem.frame.Element_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("elem", new net.nan21.dnet.module.bd.elem.dc.Element({}))
		.addDc("input", new net.nan21.dnet.module.bd.elem.dc.ElementInput({}))
		.addDc("formula", new net.nan21.dnet.module.bd.elem.dc.ElementFormula({}))		
		.linkDc("input", "elem",{fetchMode:"auto",fields:[ {childField:"elementId", parentField:"id"} ]} )
		.linkDc("formula", "elem",{fetchMode:"auto",fields:[ {childField:"elementId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("elem",{ name:"elemFilter", xtype:"net.nan21.dnet.module.bd.elem.dc.Element$Filter",height:120})	 
		.addDcGridView("elem",{ name:"elemList", xtype:"net.nan21.dnet.module.bd.elem.dc.Element$List"})	 
		.addDcEditGridView("input",{ name:"inputList", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementInput$CtxEditList", frame:true,title:"Input values"})	 
		.addDcEditGridView("formula",{ name:"formulaList", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementFormula$CtxEditList", frame:true,width:300})	 
		.addDcFormView("formula",{ name:"formulaEdit", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementFormula$EditExpression"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "formulaPanel", layout:"border", defaults:{split:true},title:"Formula"})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["elemFilter","elemList","detailsTab"] ,["north","center","south"])	
	 	.addChildrenTo("detailsTab", ["inputList","formulaPanel"]) 				 		
		.addChildrenTo("formulaPanel",["formulaList","formulaEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbElemList")	  	
	 	.addToolbarTo("inputList","tlbInputList")	  	
	 	.addToolbarTo("formulaPanel","tlbFormulaList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemList", {dc:"elem"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Elements"}).end()
			.beginToolbar("tlbInputList", {dc:"input"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Input values"}).end()
			.beginToolbar("tlbFormulaList", {dc:"formula"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Formula"}).end(); 	
	}

});  
