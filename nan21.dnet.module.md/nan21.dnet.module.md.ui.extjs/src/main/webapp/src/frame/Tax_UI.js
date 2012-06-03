Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/TaxDs", "nan21.dnet.module.md.ui.extjs/dc/Tax", "nan21.dnet.module.md.ui.extjs/ds/TaxAcctDs", "nan21.dnet.module.md.ui.extjs/dc/TaxAcct","nan21.dnet.module.md.ui.extjs/ds/TaxCategoryLovDs","nan21.dnet.module.md.ui.extjs/lov/TaxCategories","nan21.dnet.module.md.ui.extjs/ds/TaxLovDs","nan21.dnet.module.md.ui.extjs/lov/Taxes","nan21.dnet.module.md.ui.extjs/ds/TaxCategoryLovDs","nan21.dnet.module.md.ui.extjs/lov/TaxCategories","nan21.dnet.module.md.ui.extjs/ds/TaxLovDs","nan21.dnet.module.md.ui.extjs/lov/Taxes","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts"]);

Ext.define("net.nan21.dnet.module.md.base.tax.frame.Tax_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.base.tax.frame.Tax_UI",
	
	 _name_ : "net.nan21.dnet.module.md.base.tax.frame.Tax_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("tax", new net.nan21.dnet.module.md.base.tax.dc.Tax({}))
		.addDc("acct", new net.nan21.dnet.module.md.base.tax.dc.TaxAcct({multiEdit:true}))		
		.linkDc("acct", "tax",{fields:[ {childField:"taxId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("tax",{ name:"taxFilter", xtype:"net.nan21.dnet.module.md.base.tax.dc.Tax$Filter",height:120})	 
		.addDcGridView("tax",{ name:"taxList", xtype:"net.nan21.dnet.module.md.base.tax.dc.Tax$List"})	 
		.addDcFormView("tax",{ name:"taxEdit", xtype:"net.nan21.dnet.module.md.base.tax.dc.Tax$Edit",height:140})	 
		.addDcEditGridView("acct",{ name:"acctList", xtype:"net.nan21.dnet.module.md.base.tax.dc.TaxAcct$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["taxFilter","taxList"] ,["north","center"])	
		.addChildrenTo("canvas2",["taxEdit","acctList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbTaxList")	  	
	 	.addToolbarTo("canvas2","tlbTaxEdit")	  	
	 	.addToolbarTo("acctList","tlbAcctList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTaxList", {dc:"tax"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Taxes"}).end()
			.beginToolbar("tlbTaxEdit", {dc:"tax"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Tax"}).end()
			.beginToolbar("tlbAcctList", {dc:"acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end(); 	
	}

});  
