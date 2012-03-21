Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoice", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceItemDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceItem", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/LocationToBillLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToBill","nan21.dnet.module.bp.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.bp.ui.extjs/lov/BpContacts","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("inv", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoice({}))
		.addDc("item", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))		
		.linkDc("item", "inv",{fields:[ {childField:"invoiceId", parentField:"id"} ]} )
		.linkDc("note", "inv",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("atch", "inv",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"entityFQN"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addDcFilterFormView("inv",{ name:"invFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter",height:150})	 
		.addDcGridView("inv",{ name:"invList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List"})	 
		.addDcFormView("inv",{ name:"invEdit", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit",height:150})	 
		.addDcEditGridView("item",{ name:"itemEditList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$EditList", frame:true,title:"Items"})	 
		.addDcGridView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcEditGridView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "invDetailsTab", xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Notes"})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["invFilter","invList"] ,["north","center"])	
		.addChildrenTo("canvas2",["invEdit","invDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("invDetailsTab", ["itemEditList","atchEditList","notesPanel"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbInvList")	  	
	 	.addToolbarTo("canvas2","tlbInvEdit")	  	
	 	.addToolbarTo("itemEditList","tlbItemEditList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvList", {dc:"inv"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Sales invoices"}).end()
			.beginToolbar("tlbInvEdit", {dc:"inv"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Sales invoice"}).end()
			.beginToolbar("tlbItemEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Items"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().addReports().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().addReports().end(); 	
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
	,refreshHeader: function() {	
		
		this._getDc_("item").on("afterDoSaveSuccess", 
		function() {
			this._getDc_("inv").doRefreshCurrent();
		} , this );
	}
	,_afterDefineDcs_: function() {	
		this.refreshHeader();
	}
});  
