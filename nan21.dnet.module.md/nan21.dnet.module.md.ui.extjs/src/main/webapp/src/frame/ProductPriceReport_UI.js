Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/ProductPriceReportDs", "nan21.dnet.module.md.ui.extjs/dc/ProductPriceReport","nan21.dnet.module.md.ui.extjs/ds/PriceListLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceList","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.md.ui.extjs/ds/PriceListVersionLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceListVersion","nan21.dnet.module.md.ui.extjs/ds/ProductLovDs","nan21.dnet.module.md.ui.extjs/lov/Products","nan21.dnet.module.md.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.md.ui.extjs/lov/ProductCategories"]);

Ext.define("net.nan21.dnet.module.md.mm.price.frame.ProductPriceReport_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.mm.price.frame.ProductPriceReport_UI",
	
	 _name_ : "net.nan21.dnet.module.md.mm.price.frame.ProductPriceReport_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prodprice", new net.nan21.dnet.module.md.mm.price.dc.ProductPriceReport({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("prodprice",{ name:"prodpriceFilter", xtype:"net.nan21.dnet.module.md.mm.price.dc.ProductPriceReport$Filter",height:110})	 
		.addDcGridView("prodprice",{ name:"prodpriceList", xtype:"net.nan21.dnet.module.md.mm.price.dc.ProductPriceReport$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["prodpriceFilter","prodpriceList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbProdpriceList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProdpriceList", {dc:"prodprice"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Price report"}).end(); 	
	}

});  
