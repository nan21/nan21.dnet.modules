Dnet.doImport(["", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseReceptionDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseReception", "nan21.dnet.module.mm.ui.extjs/ds/InvTransactionLineDs", "nan21.dnet.module.mm.ui.extjs/dc/InvTransactionLine","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CarrierOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/CarrierOrganizations","nan21.dnet.module.bd.ui.extjs/ds/FinDocTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/FinDocTypes","nan21.dnet.module.mm.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/FinDocTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/FinDocTypes","nan21.dnet.module.mm.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CarrierOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/CarrierOrganizations","nan21.dnet.module.mm.ui.extjs/ds/ProductWithUomLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductsWithUom","nan21.dnet.module.mm.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/SubInventorys","nan21.dnet.module.mm.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.mm.ui.extjs/lov/StockLocators","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode"]);

Ext.define("net.nan21.dnet.module.sc.order.frame.PurchaseReception_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sc.order.frame.PurchaseReception_UI",
	
	 _name_ : "net.nan21.dnet.module.sc.order.frame.PurchaseReception_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("tx", new net.nan21.dnet.module.sc.order.dc.PurchaseReception({}))
		.addDc("txline", new net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine({multiEdit:true}))		
		.linkDc("txline", "tx",{fields:[ {childField:"transactionId", parentField:"id"},{childField:"toInventoryId", parentField:"warehouseId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnConfirm",text:"Confirm", tooltip:"Confirm reception.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"tx" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}	})	
							 	
		.addButton({name:"btnUnConfirm",text:"Un-Confirm", tooltip:"Un-Confirm reception.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"tx" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted") );}}	})	
							 	
		.addDcFilterFormView("tx",{ name:"txFilter", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseReception$Filter",height:120})	 
		.addDcGridView("tx",{ name:"txList", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseReception$List"})	 
		.addDcFormView("tx",{ name:"txEdit", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseReception$Edit",height:160,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnConfirm") ,this._elems_.get("btnUnConfirm") ]}]})	 
		.addDcEditGridView("txline",{ name:"txlineEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionLine$EditListTo", frame:true})	 
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
			.beginToolbar("tlbTxList", {dc:"tx"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Receptions"}).end()
			.beginToolbar("tlbTxEdit", {dc:"tx"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Reception"}).end()
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
});  
