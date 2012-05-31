Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/ElementInputDs", "nan21.dnet.module.md.ui.extjs/dc/ElementInput","nan21.dnet.module.md.ui.extjs/ds/ElementLovDs","nan21.dnet.module.md.ui.extjs/lov/ElementsCode","nan21.dnet.module.md.ui.extjs/ds/ElementLovDs","nan21.dnet.module.md.ui.extjs/lov/ElementsCode","nan21.dnet.module.md.ui.extjs/ds/ElementLovDs","nan21.dnet.module.md.ui.extjs/lov/ElementsCode","nan21.dnet.module.md.ui.extjs/ds/ElementLovDs","nan21.dnet.module.md.ui.extjs/lov/ElementsCode"]);

Ext.define("net.nan21.dnet.module.md.base.elem.frame.ElementInputs_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.elem.frame.ElementInputs_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.elem.frame.ElementInputs_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("input", new net.nan21.dnet.module.md.base.elem.dc.ElementInput({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("input",{ name:"inputFilter", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementInput$Filter",height:120})	 
		.addDcEditGridView("input",{ name:"inputList", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementInput$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["inputFilter","inputList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbInputList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInputList", {dc:"input"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Element inputs"}).end(); 	
	}

});  
