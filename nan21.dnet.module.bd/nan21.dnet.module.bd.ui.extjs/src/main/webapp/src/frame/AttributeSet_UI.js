Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/AttributeSetDs", "nan21.dnet.module.bd.ui.extjs/dc/AttributeSet", "nan21.dnet.module.bd.ui.extjs/ds/AttributeSetAttributeDs", "nan21.dnet.module.bd.ui.extjs/dc/AttributeSetAttribute","nan21.dnet.module.bd.ui.extjs/ds/AttributeLovDs","nan21.dnet.module.bd.ui.extjs/lov/Attribute"]);

Ext.define("net.nan21.dnet.module.bd.attr.frame.AttributeSet_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.attr.frame.AttributeSet_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.attr.frame.AttributeSet_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("set", new net.nan21.dnet.module.bd.attr.dc.AttributeSet({multiEdit:true}))
		.addDc("setattr", new net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute({multiEdit:true}))		
		.linkDc("setattr", "set",{fields:[ {childField:"setId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("set",{ name:"setFilter", xtype:"net.nan21.dnet.module.bd.attr.dc.AttributeSet$Filter",height:80})	 
		.addDcEditGridView("set",{ name:"setEditList", xtype:"net.nan21.dnet.module.bd.attr.dc.AttributeSet$EditList", frame:true})	 
		.addDcEditGridView("setattr",{ name:"setattrEditList", xtype:"net.nan21.dnet.module.bd.attr.dc.AttributeSetAttribute$CtxEditList", frame:true,height:220})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasAttrSet", layout:"border", defaults:{split:true},title:"Attribute sets",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasAttrSet"]) 				 		
		.addChildrenTo("canvasAttrSet",["setFilter","setEditList","setattrEditList"] ,["north","center","south"])	
	 	.addToolbarTo("canvasAttrSet","tlbSetEditList")	  	
	 	.addToolbarTo("setattrEditList","tlbSetAttrEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSetEditList", {dc:"set"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Attribute sets"}).end()
			.beginToolbar("tlbSetAttrEditList", {dc:"setattr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Set attributes"}).end(); 	
	}

});  
