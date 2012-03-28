Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/TaxDs", "nan21.dnet.module.bd.ui.extjs/dc/Tax","nan21.dnet.module.bd.ui.extjs/ds/TaxCategoryLovDs","nan21.dnet.module.bd.ui.extjs/lov/TaxCategories","nan21.dnet.module.bd.ui.extjs/ds/TaxLovDs","nan21.dnet.module.bd.ui.extjs/lov/Taxes","nan21.dnet.module.bd.ui.extjs/ds/TaxCategoryLovDs","nan21.dnet.module.bd.ui.extjs/lov/TaxCategories","nan21.dnet.module.bd.ui.extjs/ds/TaxLovDs","nan21.dnet.module.bd.ui.extjs/lov/Taxes"]);

Ext.define("net.nan21.dnet.module.bd.fin.frame.Tax_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.fin.frame.Tax_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.fin.frame.Tax_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("tax", new net.nan21.dnet.module.bd.fin.dc.Tax({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("tax",{ name:"taxFilter", xtype:"net.nan21.dnet.module.bd.fin.dc.Tax$Filter"})	 
		.addDcGridView("tax",{ name:"taxList", xtype:"net.nan21.dnet.module.bd.fin.dc.Tax$List"})	 
		.addDcFormView("tax",{ name:"taxEdit", xtype:"net.nan21.dnet.module.bd.fin.dc.Tax$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["taxFilter","taxList"] ,["north","center"])	
		.addChildrenTo("canvas2",["taxEdit"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbTaxList")	  	
	 	.addToolbarTo("canvas2","tlbTaxEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTaxList", {dc:"tax"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Taxes"}).end()
			.beginToolbar("tlbTaxEdit", {dc:"tax"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Tax"}).end(); 	
	}

});  
