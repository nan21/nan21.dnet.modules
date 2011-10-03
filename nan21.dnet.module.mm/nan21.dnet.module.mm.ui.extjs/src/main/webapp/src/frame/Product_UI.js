Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductDs", "nan21.dnet.module.mm.ui.extjs/dc/Product", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeValueDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeValue", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttachmentDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttachment","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeGroup","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomMassLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomMass","nan21.dnet.module.bd.ui.extjs/ds/UomVolumeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomVolume","nan21.dnet.module.bd.ui.extjs/ds/UomLengthLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomLength","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeGroup","nan21.dnet.module.mm.ui.extjs/ds/ProductAttachmentTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttachmentType","nan21.dnet.module.mm.ui.extjs/asgn/CategoriesOfProduct"]);

Ext.define("net.nan21.dnet.module.mm.md.frame.Product_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.md.frame.Product_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.md.frame.Product_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prod", new net.nan21.dnet.module.mm.md.dc.Product({}))
		.addDc("attr", new net.nan21.dnet.module.mm.md.dc.ProductAttributeValue({multiEdit:true}))
		.addDc("atch", new net.nan21.dnet.module.mm.md.dc.ProductAttachment({multiEdit:true}))		
		.linkDc("attr", "prod",{fields:[ {childField:"productId", parentField:"id"} ]} )
		.linkDc("atch", "prod",{fields:[ {childField:"productId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addButton({name:"btnAsgnCategories",text:"Assign Categories", tooltip:"Add product to categories",disabled:true
			,handler: this.onBtnAsgnCategories,scope:this,stateManager:{name:"record_is_clean", dc:"prod" }	})	
							 	
		.addDcFilterFormView("prod",{ name:"prodFilter", xtype:"net.nan21.dnet.module.mm.md.dc.Product$Filter"})	 
		.addDcView("prod",{ name:"prodList", xtype:"net.nan21.dnet.module.mm.md.dc.Product$List"})	 
		.addDcFormView("prod",{ name:"prodEdit", xtype:"net.nan21.dnet.module.mm.md.dc.Product$Edit",height:200,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnAsgnCategories") ]}})	 
		.addDcFormView("prod",{ name:"prodCtxFormName", xtype:"net.nan21.dnet.module.mm.md.dc.Product$CtxFormName",height:50})	 
		.addDcView("attr",{ name:"attrEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList", frame:true,title:"Attributes"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttachment$EditList", frame:true,title:"Attachments",buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnViewAttachment") ]}})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "prodDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["prodFilter","prodList","prodCtxFormName"] ,["north","center","south"])	
		.addChildrenTo("canvas2",["prodEdit","prodDetailsTab"] ,["north","center"])	
	 	.addChildrenTo("prodDetailsTab", ["attrEditList","atchEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbProdList")	  	
	 	.addToolbarTo("canvas2","tlbProdEdit")	  	
	 	.addToolbarTo("attrEditList","tlbAttrEditList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProdList", {dc:"prod"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbProdEdit", {dc:"prod"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbAttrEditList", {dc:"attr"}).addQuery().addSave().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attributes"}).end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addSeparator().addSeparator().addTitle({"text":"Attachments"}).end(); 	
	}


	,onBtnAsgnCategories: function() {
		this.showAsgnWindow(net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Ui ,{dc:"prod",objectIdField:"id"});
	}					 	
	,onBtnViewAttachment: function() {	
		
		var url = this._getDc_("atch").getRecord().get("url");
		window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
});  
