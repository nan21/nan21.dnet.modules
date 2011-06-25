Dnet.import(["", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyDs", "nan21.dnet.module.bd.ui.extjs/dc/Currency"]);

Ext.ns("net.nan21.dnet.module.bd.currency.frame");
net.nan21.dnet.module.bd.currency.frame.Currencies_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bd.currency.frame.Currencies_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("currency", new net.nan21.dnet.module.bd.currency.dc.Currency({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("currency",{ name:"currencyFilter", xtype:"net.nan21.dnet.module.bd.currency.dc.Currency$Filter"})	 
		.addDcView("currency",{ name:"currencyList", xtype:"net.nan21.dnet.module.bd.currency.dc.Currency$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["currencyFilter","currencyList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbMain")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMain", {dc:"currency"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.bd.currency.frame.Currencies_UI", net.nan21.dnet.module.bd.currency.frame.Currencies_UI);   
