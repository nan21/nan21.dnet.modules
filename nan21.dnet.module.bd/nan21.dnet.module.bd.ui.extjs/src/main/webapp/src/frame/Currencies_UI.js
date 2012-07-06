Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyDs", "nan21.dnet.module.bd.ui.extjs/dc/Currency"]);

Ext.define("net.nan21.dnet.module.bd.currency.frame.Currencies_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.currency.frame.Currencies_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.currency.frame.Currencies_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("currency", new net.nan21.dnet.module.bd.currency.dc.Currency({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("currency",{ name:"currencyFilter", xtype:"net.nan21.dnet.module.bd.currency.dc.Currency$Filter",height:80})	 
		.addDcEditGridView("currency",{ name:"currencyList", xtype:"net.nan21.dnet.module.bd.currency.dc.Currency$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["currencyFilter","currencyList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbMain")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMain", {dc:"currency"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Currencies"}).end(); 	
	}

});  
