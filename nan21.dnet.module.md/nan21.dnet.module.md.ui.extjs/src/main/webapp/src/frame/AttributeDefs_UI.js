Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/AttributeCategoryDs", "nan21.dnet.module.md.ui.extjs/dc/AttributeCategory", "nan21.dnet.module.md.ui.extjs/ds/AttributeTypeDs", "nan21.dnet.module.md.ui.extjs/dc/AttributeType", "nan21.dnet.module.md.ui.extjs/ds/AttributeDs", "nan21.dnet.module.md.ui.extjs/dc/Attribute", "nan21.dnet.module.md.ui.extjs/ds/AttributeGroupDs", "nan21.dnet.module.md.ui.extjs/dc/AttributeGroup", "nan21.dnet.module.md.ui.extjs/ds/AttributeGroupAttributeDs", "nan21.dnet.module.md.ui.extjs/dc/AttributeGroupAttribute", "nan21.dnet.module.md.ui.extjs/ds/AttributeGroupAttributeDs", "nan21.dnet.module.md.ui.extjs/dc/AttributeGroupAttribute","nan21.dnet.module.md.ui.extjs/ds/AttributeCategoryLovDs","nan21.dnet.module.md.ui.extjs/lov/AttributeCategory","nan21.dnet.module.md.ui.extjs/ds/AttributeTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/AttributeType","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.md.ui.extjs/ds/AttributeGroupLovDs","nan21.dnet.module.md.ui.extjs/lov/AttributeGroup","nan21.dnet.module.md.ui.extjs/ds/AttributeLovDs","nan21.dnet.module.md.ui.extjs/lov/Attribute","nan21.dnet.module.md.ui.extjs/ds/AttributeCategoryLovDs","nan21.dnet.module.md.ui.extjs/lov/AttributeCategory","nan21.dnet.module.md.ui.extjs/ds/AttributeTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/AttributeType","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode","nan21.dnet.module.md.ui.extjs/ds/AttributeLovDs","nan21.dnet.module.md.ui.extjs/lov/Attribute","nan21.dnet.module.md.ui.extjs/ds/AttributeGroupLovDs","nan21.dnet.module.md.ui.extjs/lov/AttributeGroup","nan21.dnet.module.md.ui.extjs/ds/AttributeLovDs","nan21.dnet.module.md.ui.extjs/lov/Attribute"]);

Ext.define("net.nan21.dnet.module.md.base.attr.frame.AttributeDefs_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.attr.frame.AttributeDefs_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.attr.frame.AttributeDefs_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("categ", new net.nan21.dnet.module.md.base.attr.dc.AttributeCategory({multiEdit:true}))
		.addDc("type", new net.nan21.dnet.module.md.base.attr.dc.AttributeType({multiEdit:true}))
		.addDc("attr", new net.nan21.dnet.module.md.base.attr.dc.Attribute({multiEdit:true}))
		.addDc("group", new net.nan21.dnet.module.md.base.attr.dc.AttributeGroup({multiEdit:true}))
		.addDc("grpattrctx", new net.nan21.dnet.module.md.base.attr.dc.AttributeGroupAttribute({multiEdit:true}))
		.addDc("grpattr", new net.nan21.dnet.module.md.base.attr.dc.AttributeGroupAttribute({multiEdit:true}))		
		.linkDc("grpattrctx", "group",{fields:[ {childField:"groupId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("categ",{ name:"categFilter", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeCategory$Filter",height:120})	 
		.addDcEditGridView("categ",{ name:"categEditList", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeCategory$EditList", frame:true})	 
		.addDcFilterFormView("type",{ name:"typeFilter", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeType$Filter",height:120})	 
		.addDcEditGridView("type",{ name:"typeEditList", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeType$EditList", frame:true})	 
		.addDcFilterFormView("attr",{ name:"attrFilter", xtype:"net.nan21.dnet.module.md.base.attr.dc.Attribute$Filter",height:120})	 
		.addDcEditGridView("attr",{ name:"attrEditList", xtype:"net.nan21.dnet.module.md.base.attr.dc.Attribute$EditList", frame:true})	 
		.addDcFilterFormView("group",{ name:"groupFilter", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeGroup$Filter",height:120})	 
		.addDcEditGridView("group",{ name:"groupEditList", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeGroup$EditList", frame:true})	 
		.addDcEditGridView("grpattrctx",{ name:"grpattrctxEditList", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeGroupAttribute$CtxEditList", frame:true,height:250})	 
		.addDcFilterFormView("grpattr",{ name:"grpattrFilter", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeGroupAttribute$Filter",height:120})	 
		.addDcEditGridView("grpattr",{ name:"grpattrEditList", xtype:"net.nan21.dnet.module.md.base.attr.dc.AttributeGroupAttribute$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasAttr", layout:"border", defaults:{split:true},title:"Attributes",preventHeader:true})  	 
		.addPanel({name: "canvasAttrGroup", layout:"border", defaults:{split:true},title:"Attribute groups",preventHeader:true})  	 
		.addPanel({name: "canvasGroupAttr", layout:"border", defaults:{split:true},title:"Group attributes",preventHeader:true})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Attribute types",preventHeader:true})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Attribute categories",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasAttr","canvasAttrGroup","canvasGroupAttr","canvasType","canvasCateg"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasAttr","canvasAttrGroup","canvasGroupAttr","canvasType","canvasCateg"]) 				 		
		.addChildrenTo("canvasAttr",["attrFilter","attrEditList"] ,["north","center"])	
		.addChildrenTo("canvasAttrGroup",["groupFilter","groupEditList","grpattrctxEditList"] ,["north","center","south"])	
		.addChildrenTo("canvasGroupAttr",["grpattrFilter","grpattrEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["typeFilter","typeEditList"] ,["north","center"])	
		.addChildrenTo("canvasCateg",["categFilter","categEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasAttr","tlbAttrEditList")	  	
	 	.addToolbarTo("canvasAttrGroup","tlbGroupEditList")	  	
	 	.addToolbarTo("grpattrctxEditList","tlbGroupAttrctxEditList")	  	
	 	.addToolbarTo("canvasGroupAttr","tlbGroupAttrEditList")	  	
	 	.addToolbarTo("canvasType","tlbTypeEditList")	  	
	 	.addToolbarTo("canvasCateg","tlbCategEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttrEditList", {dc:"attr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Attributes"}).end()
			.beginToolbar("tlbGroupEditList", {dc:"group"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Attribute groups"}).end()
			.beginToolbar("tlbGroupAttrctxEditList", {dc:"grpattrctx"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Group attributes"}).end()
			.beginToolbar("tlbGroupAttrEditList", {dc:"grpattr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Group attributes"}).end()
			.beginToolbar("tlbTypeEditList", {dc:"type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Attribute types"}).end()
			.beginToolbar("tlbCategEditList", {dc:"categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Attribute categories"}).end(); 	
	}

});  
