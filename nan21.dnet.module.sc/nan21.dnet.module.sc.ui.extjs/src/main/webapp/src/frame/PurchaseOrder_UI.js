Dnet.doImport(["", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseOrderDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseOrder", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseOrderItemDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseOrderItem", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseOrderItemTaxDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseOrderItemTax", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations","nan21.dnet.module.md.ui.extjs/ds/PriceListPurchaseLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceListPurchase","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/TxDocTypePOLovDs","nan21.dnet.module.bd.ui.extjs/lov/TxDocTypesPO","nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bd.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bd.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.bd.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs","nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/TaxApplicableLovDs","nan21.dnet.module.bd.ui.extjs/lov/TaxApplicables","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.bd.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.md.ui.extjs/ds/PriceListPurchaseLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceListPurchase","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/TxDocTypePOLovDs","nan21.dnet.module.bd.ui.extjs/lov/TxDocTypesPO","nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bd.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.sc.order.frame.PurchaseOrder_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sc.order.frame.PurchaseOrder_UI",
	
	 _name_ : "net.nan21.dnet.module.sc.order.frame.PurchaseOrder_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("order", new net.nan21.dnet.module.sc.order.dc.PurchaseOrder({}))
		.addDc("item", new net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem({}))
		.addDc("itemTax", new net.nan21.dnet.module.sc.order.dc.PurchaseOrderItemTax({}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))		
		.linkDc("item", "order",{fields:[ {childField:"purchaseOrderId", parentField:"id"} ]} )
		.linkDc("itemTax", "item",{fields:[ {childField:"purchaseOrderItemId", parentField:"id"} ]} )
		.linkDc("note", "order",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("atch", "order",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"entityFQN"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnConfirm",text:"Confirm", tooltip:"Confirm order.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"order" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}	})	
							 	
		.addButton({name:"btnUnConfirm",text:"Un-Confirm", tooltip:"Un-Confirm order.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"order" , and: function(dc) {return (dc.record && dc.record.get("confirmed") );}}	})	
							 	
		.addDcFilterFormView("order",{ name:"orderFilter", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrder$Filter",height:160})	 
		.addDcGridView("order",{ name:"orderList", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrder$List"})	 
		.addDcFormView("order",{ name:"orderEdit", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrder$EditMain",height:200,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnConfirm") ,this._elems_.get("btnUnConfirm") ]}]})	 
		.addDcFormView("order",{ name:"orderEditDetails", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrder$EditDetails",title:"Details"})	 
		.addDcGridView("item",{ name:"itemList", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$CtxList"})	 
		.addDcFormView("item",{ name:"itemEdit", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem$EditForm"})	 
		.addDcGridView("itemTax",{ name:"itemTaxList", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrderItemTax$CtxList",width:400,title:"Item taxes", collapsible:true})	 
		.addDcGridView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcEditGridView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "itemsPanel",layout:"card", activeItem:0})  	 

		.addPanel({name: "orderDetailsTab", xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Notes"})  	 
		.addPanel({name: "linesPanel", layout:"border", defaults:{split:true},title:"Items"})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["orderFilter","orderList"] ,["north","center"])	
		.addChildrenTo("canvas2",["orderEdit","orderDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("orderDetailsTab", ["orderEditDetails","linesPanel","atchEditList","notesPanel"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
		.addChildrenTo("linesPanel",["itemsPanel","itemTaxList"] ,["center","east"])	
	 	.addChildrenTo("itemsPanel", ["itemList","itemEdit"]) 				 		
	 	.addToolbarTo("canvas1","tlbOrderList")	  	
	 	.addToolbarTo("canvas2","tlbOrderEdit")	  	
	 	.addToolbarTo("itemList","tlbItemList")	  	
	 	.addToolbarTo("itemEdit","tlbItemEdit")	  	
	 	.addToolbarTo("itemTaxList","tlbItemTaxList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrderList", {dc:"order"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Purchase orders"}).end()
			.beginToolbar("tlbOrderEdit", {dc:"order"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Purchase order"}).end()
			.beginToolbar("tlbItemList", {dc:"item"}).addQuery().addEdit({inContainer:"itemsPanel",showView:"itemEdit"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Order items"}).end()
			.beginToolbar("tlbItemEdit", {dc:"item"}).addBack({inContainer:"itemsPanel",showView:"itemList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Order item"}).end()
			.beginToolbar("tlbItemTaxList", {dc:"itemTax"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Item taxes"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().addReports().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().addReports().end(); 	
	}


	,onBtnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("order").doService("confirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnUnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("order").doService("unConfirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();			 	
	}
	,onBtnUploadAttachment: function() {	
		var w=new dnet.core.base.FileUploadWindow({
    		_nameFieldValue_: this._getDc_("atch").getRecord().get("name"),
    		_p1Value_: this._getDc_("atch").getRecord().get("id"),
    		_uploadUrl_:"/nan21.dnet.core.web/upload/adDataAttachment",
    		_succesCallbackFn_ : this.onUploadSuccess,
    		_succesCallbackScope_: this
    	});w.show();
	}
	,onBtnViewAttachment: function() {	
		
		var url = this._getDc_("atch").getRecord().get("url");
		window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
	,onAfterDefineDcs: function() {	
		
		this._getDc_("item").on("afterDoSaveSuccess", 
		function() {
			this._getDc_("order").doRefreshCurrent();
		} , this );
		
		this._getDc_("order").on("afterDoServiceSuccess", 
		function() { this._applyStateAllButtons_(); this._syncReadOnlyStates_();  } , this );
		
		this._getDc_("order").on("recordChange", this._syncReadOnlyStates_, this );
		
		
	}
	,_syncReadOnlyStates_: function() {	
		
		var orderRec = this._getDc_("order").getRecord();
		if (!orderRec) { return; }
		var itemsDc = this._getDc_("item");
		if (orderRec.get("confirmed")) {
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
