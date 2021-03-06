Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerDs", "nan21.dnet.module.md.ui.extjs/dc/BusinessPartner", "nan21.dnet.module.md.ui.extjs/ds/TxBalanceDs", "nan21.dnet.module.md.ui.extjs/dc/TxBalance", "nan21.dnet.module.md.ui.extjs/ds/BpAccountDs", "nan21.dnet.module.md.ui.extjs/dc/BpAccount", "nan21.dnet.module.md.ui.extjs/ds/BpAccountAcctDs", "nan21.dnet.module.md.ui.extjs/dc/BpAccountAcct", "nan21.dnet.module.md.ui.extjs/ds/ContactDs", "nan21.dnet.module.md.ui.extjs/dc/Contact", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.md.ui.extjs/ds/BpClassificationDs", "nan21.dnet.module.md.ui.extjs/dc/BpClassification", "nan21.dnet.module.md.ui.extjs/ds/BpBankAccountDs", "nan21.dnet.module.md.ui.extjs/dc/BpBankAccount", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.md.ui.extjs/ds/CompanyLegalFormLovDs","nan21.dnet.module.md.ui.extjs/lov/CompanyLegalForms","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/CustomerGroupLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomerGroup","nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentMethod","nan21.dnet.module.md.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentTerm","nan21.dnet.module.md.ui.extjs/ds/VendorGroupLovDs","nan21.dnet.module.md.ui.extjs/lov/VendorGroup","nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentMethod","nan21.dnet.module.md.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs","nan21.dnet.module.bd.ui.extjs/lov/Regions","nan21.dnet.module.md.ui.extjs/ds/CompanyLegalFormLovDs","nan21.dnet.module.md.ui.extjs/lov/CompanyLegalForms","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/BankLovDs","nan21.dnet.module.md.ui.extjs/lov/Banks","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes","nan21.dnet.module.bd.ui.extjs/ds/ClassificationSystemLovDs","nan21.dnet.module.bd.ui.extjs/lov/ClassificationSystems","nan21.dnet.module.bd.ui.extjs/ds/ClassificationItemLovDs","nan21.dnet.module.bd.ui.extjs/lov/ClassificationItems","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.md.bp.frame.BPartner_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.bp.frame.BPartner_UI",
	
	 _name_ : "net.nan21.dnet.module.md.bp.frame.BPartner_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("bp", new net.nan21.dnet.module.md.bp.dc.BusinessPartner({}))
		.addDc("balance", new net.nan21.dnet.module.md.tx.fin.dc.TxBalance({}))
		.addDc("account", new net.nan21.dnet.module.md.bp.dc.BpAccount({}))
		.addDc("acct", new net.nan21.dnet.module.md.bp.dc.BpAccountAcct({multiEdit:true}))
		.addDc("bpContact", new net.nan21.dnet.module.md.bp.dc.Contact({multiEdit:true}))
		.addDc("address", new net.nan21.dnet.module.bd.geo.dc.Location({}))
		.addDc("classific", new net.nan21.dnet.module.md.bp.dc.BpClassification({multiEdit:true}))
		.addDc("bpBankAcct", new net.nan21.dnet.module.md.bp.dc.BpBankAccount({multiEdit:true}))
		.addDc("bpPhone", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))		
		.linkDc("balance", "bp",{fields:[ {childField:"businessPartnerId", parentField:"id"} ]} )
		.linkDc("account", "bp",{fields:[ {childField:"businessPartnerId", parentField:"id"} ]} )
		.linkDc("acct", "account",{fields:[ {childField:"bpAccountId", parentField:"id"} ]} )
		.linkDc("bpContact", "bp",{fields:[ {childField:"bpartnerId", parentField:"id"} ]} )
		.linkDc("address", "bp",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("classific", "bp",{fields:[ {childField:"businessPartnerId", parentField:"id"},{childField:"businessPartnerBO", parentField:"businessObject"} ]} )
		.linkDc("bpBankAcct", "bp",{fields:[ {childField:"bpartnerId", parentField:"id"} ]} )
		.linkDc("bpPhone", "bp",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("note", "bp",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("atch", "bp",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"businessObject"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnCreateBpContinue",text:"Continue", tooltip:"Continue",disabled:false
			,handler: this.onBtnCreateBpContinue,scope:this	})	
							 	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnShowAccounts",text:"Accounting", tooltip:"Accounting",disabled:false
			,handler: this.onBtnShowAccounts,scope:this	})	
							 	
		.addDcFilterFormView("bp",{ name:"bpFilter", xtype:"net.nan21.dnet.module.md.bp.dc.BusinessPartner$Filter",height:200})	 
		.addDcGridView("bp",{ name:"bpList", xtype:"net.nan21.dnet.module.md.bp.dc.BusinessPartner$List"})	 
		.addDcFormView("bp",{ name:"bpCreate", xtype:"net.nan21.dnet.module.md.bp.dc.BusinessPartner$Create"})	 
		.addDcFormView("bp",{ name:"bpEdit", xtype:"net.nan21.dnet.module.md.bp.dc.BusinessPartner$Edit",height:160})	 
		.addDcGridView("account",{ name:"accountList", xtype:"net.nan21.dnet.module.md.bp.dc.BpAccount$List"})	 
		.addDcFormView("account",{ name:"accountEdit", xtype:"net.nan21.dnet.module.md.bp.dc.BpAccount$EditCtx",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnShowAccounts") ]}]})	 
		.addDcEditGridView("acct",{ name:"acctEditList", xtype:"net.nan21.dnet.module.md.bp.dc.BpAccountAcct$EditList", frame:true})	 
		.addDcGridView("balance",{ name:"balanceList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.TxBalance$CtxList",title:"Balance"})	 
		.addDcEditGridView("bpContact",{ name:"bpContactEditList", xtype:"net.nan21.dnet.module.md.bp.dc.Contact$CtxEditList", frame:true,title:"Contact"})	 
		.addDcGridView("address",{ name:"addressList", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$ListCtx"})	 
		.addDcFormView("address",{ name:"addressEdit", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$EditCtx"})	 
		.addDcEditGridView("bpBankAcct",{ name:"bpBankAccountEditList", xtype:"net.nan21.dnet.module.md.bp.dc.BpBankAccount$CtxEditList", frame:true,title:"Bank account"})	 
		.addDcEditGridView("bpPhone",{ name:"bpPhoneEditList", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", frame:true,title:"Communication"})	 
		.addDcEditGridView("classific",{ name:"classificEdit", xtype:"net.nan21.dnet.module.md.bp.dc.BpClassification$CtxEditList", frame:true,title:"Classifications"})	 
		.addDcGridView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcEditGridView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "addressPanel",layout:"card", activeItem:0,title:"Address"})  	 
		.addPanel({name: "accountPanel",layout:"card", activeItem:0,title:"Account"})  	 

		.addPanel({name: "bpDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true,onActivateDoLayoutFor:["bpEdit","bpDetailsTab"]})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Notes"})  	 
		.addPanel({name: "addressEditWrapper", layout:"fit"})
		.addPanel({name: "accountEditWrapper", layout:"fit"})
		
		.addWindow({name:"wdwBpCreate", closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("bpCreate")]
,title:"Select type",modal:true,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnCreateBpContinue") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["bpFilter","bpList"] ,["north","center"])	
		.addChildrenTo("canvas2",["bpEdit","bpDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("bpDetailsTab", ["accountPanel","bpPhoneEditList","addressPanel","bpContactEditList","bpBankAccountEditList","classificEdit","balanceList","atchEditList","notesPanel"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addChildrenTo("addressPanel", ["addressList","addressEditWrapper"]) 				 		
	 	.addChildrenTo("addressEditWrapper", ["addressEdit"]) 				 		
	 	.addChildrenTo("accountPanel", ["accountList","accountEditWrapper","acctEditList"]) 				 		
	 	.addChildrenTo("accountEditWrapper", ["accountEdit"]) 				 		
	 	.addToolbarTo("canvas1","tlbBpList")	  	
	 	.addToolbarTo("canvas2","tlbBpEdit")	  	
	 	.addToolbarTo("accountList","tlbAccountList")	  	
	 	.addToolbarTo("accountEditWrapper","tlbAccountEdit")	  	
	 	.addToolbarTo("acctEditList","tlbAcctList")	  	
	 	.addToolbarTo("bpContactEditList","tlbBpContactList")	  	
	 	.addToolbarTo("addressList","tlbAddressList")	  	
	 	.addToolbarTo("addressEditWrapper","tlbAddressEdit")	  	
	 	.addToolbarTo("bpBankAccountEditList","tlbBpBankAccountList")	  	
	 	.addToolbarTo("bpPhoneEditList","tlbBpPhoneNumber")	  	
	 	.addToolbarTo("classificEdit","tlbClassific")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("balanceList","tlbBalanceList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbBpList", {dc:"bp"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Business partners"}).end()
			.beginToolbar("tlbBpEdit", {dc:"bp"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Business partner"}).end()
			.beginToolbar("tlbAccountList", {dc:"account"}).addQuery().addEdit({inContainer:"accountPanel",showView:"accountEditWrapper"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounts"}).end()
			.beginToolbar("tlbAccountEdit", {dc:"account"}).addBack({inContainer:"accountPanel",showView:"accountList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Account"}).end()
			.beginToolbar("tlbAcctList", {dc:"acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addBack({inContainer:"accountPanel",showView:"accountEditWrapper"}).addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end()
			.beginToolbar("tlbBpContactList", {dc:"bpContact"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Contact"}).end()
			.beginToolbar("tlbAddressList", {dc:"address"}).addQuery().addEdit({inContainer:"addressPanel",showView:"addressEditWrapper"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Addresses"}).end()
			.beginToolbar("tlbAddressEdit", {dc:"address"}).addBack({inContainer:"addressPanel",showView:"addressList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Address"}).end()
			.beginToolbar("tlbBpBankAccountList", {dc:"bpBankAcct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Bank account"}).end()
			.beginToolbar("tlbBpPhoneNumber", {dc:"bpPhone"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Communication"}).end()
			.beginToolbar("tlbClassific", {dc:"classific"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Classifications"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbBalanceList", {dc:"balance"}).addQuery().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Balance"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().addReports().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().addReports().end(); 	
	}


	,onBtnCreateBpContinue: function() {
		this._getWindow_("wdwBpCreate").close();			 	
		this._selectBpEditorForm_();
	}					 	

	,onBtnShowAccounts: function() {
		this.onBtnShowAccounts();
	}					 	
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();			 	
	}
	,_whenCreateNewBp_: function() {	
		this._getWindow_("wdwBpCreate").show();			 	
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
	,_afterDefineDcs_: function() {	
		this._getDc_("bp").on("afterDoNew", this._whenCreateNewBp_, this);
	}
	,_selectBpEditorForm_: function() {	
		this._getElement_("bpEdit").onRecordChange();
	}
	,onBtnViewAttachment: function() {	
		
		var url = this._getDc_("atch").getRecord().get("url");
		window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
	,onBtnShowAccounts: function() {	
		this._showStackedViewElement_("accountPanel", "acctEditList")
	}
});  
