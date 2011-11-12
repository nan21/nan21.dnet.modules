Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrder", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderItemDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderItem", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderType","nan21.dnet.module.sd.ui.extjs/ds/PriceListLovDs","nan21.dnet.module.sd.ui.extjs/lov/PriceLists","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomersName","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartnersName","nan21.dnet.module.bd.ui.extjs/ds/LocationToBillLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToBill","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartnersName","nan21.dnet.module.bd.ui.extjs/ds/LocationToShipLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToShip","nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomersName","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderType","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.sd.order.frame.SalesOrder_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.order.frame.SalesOrder_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.order.frame.SalesOrder_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("order", new net.nan21.dnet.module.sd.order.dc.SalesOrder({}))
		.addDc("item", new net.nan21.dnet.module.sd.order.dc.SalesOrderItem({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))		
		.linkDc("item", "order",{fields:[ {childField:"salesOrderId", parentField:"id"} ]} )
		.linkDc("note", "order",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"className"} ]} )
		.linkDc("atch", "order",{fields:[ {childField:"targetId", parentField:"id"},{childField:"targetType", parentField:"businessObject"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addDcFilterFormView("order",{ name:"orderFilter", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter",height:110})	 
		.addDcView("order",{ name:"orderList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$List"})	 
		.addDcFormView("order",{ name:"orderEdit", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$Edit",height:180})	 
		.addDcView("item",{ name:"itemEditList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderItem$EditList", frame:true,title:"Items"})	 
		.addDcView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "orderDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Notes"})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["orderFilter","orderList"] ,["north","center"])	
		.addChildrenTo("canvas2",["orderEdit","orderDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("orderDetailsTab", ["itemEditList","atchEditList","notesPanel"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbOrderList")	  	
	 	.addToolbarTo("canvas2","tlbOrderEdit")	  	
	 	.addToolbarTo("itemEditList","tlbItemEditList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrderList", {dc:"order"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbOrderEdit", {dc:"order"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbItemEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Items"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().end(); 	
	}

	,onUploadSuccess: function() {	
this._getDc_("atch").doQuery();			 	
	}
	,onBtnUploadAttachment: function() {	
		var w=new dnet.base.FileUploadWindow({
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
			this._getDc_("order").doRefreshCurrent();
		} , this );
	}
	,_afterDefineDcs_: function() {	
		this.refreshHeader();
	}
});  
