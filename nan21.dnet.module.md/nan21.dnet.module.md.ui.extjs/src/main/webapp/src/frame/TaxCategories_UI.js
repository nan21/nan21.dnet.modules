Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/TaxCategoryDs", "nan21.dnet.module.md.ui.extjs/dc/TaxCategory"]);

Ext.define("net.nan21.dnet.module.md.base.tax.frame.TaxCategories_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.tax.frame.TaxCategories_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.tax.frame.TaxCategories_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("taxcateg", new net.nan21.dnet.module.md.base.tax.dc.TaxCategory({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("taxcateg",{ name:"taxcategFilter", xtype:"net.nan21.dnet.module.md.base.tax.dc.TaxCategory$Filter"})	 
		.addDcEditGridView("taxcateg",{ name:"taxcategEditList", xtype:"net.nan21.dnet.module.md.base.tax.dc.TaxCategory$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["taxcategFilter","taxcategEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbTaxcategEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTaxcategEditList", {dc:"taxcateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Tax categories"}).end(); 	
	}

});  
