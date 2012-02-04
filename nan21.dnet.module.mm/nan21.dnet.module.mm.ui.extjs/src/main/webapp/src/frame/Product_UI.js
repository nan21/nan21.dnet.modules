Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductDs", "nan21.dnet.module.mm.ui.extjs/dc/Product", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeValueDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeValue", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment", "nan21.dnet.module.mm.ui.extjs/ds/ProdClassificationDs", "nan21.dnet.module.mm.ui.extjs/dc/ProdClassification", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.ad.ui.extjs/dc/Note","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeGroup","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomMassLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomMass","nan21.dnet.module.bd.ui.extjs/ds/UomVolumeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomVolume","nan21.dnet.module.bd.ui.extjs/ds/UomLengthLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomLength","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeGroup","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes","nan21.dnet.module.bd.ui.extjs/ds/ClassificationSystemLovDs","nan21.dnet.module.bd.ui.extjs/lov/ClassificationSystems","nan21.dnet.module.bd.ui.extjs/ds/ClassificationCodeLovDs","nan21.dnet.module.bd.ui.extjs/lov/ClassificationCodes","nan21.dnet.module.mm.ui.extjs/asgn/CategoriesOfProduct"]);

Ext.define("net.nan21.dnet.module.mm.md.frame.Product_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.md.frame.Product_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.md.frame.Product_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prod", new net.nan21.dnet.module.mm.md.dc.Product({}))
		.addDc("attr", new net.nan21.dnet.module.mm.md.dc.ProductAttributeValue({multiEdit:true}))
		.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
		.addDc("classific", new net.nan21.dnet.module.mm.md.dc.ProdClassification({multiEdit:true}))
		.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))		
		.linkDc("attr", "prod",{fields:[ {childField:"productId", parentField:"id"} ]} )
		.linkDc("atch", "prod",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"entityFQN"} ]} )
		.linkDc("classific", "prod",{fields:[ {childField:"productId", parentField:"id"} ]} )
		.linkDc("note", "prod",{fields:[ {childField:"targetUuid", parentField:"uuid"},{childField:"targetType", parentField:"className"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnUploadAttachment",text:"Upload...", tooltip:"Upload attachment file.",disabled:true
			,handler: this.onBtnUploadAttachment,scope:this,stateManager:{name:"selected_one_clean", dc:"atch" }	})	
							 	
		.addButton({name:"btnAsgnCategories",text:"Assign categories", tooltip:"Add product to categories",disabled:true
			,handler: this.onBtnAsgnCategories,scope:this,stateManager:{name:"record_is_clean", dc:"prod" }	})	
							 	
		.addDcFilterFormView("prod",{ name:"prodFilter", xtype:"net.nan21.dnet.module.mm.md.dc.Product$Filter",height:140})	 
		.addDcView("prod",{ name:"prodList", xtype:"net.nan21.dnet.module.mm.md.dc.Product$List"})	 
		.addDcFormView("prod",{ name:"prodEdit", xtype:"net.nan21.dnet.module.mm.md.dc.Product$Edit",height:180,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAsgnCategories") ]}]})	 
		.addDcFormView("prod",{ name:"prodEditInfo", xtype:"net.nan21.dnet.module.mm.md.dc.Product$EditInfo",title:"Details"})	 
		.addDcFormView("prod",{ name:"prodCtxFormName", xtype:"net.nan21.dnet.module.mm.md.dc.Product$CtxFormName",height:50})	 
		.addDcView("attr",{ name:"attrEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$CtxEditList", frame:true,title:"Attributes"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.ad.data.dc.Attachment$CtxEditList", frame:true,title:"Attachments",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnViewAttachment") ,this._elems_.get("btnUploadAttachment") ]}]})	 
		.addDcView("classific",{ name:"classificEdit", xtype:"net.nan21.dnet.module.mm.md.dc.ProdClassification$CtxEditList", frame:true,title:"Classifications"})	 
		.addDcView("note",{ name:"noteList", xtype:"net.nan21.dnet.module.ad.data.dc.Note$List",width:300})	 
		.addDcFormView("note",{ name:"noteEdit", xtype:"net.nan21.dnet.module.ad.data.dc.Note$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "prodDetailsTab", xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true,onActivateDoLayoutFor:["prodDetailsTab"]})  	 
		.addPanel({name: "notesPanel", layout:"border", defaults:{split:true},title:"Notes"})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["prodFilter","prodList","prodCtxFormName"] ,["north","center","south"])	
		.addChildrenTo("canvas2",["prodEdit","prodDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("prodDetailsTab", ["prodEditInfo","attrEditList","classificEdit","atchEditList","notesPanel"]) 				 		
		.addChildrenTo("notesPanel",["noteList","noteEdit"] ,["west","center"])	
	 	.addToolbarTo("canvas1","tlbProdList")	  	
	 	.addToolbarTo("canvas2","tlbProdEdit")	  	
	 	.addToolbarTo("attrEditList","tlbAttrEditList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	 	.addToolbarTo("classificEdit","tlbClassific")	  	
	 	.addToolbarTo("noteList","tlbNoteList")	  	
	 	.addToolbarTo("noteEdit","tlbNoteEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProdList", {dc:"prod"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"Products"}).end()
			.beginToolbar("tlbProdEdit", {dc:"prod"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Product"}).end()
			.beginToolbar("tlbAttrEditList", {dc:"attr"}).addQuery().addSave().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attributes"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end()
			.beginToolbar("tlbClassific", {dc:"classific"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Classifications"}).end()
			.beginToolbar("tlbNoteList", {dc:"note"}).addQuery().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbNoteEdit", {dc:"note"}).addSave().addNew().addCancel().addSeparator().addAutoLoad().end(); 	
	}


	,onBtnAsgnCategories: function() {
		this.showAsgnWindow(net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Ui ,{dc:"prod",objectIdField:"id"});
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
});  
