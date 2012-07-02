Dnet.doImport(["", "nan21.dnet.module.fi.ui.extjs/ds/AmortizationDs", "nan21.dnet.module.fi.ui.extjs/dc/Amortization","nan21.dnet.module.fi.ui.extjs/ds/AssetCategoryLovDs","nan21.dnet.module.fi.ui.extjs/lov/AssetCategories","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies"]);

Ext.define("net.nan21.dnet.module.fi.asset.frame.Amortization_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.fi.asset.frame.Amortization_UI",
	
	 _name_ : "net.nan21.dnet.module.fi.asset.frame.Amortization_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("amort", new net.nan21.dnet.module.fi.asset.dc.Amortization({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("amort",{ name:"amortFilter", xtype:"net.nan21.dnet.module.fi.asset.dc.Amortization$Filter",height:120})	 
		.addDcGridView("amort",{ name:"amortList", xtype:"net.nan21.dnet.module.fi.asset.dc.Amortization$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["amortFilter","amortList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbAmortList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAmortList", {dc:"amort"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Amortization"}).end(); 	
	}

});  
