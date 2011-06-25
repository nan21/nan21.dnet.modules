Dnet.import(["", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateProviderDs", "nan21.dnet.module.bd.ui.extjs/dc/CurrencyXRateProvider"]);

Ext.ns("net.nan21.dnet.module.bd.currency.frame");
net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prvd", new net.nan21.dnet.module.bd.currency.dc.CurrencyXRateProvider({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("prvd",{ name:"prvdFilter", xtype:"net.nan21.dnet.module.bd.currency.dc.CurrencyXRateProvider$Filter"})	 
		.addDcView("prvd",{ name:"prvdEditList", xtype:"net.nan21.dnet.module.bd.currency.dc.CurrencyXRateProvider$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["prvdFilter","prvdEditList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbMain")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMain", {dc:"prvd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI", net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI);   
