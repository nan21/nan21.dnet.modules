Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeCategoryDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeCategory", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeType", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttribute", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeGroup", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupAttributeDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeGroupAttribute","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeCategory","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeType","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeCategory","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeType","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttribute"]);

Ext.define("net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("categ", new net.nan21.dnet.module.mm.md.dc.ProductAttributeCategory({multiEdit:true}))
		.addDc("type", new net.nan21.dnet.module.mm.md.dc.ProductAttributeType({multiEdit:true}))
		.addDc("attr", new net.nan21.dnet.module.mm.md.dc.ProductAttribute({multiEdit:true}))
		.addDc("group", new net.nan21.dnet.module.mm.md.dc.ProductAttributeGroup({multiEdit:true}))
		.addDc("grpattr", new net.nan21.dnet.module.mm.md.dc.ProductAttributeGroupAttribute({multiEdit:true}))		
		.linkDc("grpattr", "group",{fields:[ {childField:"groupId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("categ",{ name:"categFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeCategory$Filter",height:40})	 
		.addDcView("categ",{ name:"categEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeCategory$EditList", frame:true})	 
		.addDcFilterFormView("type",{ name:"typeFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeType$Filter",height:80})	 
		.addDcView("type",{ name:"typeEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeType$EditList", frame:true})	 
		.addDcFilterFormView("attr",{ name:"attrFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttribute$Filter",height:80})	 
		.addDcView("attr",{ name:"attrEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttribute$EditList", frame:true})	 
		.addDcFilterFormView("group",{ name:"groupFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeGroup$Filter",height:40})	 
		.addDcView("group",{ name:"groupEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeGroup$EditList", frame:true})	 
		.addDcView("grpattr",{ name:"grpattrEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeGroupAttribute$CEditList", frame:true,height:250})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasAttr", layout:"border", defaults:{split:true},title:"Attributes",preventHeader:true})  	 
		.addPanel({name: "canvasAttrGroup", layout:"border", defaults:{split:true},title:"Attribute groups",preventHeader:true})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Attribute types",preventHeader:true})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Attribute categories",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasAttr","canvasAttrGroup","canvasType","canvasCateg"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasAttr","canvasAttrGroup","canvasType","canvasCateg"]) 				 		
		.addChildrenTo("canvasAttr",["attrFilter","attrEditList"] ,["north","center"])	
		.addChildrenTo("canvasAttrGroup",["groupFilter","groupEditList","grpattrEditList"] ,["north","center","south"])	
		.addChildrenTo("canvasType",["typeFilter","typeEditList"] ,["north","center"])	
		.addChildrenTo("canvasCateg",["categFilter","categEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasAttr","tlbAttrEditList")	  	
	 	.addToolbarTo("canvasAttrGroup","tlbGroupEditList")	  	
	 	.addToolbarTo("grpattrEditList","tlbGroupAttrEditList")	  	
	 	.addToolbarTo("canvasType","tlbTypeEditList")	  	
	 	.addToolbarTo("canvasCateg","tlbCategEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttrEditList", {dc:"attr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Attributes"}).end()
			.beginToolbar("tlbGroupEditList", {dc:"group"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Attribute groups"}).end()
			.beginToolbar("tlbGroupAttrEditList", {dc:"grpattr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbTypeEditList", {dc:"type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Attribute types"}).end()
			.beginToolbar("tlbCategEditList", {dc:"categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Attribute categories"}).end(); 	
	}

});  
