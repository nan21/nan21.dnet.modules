Dnet.doImport(["", "nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryDs", "nan21.dnet.module.hr.ui.extjs/dc/ElementCategory", "nan21.dnet.module.hr.ui.extjs/ds/ElementTypeDs", "nan21.dnet.module.hr.ui.extjs/dc/ElementType", "nan21.dnet.module.hr.ui.extjs/ds/ElementDs", "nan21.dnet.module.hr.ui.extjs/dc/Element", "nan21.dnet.module.hr.ui.extjs/ds/VariableDs", "nan21.dnet.module.hr.ui.extjs/dc/Variable","nan21.dnet.module.hr.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementTypes","nan21.dnet.module.hr.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementTypes","nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementCategories","nan21.dnet.module.hr.ui.extjs/ds/ElementLovDs","nan21.dnet.module.hr.ui.extjs/lov/Elements","nan21.dnet.module.hr.ui.extjs/ds/ElementCategoryLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementCategories"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.Element_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.hr.payroll.frame.Element_UI",
	
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.Element_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("ecateg", new net.nan21.dnet.module.hr.payroll.dc.ElementCategory({multiEdit:true}))
		.addDc("etype", new net.nan21.dnet.module.hr.payroll.dc.ElementType({multiEdit:true}))
		.addDc("elems", new net.nan21.dnet.module.hr.payroll.dc.Element({}))
		.addDc("vars", new net.nan21.dnet.module.hr.payroll.dc.Variable({multiEdit:true}))		
		.linkDc("vars", "elems",{fields:[ {childField:"elementId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("elems",{ name:"exprFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$Filter",height:120})	 
		.addDcView("elems",{ name:"exprList", xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$List"})	 
		.addDcFormView("elems",{ name:"exprEdit", xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$Edit",height:120})	 
		.addDcView("vars",{ name:"varEditList", xtype:"net.nan21.dnet.module.hr.payroll.dc.Variable$CtxEditList", frame:true})	 
		.addDcFilterFormView("ecateg",{ name:"ecategFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementCategory$Filter",height:120})	 
		.addDcView("ecateg",{ name:"ecategEditList", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementCategory$EditList", frame:true})	 
		.addDcFilterFormView("etype",{ name:"etypeFilter", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementType$Filter",height:120})	 
		.addDcView("etype",{ name:"etypeEditList", xtype:"net.nan21.dnet.module.hr.payroll.dc.ElementType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasElems", layout:"border", defaults:{split:true},title:"Elements",preventHeader:true})  	 
		.addPanel({name: "canvasElemEdit", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Element categories",preventHeader:true})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Element types",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasElems","canvasType","canvasCateg"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasElems","canvasElemEdit","canvasType","canvasCateg"]) 				 		
		.addChildrenTo("canvasElems",["exprFilter","exprList"] ,["north","center"])	
		.addChildrenTo("canvasElemEdit",["exprEdit","varEditList"] ,["north","center"])	
		.addChildrenTo("canvasCateg",["ecategFilter","ecategEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["etypeFilter","etypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasElems","tlbExprList")	  	
	 	.addToolbarTo("canvasElemEdit","tlbExprEdit")	  	
	 	.addToolbarTo("varEditList","tlbVarEditList")	  	
	 	.addToolbarTo("canvasCateg","tlbEcategEditList")	  	
	 	.addToolbarTo("canvasType","tlbEtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbExprList", {dc:"elems"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Elements > List"}).end()
			.beginToolbar("tlbExprEdit", {dc:"elems"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Element"}).end()
			.beginToolbar("tlbVarEditList", {dc:"vars"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbEcategEditList", {dc:"ecateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Element categories"}).end()
			.beginToolbar("tlbEtypeEditList", {dc:"etype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Element types"}).end(); 	
	}

});  
