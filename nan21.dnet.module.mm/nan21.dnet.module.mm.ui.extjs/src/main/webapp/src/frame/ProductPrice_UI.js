Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductPriceDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductPrice"]);

Ext.define("net.nan21.dnet.module.mm.price.frame.ProductPrice_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.price.frame.ProductPrice_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.price.frame.ProductPrice_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("price", new net.nan21.dnet.module.mm.price.dc.ProductPrice({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("price",{ name:"priceFilter", xtype:"net.nan21.dnet.module.mm.price.dc.ProductPrice$Filter"})	 
		.addDcView("price",{ name:"priceEditList", xtype:"net.nan21.dnet.module.mm.price.dc.ProductPrice$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasPrice", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasPrice"]) 				 		
		.addChildrenTo("canvasPrice",["priceFilter","priceEditList"] ,["north","center"])	
	 	.addToolbarTo("canvasPrice","tlbPriceEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPriceEditList", {dc:"price"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});  
