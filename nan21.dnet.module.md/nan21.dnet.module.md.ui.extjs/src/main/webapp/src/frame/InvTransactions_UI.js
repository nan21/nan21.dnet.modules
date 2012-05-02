Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/InvTransactionDs", "nan21.dnet.module.md.ui.extjs/dc/InvTransaction", "nan21.dnet.module.md.ui.extjs/ds/InvTransactionLineDs", "nan21.dnet.module.md.ui.extjs/dc/InvTransactionLine","nan21.dnet.module.md.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations"]);

Ext.define("net.nan21.dnet.module.md.tx.inventory.frame.InvTransactions_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.tx.inventory.frame.InvTransactions_UI",
	
	 _name_ : "net.nan21.dnet.module.md.tx.inventory.frame.InvTransactions_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("tx", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransaction({}))
		.addDc("txline", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine({}))		
		.linkDc("txline", "tx",{fields:[ {childField:"transactionId", parentField:"id"},{childField:"fromInventoryId", parentField:"fromInventoryId"},{childField:"toInventoryId", parentField:"toInventoryId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("tx",{ name:"txFilter", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransaction$Filter",height:110})	 
		.addDcGridView("tx",{ name:"txList", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransaction$List"})	 
		.addDcGridView("txline",{ name:"txlineList", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$List",height:200})	 
		.addDcFormView("txline",{ name:"txlineCtxFormView", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$CtxFormView",height:40})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["txFilter","txList","txlineList"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbTxList")	  	
	 	.addToolbarTo("txlineList","tlbTxlineEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTxList", {dc:"tx"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Transactions"}).end()
			.beginToolbar("tlbTxlineEditList", {dc:"txline"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Items"}).end(); 	
	}

});  
