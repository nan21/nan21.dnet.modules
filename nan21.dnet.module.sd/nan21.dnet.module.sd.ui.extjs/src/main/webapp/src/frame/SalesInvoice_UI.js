Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoice", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceTaxDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceTax", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceItemDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceItem", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceItemTaxDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceItemTax", "nan21.dnet.module.md.ui.extjs/ds/AccDocLineCtxDs", "nan21.dnet.module.md.ui.extjs/dc/AccDocLineCtx", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.md.ui.extjs/ds/PriceListSalesLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceListSales","nan21.dnet.module.bd.ui.extjs/ds/TxDocTypeSILovDs","nan21.dnet.module.bd.ui.extjs/lov/TxDocTypesSI","nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bd.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bd.ui.extjs/ds/LocationToBillLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToBill","nan21.dnet.module.md.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.md.ui.extjs/lov/BpContacts","nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs","nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/TaxApplicableLovDs","nan21.dnet.module.bd.ui.extjs/lov/TaxApplicables","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.md.ui.extjs/ds/PriceListSalesLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceListSales","nan21.dnet.module.bd.ui.extjs/ds/TxDocTypeSILovDs","nan21.dnet.module.bd.ui.extjs/lov/TxDocTypesSI","nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bd.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bd.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.bd.ui.extjs/lov/AccSchemas","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("inv", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoice({}))
		.addDc("tax", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceTax({}))
		.addDc("item", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem({multiEdit:true}))
		.addDc("itemTax", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItemTax({}))
		.addDc("accDocLine", new net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx({}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))		
		.linkDc("tax", "inv",{fields:[ {childField:"salesInvoiceId", parentField:"id"} ]} )
		.linkDc("item", "inv",{fields:[ {childField:"salesInvoiceId", parentField:"id"} ]} )
		.linkDc("itemTax", "item",{fields:[ {childField:"salesInvoiceItemId", parentField:"id"} ]} )
		.linkDc("accDocLine", "inv",{fields:[ {childField:"docUuid", parentField:"uuid"} ]} )
		.linkDc("note", "inv",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("atch", "inv",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"entityFQN"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnConfirmInvoice",text:"Confirm", tooltip:"Confirm invoice.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnConfirmInvoice,scope:this,stateManager:{name:"selected_one_clean", dc:"inv" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}	})	
							 	
		.addButton({name:"btnUnConfirmInvoice",text:"Un-Confirm", tooltip:"Un-Confirm invoice.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnConfirmInvoice,scope:this,stateManager:{name:"selected_one_clean", dc:"inv" , and: function(dc) {return (dc.record && dc.record.get("confirmed") && !dc.record.get("posted")  );}}	})	
							 	
		.addButton({name:"btnPostInvoice",text:"Post", tooltip:"Post invoice to accounting.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnPostInvoice,scope:this,stateManager:{name:"selected_one_clean", dc:"inv" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted"));}}	})	
							 	
		.addButton({name:"btnUnPostInvoice",text:"Un-Post", tooltip:"Un-Post invoice from accounting.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnPostInvoice,scope:this,stateManager:{name:"selected_one_clean", dc:"inv" , and: function(dc) {return (dc.record && dc.record.get("confirmed") &&  dc.record.get("confirmed") && dc.record.get("posted") );}}	})	
							 	
		.addButton({name:"btnShowOrder",text:"Show Order", tooltip:"Show the sales order linked to this invoice",disabled:true
			,handler: this.onBtnShowOrder,scope:this,stateManager:{name:"selected_one", dc:"inv" , and: function(dc) {return (dc.record && dc.record.get("salesOrderId"));}}	})	
							 	
		.addDcFilterFormView("inv",{ name:"invFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter",height:150})	 
		.addDcGridView("inv",{ name:"invList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List"})	 
		.addDcFormView("inv",{ name:"invEditMain", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$EditMain",height:200,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnConfirmInvoice") ,this._elems_.get("btnUnConfirmInvoice") ,this._elems_.get("btnPostInvoice") ,this._elems_.get("btnUnPostInvoice") ,this._elems_.get("btnShowOrder") ]}]})	 
		.addDcFormView("inv",{ name:"invEditDetails", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$EditDetails",title:"Details"})	 
		.addDcGridView("tax",{ name:"taxList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceTax$List",title:"Taxes"})	 
		.addDcGridView("accDocLine",{ name:"accDocLineList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx$List"})	 
		.addDcFilterFormView("accDocLine",{ name:"accDocLineFilter", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx$Filter",width:250,title:"Filter", collapsible:true})	 
		.addDcGridView("item",{ name:"itemList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$CtxList"})	 
		.addDcFormView("item",{ name:"itemEdit", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$EditForm"})	 
		.addDcGridView("itemTax",{ name:"itemTaxList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItemTax$CtxList",width:400,title:"Item taxes", collapsible:true})	 
		.addDcGridView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcEditGridView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "itemsPanel",layout:"card", activeItem:0})  	 

		.addPanel({name: "invDetailsTab", xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "accDocPanel", layout:"border", defaults:{split:true},title:"Accounting"})  	 
		.addPanel({name: "linesPanel", layout:"border", defaults:{split:true},title:"Items"})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Notes"})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["invFilter","invList"] ,["north","center"])	
		.addChildrenTo("canvas2",["invEditMain","invDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("invDetailsTab", ["invEditDetails","linesPanel","taxList","accDocPanel","atchEditList","notesPanel"]) 				 		
		.addChildrenTo("accDocPanel",["accDocLineFilter","accDocLineList"] ,["west","center"])	
		.addChildrenTo("linesPanel",["itemsPanel","itemTaxList"] ,["center","east"])	
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addChildrenTo("itemsPanel", ["itemList","itemEdit"]) 				 		
	 	.addToolbarTo("canvas1","tlbInvList")	  	
	 	.addToolbarTo("canvas2","tlbInvEdit")	  	
	 	.addToolbarTo("taxList","tlbTaxList")	  	
	 	.addToolbarTo("accDocLineList","tlbAccDocLineList")	  	
	 	.addToolbarTo("itemList","tlbItemList")	  	
	 	.addToolbarTo("itemEdit","tlbItemEdit")	  	
	 	.addToolbarTo("itemTaxList","tlbItemTaxList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvList", {dc:"inv"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Sales invoices"}).end()
			.beginToolbar("tlbInvEdit", {dc:"inv"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Sales invoice"}).end()
			.beginToolbar("tlbTaxList", {dc:"tax"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Taxes"}).end()
			.beginToolbar("tlbAccDocLineList", {dc:"accDocLine"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end()
			.beginToolbar("tlbItemList", {dc:"item"}).addQuery().addEdit({inContainer:"itemsPanel",showView:"itemEdit"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Invoice items"}).end()
			.beginToolbar("tlbItemEdit", {dc:"item"}).addBack({inContainer:"itemsPanel",showView:"itemList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Invoice item"}).end()
			.beginToolbar("tlbItemTaxList", {dc:"itemTax"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Item taxes"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().addReports().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().addReports().end(); 	
	}


	,onBtnConfirmInvoice: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("inv").doService("confirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnUnConfirmInvoice: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("inv").doService("unConfirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnPostInvoice: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("inv").doService("post", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnUnPostInvoice: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("inv").doService("unPost", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnShowOrder: function() {
		var bundle = "nan21.dnet.module.sd.ui.extjs";
		var frame = "net.nan21.dnet.module.sd.order.frame.SalesOrder_UI";
				
		getApplication().showFrame(frame,{
	 		url:Dnet.buildUiPath(bundle, frame, false),  	 		 
	 		params: {
	 			id: this._getDc_("inv").getRecord().get("salesOrderId")	 			,
	 			code: this._getDc_("inv").getRecord().get("salesOrderCode")	 			
		    }, 				      
	 		callback: function (params) {	           
	          this._when_called_to_edit_(params);                                    
			} 				    
	  	});
		
		
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
			this._getDc_("inv").doRefreshCurrent();
		} , this );
		
		this._getDc_("inv").on("afterDoServiceSuccess", 
		function() { this._applyStateAllButtons_(); this._syncReadOnlyStates_();  } , this );
		
		this._getDc_("inv").on("recordChange", this._syncReadOnlyStates_, this );
		
	}
	,_syncReadOnlyStates_: function() {	
		
		var invRec = this._getDc_("inv").getRecord();
		if (!invRec) { return; }
		var itemsDc = this._getDc_("item");
		if (invRec.get("confirmed")) {
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
		
		var inv = this._getDc_("inv");
		if (inv.isDirty()) {
			this._alert_dirty_();
			return;
		}
		inv.doClearQuery();
		//inv.setFilterValue("salesOrderId", params.salesOrderId );
		inv.setFilterValue("salesOrderCode", params.salesOrderCode );
		inv.doQuery();
		this._showStackedViewElement_("main",1);
		
	}
	,_afterDefineDcs_: function() {	
		this.onAfterDefineDcs();
	}
});  
