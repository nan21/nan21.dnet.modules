Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/InvTransactionDs", "nan21.dnet.module.mm.ui.extjs/dc/InvTransaction", "nan21.dnet.module.mm.ui.extjs/ds/InvTransactionLineDs", "nan21.dnet.module.mm.ui.extjs/dc/InvTransactionLine","nan21.dnet.module.mm.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.mm.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.mm.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/SubInventorys","nan21.dnet.module.mm.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.mm.ui.extjs/lov/StockLocators","nan21.dnet.module.mm.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/SubInventorys","nan21.dnet.module.mm.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.mm.ui.extjs/lov/StockLocators"]);

Ext.define("net.nan21.dnet.module.mm.inventory.frame.InvTransactions_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.inventory.frame.InvTransactions_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.inventory.frame.InvTransactions_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("tx", new net.nan21.dnet.module.mm.inventory.dc.InvTransaction({}))
		.addDc("txline", new net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine({multiEdit:true}))		
		.linkDc("txline", "tx",{fields:[ {childField:"transactionId", parentField:"id"},{childField:"fromInventoryId", parentField:"fromInventoryId"},{childField:"toInventoryId", parentField:"toInventoryId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnPostTransaction",text:"Post transaction", tooltip:"Post current transaction to create movement operations.",iconCls:"icon-gears",disabled:true
			,handler: this.onBtnPostTransaction,scope:this,stateManager:{name:"record_is_clean", dc:"tx" , and: function(evnt) {return (!(evnt.dc.record.data.eventDate));}}	})	
							 	
		.addDcFilterFormView("tx",{ name:"txFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Filter",height:40})	 
		.addDcView("tx",{ name:"txList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransaction$List"})	 
		.addDcFormView("tx",{ name:"txEdit", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransaction$Edit",height:120,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnPostTransaction") ]}]})	 
		.addDcView("txline",{ name:"txlineEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$EditList", frame:true})	 
		.addDcFormView("txline",{ name:"txlineCtxFormView", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$CtxFormView",height:40})	 
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
			.beginToolbar("tlbTxList", {dc:"tx"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Transactions"}).end()
			.beginToolbar("tlbTxEdit", {dc:"tx"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbTxlineEditList", {dc:"txline"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}


	,onBtnPostTransaction: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("tx").doService("postTransaction", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
