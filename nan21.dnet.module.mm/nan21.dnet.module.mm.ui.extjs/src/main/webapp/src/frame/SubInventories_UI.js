Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/SubInventoryDs", "nan21.dnet.module.mm.ui.extjs/dc/SubInventory", "nan21.dnet.module.mm.ui.extjs/ds/StockLocatorDs", "nan21.dnet.module.mm.ui.extjs/dc/StockLocator","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.mm.ui.extjs/ds/StockLocatorTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/StockLocatorTypes","nan21.dnet.module.mm.ui.extjs/ds/StockLocatorTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/StockLocatorTypes"]);

Ext.define("net.nan21.dnet.module.mm.inventory.frame.SubInventories_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.inventory.frame.SubInventories_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.inventory.frame.SubInventories_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("subinv", new net.nan21.dnet.module.mm.inventory.dc.SubInventory({}))
		.addDc("sloc", new net.nan21.dnet.module.mm.inventory.dc.StockLocator({multiEdit:true}))		
		.linkDc("sloc", "subinv",{fields:[ {childField:"subInventoryId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("subinv",{ name:"subinvFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.SubInventory$Filter"})	 
		.addDcView("subinv",{ name:"subinvList", xtype:"net.nan21.dnet.module.mm.inventory.dc.SubInventory$List"})	 
		.addDcFormView("subinv",{ name:"subinvEdit", xtype:"net.nan21.dnet.module.mm.inventory.dc.SubInventory$Edit",height:130})	 
		.addDcFilterFormView("sloc",{ name:"slocFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.StockLocator$Filter"})	 
		.addDcView("sloc",{ name:"slocEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.StockLocator$CtxEditList", frame:true,title:"Stock locators"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["subinvFilter","subinvList"] ,["north","center"])	
		.addChildrenTo("canvas2",["subinvEdit","slocEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbSubinvList")	  	
	 	.addToolbarTo("canvas2","tlbSubinvEdit")	  	
	 	.addToolbarTo("slocEditList","tlbSlocEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSubinvList", {dc:"subinv"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbSubinvEdit", {dc:"subinv"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbSlocEditList", {dc:"sloc"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Stock locators"}).end(); 	
	}

});  
