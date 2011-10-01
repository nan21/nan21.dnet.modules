Dnet.doImport(["", "nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerDs", "nan21.dnet.module.bp.ui.extjs/dc/BusinessPartner", "nan21.dnet.module.bp.ui.extjs/ds/ContactDs", "nan21.dnet.module.bp.ui.extjs/dc/Contact", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.bp.ui.extjs/ds/BpClassificationDs", "nan21.dnet.module.bp.ui.extjs/dc/BpClassification", "nan21.dnet.module.bp.ui.extjs/ds/BpBankAccountDs", "nan21.dnet.module.bp.ui.extjs/dc/BpBankAccount", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs","nan21.dnet.module.bd.ui.extjs/lov/Regions","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bp.ui.extjs/ds/BankLovDs","nan21.dnet.module.bp.ui.extjs/lov/Banks","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes","nan21.dnet.module.bd.ui.extjs/ds/ClassificationSystemLovDs","nan21.dnet.module.bd.ui.extjs/lov/ClassificationSystems","nan21.dnet.module.bd.ui.extjs/ds/ClassificationCodeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ClassificationCodes"]);

Ext.define("net.nan21.dnet.module.bp.md.frame.BPartner_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bp.md.frame.BPartner_UI",
	
	 _name_ : "net.nan21.dnet.module.bp.md.frame.BPartner_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("bp", new net.nan21.dnet.module.bp.md.dc.BusinessPartner({}))
		.addDc("bpContact", new net.nan21.dnet.module.bp.md.dc.Contact({multiEdit:true}))
		.addDc("address", new net.nan21.dnet.module.bd.geo.dc.Location({}))
		.addDc("classific", new net.nan21.dnet.module.bp.md.dc.BpClassification({}))
		.addDc("bpBankAcct", new net.nan21.dnet.module.bp.md.dc.BpBankAccount({multiEdit:true}))
		.addDc("bpPhone", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}))		
		.linkDc("bpContact", "bp",{fields:[ {childField:"bpartnerId", parentField:"id"} ]} )
		.linkDc("address", "bp",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("classific", "bp",{fields:[ {childField:"businessPartnerId", parentField:"id"} ]} )
		.linkDc("bpBankAcct", "bp",{fields:[ {childField:"bpartnerId", parentField:"id"} ]} )
		.linkDc("bpPhone", "bp",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("bp",{ name:"bpFilter", xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter"})	 
		.addDcView("bp",{ name:"bpList", xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$List"})	 
		.addDcFormView("bp",{ name:"bpEdit", xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit",height:120})	 
		.addDcView("bpContact",{ name:"bpContactEditList", xtype:"net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList", frame:true,title:"Contact"})	 
		.addDcView("address",{ name:"addressList", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$ListCtx"})	 
		.addDcFormView("address",{ name:"addressEdit", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$EditCtx"})	 
		.addDcView("bpBankAcct",{ name:"bpBankAccountEditList", xtype:"net.nan21.dnet.module.bp.md.dc.BpBankAccount$CtxEditList", frame:true,title:"Bank account"})	 
		.addDcView("bpPhone",{ name:"bpPhoneEditList", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", frame:true,title:"Communication"})	 
		.addDcView("classific",{ name:"classificEdit", xtype:"net.nan21.dnet.module.bp.md.dc.BpClassification$CtxEditList", frame:true,title:"Classifications"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "addressPanel",layout:"card", activeItem:0,title:"Address"})  	 
		.addPanel({name: "bpDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
		.addPanel({name: "addressEditWrapper", layout:"fit"})
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["bpFilter","bpList"] ,["north","center"])	
		.addChildrenTo("canvas2",["bpEdit","bpDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("bpDetailsTab", ["bpPhoneEditList","addressPanel","bpContactEditList","bpBankAccountEditList","classificEdit"]) 				 		
	 	.addChildrenTo("addressPanel", ["addressList","addressEditWrapper"]) 				 		
	 	.addChildrenTo("addressEditWrapper", ["addressEdit"]) 				 		
	 	.addToolbarTo("canvas1","tlbBpList")	  	
	 	.addToolbarTo("canvas2","tlbBpEdit")	  	
	 	.addToolbarTo("bpContactEditList","tlbBpContactList")	  	
	 	.addToolbarTo("addressList","tlbAddressList")	  	
	 	.addToolbarTo("addressEditWrapper","tlbAddressEdit")	  	
	 	.addToolbarTo("bpBankAccountEditList","tlbBpBankAccountList")	  	
	 	.addToolbarTo("bpPhoneEditList","tlbBpPhoneNumber")	  	
	 	.addToolbarTo("classificEdit","tlbClassific")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbBpList", {dc:"bp"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbBpEdit", {dc:"bp"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbBpContactList", {dc:"bpContact"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Contact"}).end()
			.beginToolbar("tlbAddressList", {dc:"address"}).addQuery().addEdit({inContainer:"addressPanel",showView:"addressEditWrapper"}).addNew().addCopy().addDeleteSelected().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbAddressEdit", {dc:"address"}).addBack({inContainer:"addressPanel",showView:"addressList"}).addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbBpBankAccountList", {dc:"bpBankAcct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Bank account"}).end()
			.beginToolbar("tlbBpPhoneNumber", {dc:"bpPhone"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Communication"}).end()
			.beginToolbar("tlbClassific", {dc:"classific"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Classifications"}).end(); 	
	}

});  
