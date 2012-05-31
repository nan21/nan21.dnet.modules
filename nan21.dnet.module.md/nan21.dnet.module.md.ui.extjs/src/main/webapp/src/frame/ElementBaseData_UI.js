Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/ElementCategoryDs", "nan21.dnet.module.md.ui.extjs/dc/ElementCategory", "nan21.dnet.module.md.ui.extjs/ds/ElementTypeDs", "nan21.dnet.module.md.ui.extjs/dc/ElementType","nan21.dnet.module.md.ui.extjs/ds/ElementCategoryLovDs","nan21.dnet.module.md.ui.extjs/lov/ElementCategories","nan21.dnet.module.md.ui.extjs/ds/ElementCategoryLovDs","nan21.dnet.module.md.ui.extjs/lov/ElementCategories"]);

Ext.define("net.nan21.dnet.module.md.base.elem.frame.ElementBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.elem.frame.ElementBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.elem.frame.ElementBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("ecateg", new net.nan21.dnet.module.md.base.elem.dc.ElementCategory({multiEdit:true}))
		.addDc("etype", new net.nan21.dnet.module.md.base.elem.dc.ElementType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("ecateg",{ name:"ecategFilter", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementCategory$Filter",height:80})	 
		.addDcEditGridView("ecateg",{ name:"ecategEditList", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementCategory$EditList", frame:true})	 
		.addDcFilterFormView("etype",{ name:"etypeFilter", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementType$Filter",height:80})	 
		.addDcEditGridView("etype",{ name:"etypeEditList", xtype:"net.nan21.dnet.module.md.base.elem.dc.ElementType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Categories",preventHeader:true})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Types",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasType","canvasCateg"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasType","canvasCateg"]) 				 		
		.addChildrenTo("canvasCateg",["ecategFilter","ecategEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["etypeFilter","etypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCateg","tlbEcategEditList")	  	
	 	.addToolbarTo("canvasType","tlbEtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbEcategEditList", {dc:"ecateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Categories"}).end()
			.beginToolbar("tlbEtypeEditList", {dc:"etype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Types"}).end(); 	
	}

});  
