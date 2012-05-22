Dnet.doImport(["", "nan21.dnet.module.fi.ui.extjs/ds/AssetDs", "nan21.dnet.module.fi.ui.extjs/dc/Asset", "nan21.dnet.module.fi.ui.extjs/ds/AmortizationItemDs", "nan21.dnet.module.fi.ui.extjs/dc/AmortizationItem"]);

Ext.define("net.nan21.dnet.module.fi.asset.frame.Asset_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.fi.asset.frame.Asset_UI",
	
	 _name_ : "net.nan21.dnet.module.fi.asset.frame.Asset_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("asset", new net.nan21.dnet.module.fi.asset.dc.Asset({}))
		.addDc("amort", new net.nan21.dnet.module.fi.asset.dc.AmortizationItem({multiEdit:true}))		
		.linkDc("amort", "asset",{fields:[ {childField:"assetId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("asset",{ name:"assetFilter", xtype:"net.nan21.dnet.module.fi.asset.dc.Asset$Filter"})	 
		.addDcGridView("asset",{ name:"assetList", xtype:"net.nan21.dnet.module.fi.asset.dc.Asset$List"})	 
		.addDcFormView("asset",{ name:"assetEdit", xtype:"net.nan21.dnet.module.fi.asset.dc.Asset$Edit"})	 
		.addDcEditGridView("amort",{ name:"amortEditList", xtype:"net.nan21.dnet.module.fi.asset.dc.AmortizationItem$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["assetFilter","assetList"] ,["north","center"])	
		.addChildrenTo("canvas2",["assetEdit","amortEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbAssetList")	  	
	 	.addToolbarTo("canvas2","tlbAssetEdit")	  	
	 	.addToolbarTo("amortEditList","tlbAmortEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAssetList", {dc:"asset"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Assets"}).end()
			.beginToolbar("tlbAssetEdit", {dc:"asset"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Asset"}).end()
			.beginToolbar("tlbAmortEditList", {dc:"amort"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Amortization"}).end(); 	
	}

});  
