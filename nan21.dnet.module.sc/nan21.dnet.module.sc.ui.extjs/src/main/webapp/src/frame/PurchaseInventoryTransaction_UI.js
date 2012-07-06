Dnet.doImport(["", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseInventoryTransactionDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseInventoryTransaction", "nan21.dnet.module.md.ui.extjs/ds/InvTransactionLineDs", "nan21.dnet.module.md.ui.extjs/dc/InvTransactionLine","nan21.dnet.module.md.ui.extjs/ds/VendorLovDs","nan21.dnet.module.md.ui.extjs/lov/VendorsName","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.md.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs","nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom","nan21.dnet.module.md.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.md.ui.extjs/lov/SubInventorys","nan21.dnet.module.md.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.md.ui.extjs/lov/StockLocators","nan21.dnet.module.md.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.md.ui.extjs/lov/SubInventorys","nan21.dnet.module.md.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.md.ui.extjs/lov/StockLocators","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode"]);

Ext.define("net.nan21.dnet.module.sc.order.frame.PurchaseInventoryTransaction_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sc.order.frame.PurchaseInventoryTransaction_UI",
	
	 _name_ : "net.nan21.dnet.module.sc.order.frame.PurchaseInventoryTransaction_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("tx", new net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction({}))
		.addDc("txline", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine({multiEdit:true}))		
		.linkDc("txline", "tx",{fields:[ {childField:"transactionId", parentField:"id"},{childField:"fromInventoryId", parentField:"fromInventoryId"},{childField:"toInventoryId", parentField:"toInventoryId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("tx",{ name:"txFilter", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$Filter"})	 
		.addDcGridView("tx",{ name:"txList", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$List"})	 
		.addDcFormView("tx",{ name:"txEdit", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$Edit"})	 
		.addDcEditGridView("txline",{ name:"txlineEditList", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditList", frame:true})	 
		.addDcFormView("txline",{ name:"txlineCtxFormView", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$CtxFormView",height:40})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["txFilter","txList"] ,["north","center"])	
		.addChildrenTo("canvas2",["txEdit","txlineEditList","txlineCtxFormView"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbTxList")	  	
	 	.addToolbarTo("canvas2","tlbTxEdit")	  	
	 	.addToolbarTo("txlineEditList","tlbTxlineEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTxList", {dc:"tx"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Receptions"}).end()
			.beginToolbar("tlbTxEdit", {dc:"tx"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Reception"}).end()
			.beginToolbar("tlbTxlineEditList", {dc:"txline"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Items"}).end(); 	
	}

});  
