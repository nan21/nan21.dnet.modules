Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrder", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTaxDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderTax", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderItemDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderItem", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderItemTaxDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderItemTax", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.md.ui.extjs/ds/TxDocTypeSOLovDs","nan21.dnet.module.md.ui.extjs/lov/TxDocTypesSO","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/CustomerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations","nan21.dnet.module.md.ui.extjs/ds/PriceListSalesLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceListSales","nan21.dnet.module.md.ui.extjs/ds/TxDocTypeSOInvOutLovDs","nan21.dnet.module.md.ui.extjs/lov/TxDocTypesSOInvOut","nan21.dnet.module.md.ui.extjs/ds/InvTransactionTypeLovDs","nan21.dnet.module.md.ui.extjs/lov/InvTransactionTypes","nan21.dnet.module.md.ui.extjs/ds/TxDocTypeSILovDs","nan21.dnet.module.md.ui.extjs/lov/TxDocTypesSI","nan21.dnet.module.md.ui.extjs/ds/PaymentMethodInLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentMethodIn","nan21.dnet.module.md.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentTerm","nan21.dnet.module.md.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.md.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName","nan21.dnet.module.bd.ui.extjs/ds/LocationToBillLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToBill","nan21.dnet.module.md.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.md.ui.extjs/lov/BpContacts","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName","nan21.dnet.module.bd.ui.extjs/ds/LocationToShipLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToShip","nan21.dnet.module.md.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.md.ui.extjs/lov/BpContacts","nan21.dnet.module.bd.ui.extjs/ds/CarrierOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/CarrierOrganizations","nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs","nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.md.ui.extjs/ds/TaxApplicableLovDs","nan21.dnet.module.md.ui.extjs/lov/TaxApplicables","nan21.dnet.module.md.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.md.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.md.ui.extjs/ds/PriceListSalesLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceListSales","nan21.dnet.module.md.ui.extjs/ds/TxDocTypeSOLovDs","nan21.dnet.module.md.ui.extjs/lov/TxDocTypesSO","nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentMethod","nan21.dnet.module.md.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.sd.order.frame.SalesOrder_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.order.frame.SalesOrder_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.order.frame.SalesOrder_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("order", new net.nan21.dnet.module.sd.order.dc.SalesOrder({}))
		.addDc("tax", new net.nan21.dnet.module.sd.order.dc.SalesOrderTax({}))
		.addDc("item", new net.nan21.dnet.module.sd.order.dc.SalesOrderItem({}))
		.addDc("itemTax", new net.nan21.dnet.module.sd.order.dc.SalesOrderItemTax({}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))		
		.linkDc("tax", "order",{fields:[ {childField:"salesOrderId", parentField:"id"} ]} )
		.linkDc("item", "order",{fields:[ {childField:"salesOrderId", parentField:"id"} ]} )
		.linkDc("itemTax", "item",{fields:[ {childField:"salesOrderItemId", parentField:"id"} ]} )
		.linkDc("note", "order",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("atch", "order",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"entityFQN"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnConfirmOrder",text:"Confirm", tooltip:"Confirm order.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnConfirmOrder,scope:this,stateManager:{name:"selected_one_clean", dc:"order" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}	})	
							 	
		.addButton({name:"btnUnConfirmOrder",text:"Un-Confirm", tooltip:"Un-Confirm order.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnConfirmOrder,scope:this,stateManager:{name:"selected_one_clean", dc:"order" , and: function(dc) {return (dc.record && dc.record.get("confirmed") && !dc.record.get("invoiced") && !dc.record.get("delivered") );}}	})	
							 	
		.addButton({name:"btnCreateInvoice",text:"Generate Invoice", tooltip:"Generate Invoice",disabled:true
			,handler: this.onBtnCreateInvoice,scope:this,stateManager:{name:"selected_one_clean", dc:"order" , and: function(dc) {return (dc.record && dc.record.get("confirmed") && ! dc.record.get("invoiced"));}}	})	
							 	
		.addButton({name:"btnCreateDelivery",text:"Generate Delivery", tooltip:"Generate Delivery",disabled:true
			,handler: this.onBtnCreateDelivery,scope:this,stateManager:{name:"selected_one_clean", dc:"order" , and: function(dc) {return ( dc.record && dc.record.get("confirmed") && ! dc.record.get("delivered"));}}	})	
							 	
		.addButton({name:"btnCreateDeliveryOk",text:"OK", tooltip:"Generate Delivery",disabled:false
			,handler: this.onBtnCreateDeliveryOk,scope:this	})	
							 	
		.addButton({name:"btnCreateInvoiceOk",text:"OK", tooltip:"Generate Invoice",disabled:false
			,handler: this.onBtnCreateInvoiceOk,scope:this	})	
							 	
		.addButton({name:"btnShowInvoice",text:"Show Invoice", tooltip:"Show the invoice linked to this sales order",disabled:true
			,handler: this.onBtnShowInvoice,scope:this,stateManager:{name:"selected_one", dc:"order" , and: function(dc) {return (dc.record && dc.record.get("invoiced"));}}	})	
							 	
		.addButton({name:"btnShowDelivery",text:"Show delivery", tooltip:"Show the delivery note linked to this sales order",disabled:true
			,handler: this.onBtnShowDelivery,scope:this,stateManager:{name:"selected_one", dc:"order" , and: function(dc) {return (dc.record && dc.record.get("delivered"));}}	})	
							 	
		.addDcFilterFormView("order",{ name:"orderFilter", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter",height:170})	 
		.addDcGridView("order",{ name:"orderList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$List"})	 
		.addDcFormView("order",{ name:"orderEditMain", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$EditMain",height:200,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnConfirmOrder") ,this._elems_.get("btnUnConfirmOrder") ,this._elems_.get("btnCreateInvoice") ,this._elems_.get("btnShowInvoice") ,this._elems_.get("btnCreateDelivery") ,this._elems_.get("btnShowDelivery") ]}]})	 
		.addDcGridView("tax",{ name:"taxList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderTax$List",title:"Taxes"})	 
		.addDcFormView("order",{ name:"orderGenDelivery", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$FrmGenDelivery"})	 
		.addDcFormView("order",{ name:"orderGenInvoice", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$FrmGenInvoice"})	 
		.addDcFormView("order",{ name:"orderEditDetails", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$EditDetails",title:"Details"})	 
		.addDcGridView("item",{ name:"itemList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderItem$CtxList"})	 
		.addDcFormView("item",{ name:"itemEdit", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderItem$EditForm"})	 
		.addDcGridView("itemTax",{ name:"itemTaxList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderItemTax$CtxList",width:400,title:"Item taxes", collapsible:true})	 
		.addDcGridView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcEditGridView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "itemsPanel",layout:"card", activeItem:0})  	 

		.addPanel({name: "orderDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Notes"})  	 
		.addPanel({name: "linesPanel", layout:"border", defaults:{split:true},title:"Items"})  	 
		
		.addWindow({name:"wdwGenDelivery", closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("orderGenDelivery")]
,title:"Generate delivery",modal:true,width:400,height:180,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnCreateDeliveryOk") ]}}) 	

		.addWindow({name:"wdwGenInvoice", closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("orderGenInvoice")]
,title:"Generate invoice",modal:true,width:400,height:120,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnCreateInvoiceOk") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["orderFilter","orderList"] ,["north","center"])	
		.addChildrenTo("canvas2",["orderEditMain","orderDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("orderDetailsTab", ["orderEditDetails","linesPanel","taxList","atchEditList","notesPanel"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
		.addChildrenTo("linesPanel",["itemsPanel","itemTaxList"] ,["center","east"])	
	 	.addChildrenTo("itemsPanel", ["itemList","itemEdit"]) 				 		
	 	.addToolbarTo("canvas1","tlbOrderList")	  	
	 	.addToolbarTo("canvas2","tlbOrderEdit")	  	
	 	.addToolbarTo("taxList","tlbTaxList")	  	
	 	.addToolbarTo("itemList","tlbItemList")	  	
	 	.addToolbarTo("itemEdit","tlbItemEdit")	  	
	 	.addToolbarTo("itemTaxList","tlbItemTaxList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrderList", {dc:"order"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Sales orders"}).end()
			.beginToolbar("tlbOrderEdit", {dc:"order"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Sales order"}).end()
			.beginToolbar("tlbTaxList", {dc:"tax"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Taxes"}).end()
			.beginToolbar("tlbItemList", {dc:"item"}).addQuery().addEdit({inContainer:"itemsPanel",showView:"itemEdit"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Items"}).end()
			.beginToolbar("tlbItemEdit", {dc:"item"}).addBack({inContainer:"itemsPanel",showView:"itemList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Item"}).end()
			.beginToolbar("tlbItemTaxList", {dc:"itemTax"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Item taxes"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().addReports().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().addReports().end(); 	
	}


	,onBtnConfirmOrder: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("order").doService("confirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnUnConfirmOrder: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("order").doService("unConfirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnCreateInvoice: function() {
		this._getWindow_("wdwGenInvoice").show();			 	
	}					 	

	,onBtnCreateDelivery: function() {
		this._getWindow_("wdwGenDelivery").show();			 	
	}					 	

	,onBtnCreateDeliveryOk: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getWindow_("wdwGenDelivery").close();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("order").doService("generateDelivery", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnCreateInvoiceOk: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getWindow_("wdwGenInvoice").close();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("order").doService("generateInvoice", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnShowInvoice: function() {
		var bundle = "nan21.dnet.module.sd.ui.extjs";
		var frame = "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI";
				
		getApplication().showFrame(frame,{
	 		url:Dnet.buildUiPath(bundle, frame, false),  	 		 
	 		params: {
	 			salesOrderId: this._getDc_("order").getRecord().get("id")	 			,
	 			salesOrderCode: this._getDc_("order").getRecord().get("code")	 			
		    }, 				      
	 		callback: function (params) {	           
	          this._when_called_to_edit_by_so_(params);                                    
			} 				    
	  	});
		
		
	}					 	

	,onBtnShowDelivery: function() {
		var bundle = "nan21.dnet.module.sd.ui.extjs";
		var frame = "net.nan21.dnet.module.sd.order.frame.SalesDelivery_UI";
				
		getApplication().showFrame(frame,{
	 		url:Dnet.buildUiPath(bundle, frame, false),  	 		 
	 		params: {
	 			salesOrderCode: this._getDc_("order").getRecord().get("code")	 			
		    }, 				      
	 		callback: function (params) {	           
	          this._when_called_to_edit_by_so_(params);                                    
			} 				    
	  	});
		
		
	}					 	
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();			 	
	}
	,notImplemented: function() {	
		alert("This feature is not implemented yet.");
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
		function() { this._applyStateAllButtons_();this._syncReadOnlyStates_(); } , this );
		
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
	,_when_called_to_edit_: function(params) {	
		
		var order = this._getDc_("order");
		if (order.isDirty()) {
			this._alert_dirty_();
			return;
		}
		order.doClearQuery();
		//order.setFilterValue("id", params.id );
		order.setFilterValue("code", params.code );
		order.doQuery();
		this._showStackedViewElement_("main",1);
	}
	,_afterDefineDcs_: function() {	
		this.onAfterDefineDcs();
	}
});  
