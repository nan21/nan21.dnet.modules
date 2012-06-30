Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/AttributeDs", "nan21.dnet.module.bd.ui.extjs/dc/Attribute","nan21.dnet.module.bd.ui.extjs/ds/AttributeCategoryLovDs","nan21.dnet.module.bd.ui.extjs/lov/AttributeCategory","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/AttributeCategoryLovDs","nan21.dnet.module.bd.ui.extjs/lov/AttributeCategory","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode"]);

Ext.define("net.nan21.dnet.module.bd.attr.frame.Attributes_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.attr.frame.Attributes_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.attr.frame.Attributes_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("attr", new net.nan21.dnet.module.bd.attr.dc.Attribute({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("attr",{ name:"attrFilter", xtype:"net.nan21.dnet.module.bd.attr.dc.Attribute$Filter",height:80})	 
		.addDcEditGridView("attr",{ name:"attrEditList", xtype:"net.nan21.dnet.module.bd.attr.dc.Attribute$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasAttr", layout:"border", defaults:{split:true},title:"Attributes",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasAttr"]) 				 		
		.addChildrenTo("canvasAttr",["attrFilter","attrEditList"] ,["north","center"])	
	 	.addToolbarTo("canvasAttr","tlbAttrEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttrEditList", {dc:"attr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Attributes"}).end(); 	
	}

});  
