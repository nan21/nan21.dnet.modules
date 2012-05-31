Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/ProductAttributeDs", "nan21.dnet.module.md.ui.extjs/dc/ProductAttribute","nan21.dnet.module.md.ui.extjs/ds/ProductLovDs","nan21.dnet.module.md.ui.extjs/lov/Products","nan21.dnet.module.md.ui.extjs/ds/AttributeLovDs","nan21.dnet.module.md.ui.extjs/lov/Attribute","nan21.dnet.module.md.ui.extjs/ds/AttributeTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/AttributeType"]);

Ext.define("net.nan21.dnet.module.md.mm.prod.frame.ProductAttribute_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.mm.prod.frame.ProductAttribute_UI",
	
	 _name_ : "net.nan21.dnet.module.md.mm.prod.frame.ProductAttribute_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("attr", new net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("attr",{ name:"attrFilter", xtype:"net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute$Filter",height:120})	 
		.addDcEditGridView("attr",{ name:"attrEditList", xtype:"net.nan21.dnet.module.md.mm.prod.dc.ProductAttribute$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["attrFilter","attrEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbAttrEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttrEditList", {dc:"attr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Product attributes"}).end(); 	
	}

});  
