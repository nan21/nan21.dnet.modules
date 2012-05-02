Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/InvTransferDs", "nan21.dnet.module.md.ui.extjs/dc/InvTransfer", "nan21.dnet.module.md.ui.extjs/ds/InvTransactionLineDs", "nan21.dnet.module.md.ui.extjs/dc/InvTransactionLine","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.md.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.md.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs","nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom","nan21.dnet.module.md.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.md.ui.extjs/lov/SubInventorys","nan21.dnet.module.md.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.md.ui.extjs/lov/StockLocators","nan21.dnet.module.md.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.md.ui.extjs/lov/SubInventorys","nan21.dnet.module.md.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.md.ui.extjs/lov/StockLocators","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode"]);

Ext.define("net.nan21.dnet.module.md.tx.inventory.frame.InvTransfer_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.tx.inventory.frame.InvTransfer_UI",
	
	 _name_ : "net.nan21.dnet.module.md.tx.inventory.frame.InvTransfer_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("tx", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransfer({}))
		.addDc("txline", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine({multiEdit:true}))		
		.linkDc("txline", "tx",{fields:[ {childField:"transactionId", parentField:"id"},{childField:"fromInventoryId", parentField:"fromInventoryId"},{childField:"toInventoryId", parentField:"toInventoryId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnConfirm",text:"Confirm", tooltip:"Confirm delivery.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"tx" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}	})	
							 	
		.addButton({name:"btnUnConfirm",text:"Un-Confirm", tooltip:"Un-Confirm delivery.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"tx" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted") );}}	})	
							 	
		.addButton({name:"btnPost",text:"Post", tooltip:"Post current transaction to create movement operations.",iconCls:"icon-gears",disabled:true
			,handler: this.onBtnPost,scope:this,stateManager:{name:"record_is_clean", dc:"tx" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted") );}}	})	
							 	
		.addDcFilterFormView("tx",{ name:"txFilter", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransfer$Filter",height:120})	 
		.addDcGridView("tx",{ name:"txList", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransfer$List"})	 
		.addDcFormView("tx",{ name:"txEdit", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransfer$Edit",height:180,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnConfirm") ,this._elems_.get("btnUnConfirm") ]}]})	 
		.addDcEditGridView("txline",{ name:"txlineList", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditList", frame:true})	 
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
		.addChildrenTo("canvas2",["txEdit","txlineList","txlineCtxFormView"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbTxList")	  	
	 	.addToolbarTo("canvas2","tlbTxEdit")	  	
	 	.addToolbarTo("txlineList","tlbTxlineEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTxList", {dc:"tx"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Transfers"}).end()
			.beginToolbar("tlbTxEdit", {dc:"tx"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Transfer"}).end()
			.beginToolbar("tlbTxlineEditList", {dc:"txline"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Items"}).end(); 	
	}


	,onBtnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("tx").doService("confirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnUnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("tx").doService("unConfirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnPost: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("tx").doService("post", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
	,onAfterDefineDcs: function() {	
				 
		this._getDc_("tx").on("afterDoServiceSuccess", 
		function() {this._syncReadOnlyStates_(); } , this );
		
		this._getDc_("tx").on("recordChange", this._syncReadOnlyStates_, this );
		
	}
	,_syncReadOnlyStates_: function() {	
		
		var txRec = this._getDc_("tx").getRecord();
		if (!txRec) { return; }
		var itemsDc = this._getDc_("txline");
		if (txRec.get("confirmed")) {
			if (!itemsDc.isReadOnly()) {
				itemsDc.setReadOnly(true);
			}
		} else {
			if (itemsDc.isReadOnly()) {
				itemsDc.setReadOnly(false);
			}
		}
		
	}
	,_afterDefineDcs_: function() {	
		this.onAfterDefineDcs();
	}
});  
