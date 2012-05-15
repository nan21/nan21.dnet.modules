Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/PaymentInDs", "nan21.dnet.module.sd.ui.extjs/dc/PaymentIn", "nan21.dnet.module.md.ui.extjs/ds/PaymentItemAccItemDs", "nan21.dnet.module.md.ui.extjs/dc/PaymentItemAccItem", "nan21.dnet.module.md.ui.extjs/ds/PaymentItemProductDs", "nan21.dnet.module.md.ui.extjs/dc/PaymentItemProduct", "nan21.dnet.module.md.ui.extjs/ds/AccDocLineCtxDs", "nan21.dnet.module.md.ui.extjs/dc/AccDocLineCtx","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodInLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentMethodIn","nan21.dnet.module.md.ui.extjs/ds/PayAccountLovDs","nan21.dnet.module.md.ui.extjs/lov/PayAccounts","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodInLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentMethodIn","nan21.dnet.module.md.ui.extjs/ds/PayAccountLovDs","nan21.dnet.module.md.ui.extjs/lov/PayAccounts","nan21.dnet.module.bd.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.bd.ui.extjs/lov/AccSchemas","nan21.dnet.module.bd.ui.extjs/ds/AccItemLovDs","nan21.dnet.module.bd.ui.extjs/lov/AccItems","nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs","nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode"]);

Ext.define("net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("payment", new net.nan21.dnet.module.sd.invoice.dc.PaymentIn({}))
		.addDc("item", new net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem({multiEdit:true}))
		.addDc("itemp", new net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct({multiEdit:true}))
		.addDc("accDocLine", new net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx({}))		
		.linkDc("item", "payment",{fields:[ {childField:"paymentId", parentField:"id"} ]} )
		.linkDc("itemp", "payment",{fields:[ {childField:"paymentId", parentField:"id"} ]} )
		.linkDc("accDocLine", "payment",{fields:[ {childField:"docUuid", parentField:"uuid"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnConfirm",text:"Confirm", tooltip:"Confirm payment.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"payment" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}	})	
							 	
		.addButton({name:"btnUnConfirm",text:"Un-Confirm", tooltip:"Un-Confirm payment.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnConfirm,scope:this,stateManager:{name:"selected_one_clean", dc:"payment" , and: function(dc) {return (dc.record && dc.record.get("confirmed") && !dc.record.get("posted")  );}}	})	
							 	
		.addButton({name:"btnPost",text:"Post", tooltip:"Post payment to accounting.",iconCls:"icon-action-commit",disabled:true
			,handler: this.onBtnPost,scope:this,stateManager:{name:"selected_one_clean", dc:"payment" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted"));}}	})	
							 	
		.addButton({name:"btnUnPost",text:"Un-Post", tooltip:"Un-Post payment from accounting.",iconCls:"icon-action-rollback",disabled:true
			,handler: this.onBtnUnPost,scope:this,stateManager:{name:"selected_one_clean", dc:"payment" , and: function(dc) {return (dc.record && dc.record.get("confirmed") &&  dc.record.get("confirmed") && dc.record.get("posted") );}}	})	
							 	
		.addDcFilterFormView("payment",{ name:"paymentFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.PaymentIn$Filter",height:130})	 
		.addDcGridView("payment",{ name:"paymentList", xtype:"net.nan21.dnet.module.sd.invoice.dc.PaymentIn$List"})	 
		.addDcFormView("payment",{ name:"paymentEdit", xtype:"net.nan21.dnet.module.sd.invoice.dc.PaymentIn$Edit",height:200,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnConfirm") ,this._elems_.get("btnUnConfirm") ,this._elems_.get("btnPost") ,this._elems_.get("btnUnPost") ]}]})	 
		.addDcEditGridView("item",{ name:"itemList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$CtxEditListAccItem", frame:true,title:"G/L Items"})	 
		.addDcEditGridView("itemp",{ name:"prodList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$CtxEditListProduct", frame:true,title:"Products"})	 
		.addDcGridView("accDocLine",{ name:"accDocLineList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx$List"})	 
		.addDcFilterFormView("accDocLine",{ name:"accDocLineFilter", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccDocLineCtx$Filter",width:250,title:"Filter", collapsible:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "paymentDetailsTab", xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "accDocPanel", layout:"border", defaults:{split:true},title:"Accounting"})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["paymentFilter","paymentList"] ,["north","center"])	
		.addChildrenTo("canvas2",["paymentEdit","paymentDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("paymentDetailsTab", ["itemList","prodList","accDocPanel"]) 				 		
		.addChildrenTo("accDocPanel",["accDocLineFilter","accDocLineList"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbPaymentList")	  	
	 	.addToolbarTo("canvas2","tlbPaymentEdit")	  	
	 	.addToolbarTo("itemList","tlbItemList")	  	
	 	.addToolbarTo("prodList","tlbProdList")	  	
	 	.addToolbarTo("accDocLineList","tlbAccDocLineList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPaymentList", {dc:"payment"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Payments In"}).end()
			.beginToolbar("tlbPaymentEdit", {dc:"payment"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Payment In"}).end()
			.beginToolbar("tlbItemList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"G/L Items"}).end()
			.beginToolbar("tlbProdList", {dc:"itemp"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Products"}).end()
			.beginToolbar("tlbAccDocLineList", {dc:"accDocLine"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end(); 	
	}


	,onBtnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("payment").doService("confirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnUnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("payment").doService("unConfirm", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnPost: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("payment").doService("post", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnUnPost: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("payment").doService("unPost", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
