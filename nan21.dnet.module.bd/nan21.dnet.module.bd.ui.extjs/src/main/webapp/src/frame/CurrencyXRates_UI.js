Dnet.import(["", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateDs", "nan21.dnet.module.bd.ui.extjs/dc/CurrencyXRate","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateProviderLovDs","nan21.dnet.module.bd.ui.extjs/lov/CurrencyXRateProviders","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateProviderLovDs","nan21.dnet.module.bd.ui.extjs/lov/CurrencyXRateProviders"]);

Ext.ns("net.nan21.dnet.module.bd.currency.frame");
net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("xrate", new net.nan21.dnet.module.bd.currency.dc.CurrencyXRate({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("xrate",{ name:"xrateFilter", xtype:"net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter"})	 
		.addDcView("xrate",{ name:"xrateEditList", xtype:"net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["xrateFilter","xrateEditList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbXrateEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbXrateEditList", {dc:"xrate"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI", net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI);   
