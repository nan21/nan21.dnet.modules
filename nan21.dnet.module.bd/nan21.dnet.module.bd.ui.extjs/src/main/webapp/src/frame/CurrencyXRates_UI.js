Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateDs", "nan21.dnet.module.bd.ui.extjs/dc/CurrencyXRate","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateProviderLovDs","nan21.dnet.module.bd.ui.extjs/lov/CurrencyXRateProviders","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateProviderLovDs","nan21.dnet.module.bd.ui.extjs/lov/CurrencyXRateProviders"]);

Ext.define("net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("xrate", new net.nan21.dnet.module.bd.currency.dc.CurrencyXRate({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("xrate",{ name:"xrateFilter", xtype:"net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter"})	 
		.addDcView("xrate",{ name:"xrateEditList", xtype:"net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",preventHeader:true})  	 
;	 	
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
