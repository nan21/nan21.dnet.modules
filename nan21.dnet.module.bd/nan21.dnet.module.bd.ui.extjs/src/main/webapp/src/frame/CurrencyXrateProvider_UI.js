Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateProviderDs", "nan21.dnet.module.bd.ui.extjs/dc/CurrencyXRateProvider"]);

Ext.define("net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prvd", new net.nan21.dnet.module.bd.currency.dc.CurrencyXRateProvider({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("prvd",{ name:"prvdFilter", xtype:"net.nan21.dnet.module.bd.currency.dc.CurrencyXRateProvider$Filter",height:120})	 
		.addDcView("prvd",{ name:"prvdEditList", xtype:"net.nan21.dnet.module.bd.currency.dc.CurrencyXRateProvider$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["prvdFilter","prvdEditList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbMain")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMain", {dc:"prvd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Exchange rate providers"}).end(); 	
	}

});  
