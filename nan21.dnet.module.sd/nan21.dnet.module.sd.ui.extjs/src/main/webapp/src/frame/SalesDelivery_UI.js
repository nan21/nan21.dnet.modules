Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesDeliveryDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesDelivery", "nan21.dnet.module.md.ui.extjs/ds/InvTransactionLineDs", "nan21.dnet.module.md.ui.extjs/dc/InvTransactionLine","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CarrierOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/CarrierOrganizations","nan21.dnet.module.md.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.md.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CarrierOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/CarrierOrganizations","nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs","nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom","nan21.dnet.module.md.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.md.ui.extjs/lov/SubInventorys","nan21.dnet.module.md.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.md.ui.extjs/lov/StockLocators","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode"]);

Ext.define("net.nan21.dnet.module.sd.order.frame.SalesDelivery_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.order.frame.SalesDelivery_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.order.frame.SalesDelivery_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("tx", new net.nan21.dnet.module.sd.order.dc.SalesDelivery({}))
		.addDc("txline", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine({multiEdit:true}))		
		.linkDc("txline", "tx",{fields:[ {childField:"transactionId", parentField:"id"},{childField:"fromInventoryId", parentField:"warehouseId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnConfirm",text:"Confirm", tooltip:"Confirm delivery.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"tx" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}	})	
							 	
		.addButton({name:"btnUnConfirm",text:"Un-Confirm", tooltip:"Un-Confirm delivery.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"tx" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted") );}}	})	
							 	
		.addDcFilterFormView("tx",{ name:"txFilter", xtype:"net.nan21.dnet.module.sd.order.dc.SalesDelivery$Filter",height:140})	 
		.addDcGridView("tx",{ name:"txList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesDelivery$List"})	 
		.addDcFormView("tx",{ name:"txEdit", xtype:"net.nan21.dnet.module.sd.order.dc.SalesDelivery$Edit",height:200,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnConfirm") ,this._elems_.get("btnUnConfirm") ]}]})	 
		.addDcEditGridView("txline",{ name:"txlineEditList", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditListFrom", frame:true})	 
		.addDcFormView("txline",{ name:"txlineCtxFormView", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$CtxFormView",height:55})	 
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
			.beginToolbar("tlbTxList", {dc:"tx"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Deliveries"}).end()
			.beginToolbar("tlbTxEdit", {dc:"tx"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Delivery"}).end()
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
	,_when_called_to_edit_by_so_: function(params) {	
		
		var tx = this._getDc_("tx");
		if (tx.isDirty()) {
			this._alert_dirty_();
			return;
		}
		tx.doClearQuery();
		//inv.setFilterValue("salesOrderId", params.salesOrderId );
		tx.setFilterValue("salesOrder", params.salesOrderCode );
		tx.doQuery();
		this._showStackedViewElement_("main",1);
		
	}
	,_afterDefineDcs_: function() {	
		this.onAfterDefineDcs();
	}
});  
