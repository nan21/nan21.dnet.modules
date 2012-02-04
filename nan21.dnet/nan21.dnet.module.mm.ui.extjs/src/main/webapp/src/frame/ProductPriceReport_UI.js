Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductPriceReportDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductPriceReport","nan21.dnet.module.mm.ui.extjs/ds/PriceListLovDs","nan21.dnet.module.mm.ui.extjs/lov/PriceList","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/PriceListVersionLovDs","nan21.dnet.module.mm.ui.extjs/lov/PriceListVersion","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories"]);

Ext.define("net.nan21.dnet.module.mm.price.frame.ProductPriceReport_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.price.frame.ProductPriceReport_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.price.frame.ProductPriceReport_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prodprice", new net.nan21.dnet.module.mm.price.dc.ProductPriceReport({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("prodprice",{ name:"prodpriceFilter", xtype:"net.nan21.dnet.module.mm.price.dc.ProductPriceReport$Filter",height:110})	 
		.addDcView("prodprice",{ name:"prodpriceList", xtype:"net.nan21.dnet.module.mm.price.dc.ProductPriceReport$List"})	 
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
			.beginToolbar("tlbProdpriceList", {dc:"prodprice"}).addQuery().end(); 	
	}

});  
