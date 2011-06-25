Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerDs", "nan21.dnet.module.bp.ui.extjs/dc/BusinessPartner", "nan21.dnet.module.bp.ui.extjs/ds/ContactDs", "nan21.dnet.module.bp.ui.extjs/dc/Contact", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.bp.ui.extjs/ds/BpBankAccountDs", "nan21.dnet.module.bp.ui.extjs/dc/BpBankAccount", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs","nan21.dnet.module.bd.ui.extjs/lov/Regions","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bp.ui.extjs/ds/BankLovDs","nan21.dnet.module.bp.ui.extjs/lov/Banks","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes"]);

Ext.ns("net.nan21.dnet.module.bp.md.frame");
net.nan21.dnet.module.bp.md.frame.BPartner_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.md.frame.BPartner_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("bp", new net.nan21.dnet.module.bp.md.dc.BusinessPartner())
		.addDc("bpContact", new net.nan21.dnet.module.bp.md.dc.Contact({multiEdit:true}))
		.addDc("address", new net.nan21.dnet.module.bd.geo.dc.Location())
		.addDc("bpBankAcct", new net.nan21.dnet.module.bp.md.dc.BpBankAccount({multiEdit:true}))
		.addDc("bpPhone", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}))		
		.linkDc("bpContact", "bp",{fields:[ {childField:"bpartnerId", parentField:"id"} ]} )
		.linkDc("address", "bp",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("bpBankAcct", "bp",{fields:[ {childField:"bpartnerId", parentField:"id"} ]} )
		.linkDc("bpPhone", "bp",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("bp",{ name:"bpFilter", xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$Filter"})	 
		.addDcView("bp",{ name:"bpList", xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$List"})	 
		.addDcView("bp",{ name:"bpEdit", xtype:"net.nan21.dnet.module.bp.md.dc.BusinessPartner$Edit",height:120})	 
		.addDcView("bpContact",{ name:"bpContactEditList", xtype:"net.nan21.dnet.module.bp.md.dc.Contact$CtxEditList", frame:true,title:"Contact"})	 
		.addDcView("address",{ name:"addressList", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$ListCtx"})	 
		.addDcView("address",{ name:"addressEdit", xtype:"net.nan21.dnet.module.bd.geo.dc.Location$EditCtx"})	 
		.addDcView("bpBankAcct",{ name:"bpBankAccountEditList", xtype:"net.nan21.dnet.module.bp.md.dc.BpBankAccount$CtxEditList", frame:true,title:"Bank account"})	 
		.addDcView("bpPhone",{ name:"bpPhoneEditList", xtype:"net.nan21.dnet.module.bd.contact.dc.CommunicationChannel$EditList", frame:true,title:"Communication"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "addressPanel",layout:"card", activeItem:0,title:"Address"})  	 
		.addPanel({name: "bpDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
		.addPanel({name: "addressEditWrapper", layout:"fit"})
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["bpFilter","bpList"] ,["north","center"])	
		.addChildrenTo("canvas2",["bpEdit","bpDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("bpDetailsTab", ["bpPhoneEditList","addressPanel","bpContactEditList","bpBankAccountEditList"]) 				 		
	 	.addChildrenTo("addressPanel", ["addressList","addressEditWrapper"]) 				 		
	 	.addChildrenTo("addressEditWrapper", ["addressEdit"]) 				 		
	 	.addToolbarTo("canvas1","tlbBpList")	  	
	 	.addToolbarTo("canvas2","tlbBpEdit")	  	
	 	.addToolbarTo("bpContactEditList","tlbBpContactList")	  	
	 	.addToolbarTo("addressList","tlbAddressList")	  	
	 	.addToolbarTo("addressEditWrapper","tlbAddressEdit")	  	
	 	.addToolbarTo("bpBankAccountEditList","tlbBpBankAccountList")	  	
	 	.addToolbarTo("bpPhoneEditList","tlbBpPhoneNumber")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbBpList", {dc:"bp"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbBpEdit", {dc:"bp"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbBpContactList", {dc:"bpContact"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbAddressList", {dc:"address"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbAddressEdit", {dc:"address"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbBpBankAccountList", {dc:"bpBankAcct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbBpPhoneNumber", {dc:"bpPhone"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.bp.md.frame.BPartner_UI", net.nan21.dnet.module.bp.md.frame.BPartner_UI);   
