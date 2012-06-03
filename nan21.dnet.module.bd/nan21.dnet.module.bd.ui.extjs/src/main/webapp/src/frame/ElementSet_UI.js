Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/ElementSetDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementSet", "nan21.dnet.module.bd.ui.extjs/ds/ElementSetElementDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementSetElement","nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs","nan21.dnet.module.bd.ui.extjs/lov/Engines","nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs","nan21.dnet.module.bd.ui.extjs/lov/Engines","nan21.dnet.module.bd.ui.extjs/ds/ElementLovDs","nan21.dnet.module.bd.ui.extjs/lov/ElementsCode"]);

Ext.define("net.nan21.dnet.module.bd.elem.frame.ElementSet_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.elem.frame.ElementSet_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.elem.frame.ElementSet_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("set", new net.nan21.dnet.module.bd.elem.dc.ElementSet({multiEdit:true}))
		.addDc("elem", new net.nan21.dnet.module.bd.elem.dc.ElementSetElement({multiEdit:true}))		
		.linkDc("elem", "set",{fields:[ {childField:"elementSetId", parentField:"id"},{childField:"engineId", parentField:"engineId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("set",{ name:"setFilter", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementSet$Filter",height:80})	 
		.addDcEditGridView("set",{ name:"setEditList", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementSet$EditList", frame:true})	 
		.addDcEditGridView("elem",{ name:"elemCtxEditList", xtype:"net.nan21.dnet.module.bd.elem.dc.ElementSetElement$CtxEditList", frame:true,height:220})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["setFilter","setEditList","elemCtxEditList"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbSetEditList")	  	
	 	.addToolbarTo("elemCtxEditList","tlbElemCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSetEditList", {dc:"set"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Sets"}).end()
			.beginToolbar("tlbElemCtxEditList", {dc:"elem"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Elements"}).end(); 	
	}

});  
