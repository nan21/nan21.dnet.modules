Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/PriceListDs", "nan21.dnet.module.mm.ui.extjs/dc/PriceList", "nan21.dnet.module.mm.ui.extjs/ds/ProductPriceDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductPrice","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode"]);

Ext.define("net.nan21.dnet.module.mm.price.frame.ProductPrice_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.price.frame.ProductPrice_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.price.frame.ProductPrice_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("pricelist", new net.nan21.dnet.module.mm.price.dc.PriceList({}))
		.addDc("price", new net.nan21.dnet.module.mm.price.dc.ProductPrice({multiEdit:true}))		
		.linkDc("price", "pricelist",{fields:[ {childField:"priceListVersionId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("pricelist",{ name:"pricelistFilter", xtype:"net.nan21.dnet.module.mm.price.dc.PriceList$FilterV",width:300})	 
		.addDcGridView("pricelist",{ name:"pricelistList", xtype:"net.nan21.dnet.module.mm.price.dc.PriceList$List"})	 
		.addDcFilterFormView("price",{ name:"priceFilter", xtype:"net.nan21.dnet.module.mm.price.dc.ProductPrice$Filter",width:300})	 
		.addDcEditGridView("price",{ name:"priceEditList", xtype:"net.nan21.dnet.module.mm.price.dc.ProductPrice$EditList", frame:true})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
		.addPanel({name: "pricePanel", layout:"border", defaults:{split:true},height:400})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["pricelistFilter","pricelistList","pricePanel"] ,["west","center","south"])	
		.addChildrenTo("pricePanel",["priceEditList","priceFilter"] ,["center","west"])	
	 	.addToolbarTo("main","tlbPricelistList")	  	
	 	.addToolbarTo("pricePanel","tlbPriceEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPricelistList", {dc:"pricelist"}).addQuery().addReports().end()
			.beginToolbar("tlbPriceEditList", {dc:"price"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().end(); 	
	}

});  
