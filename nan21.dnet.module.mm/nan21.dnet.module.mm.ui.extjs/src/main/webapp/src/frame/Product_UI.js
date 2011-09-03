Dnet.import(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductDs", "nan21.dnet.module.mm.ui.extjs/dc/Product", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeValueDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttributeValue", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttachmentDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttachment","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomMassLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomMass","nan21.dnet.module.bd.ui.extjs/ds/UomVolumeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomVolume","nan21.dnet.module.bd.ui.extjs/ds/UomLengthLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomLength","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttachmentTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttachmentType"]);

Ext.ns("net.nan21.dnet.module.mm.md.frame");
net.nan21.dnet.module.mm.md.frame.Product_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.mm.md.frame.Product_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prod", new net.nan21.dnet.module.mm.md.dc.Product())
		.addDc("attr", new net.nan21.dnet.module.mm.md.dc.ProductAttributeValue({multiEdit:true}))
		.addDc("atch", new net.nan21.dnet.module.mm.md.dc.ProductAttachment({multiEdit:true}))		
		.linkDc("attr", "prod",{fields:[ {childField:"productId", parentField:"id"} ]} )
		.linkDc("atch", "prod",{fields:[ {childField:"productId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addButton({name:"btnViewAttachment",text:"View", tooltip:"View the selected attachment",iconCls:"icon-action-view",disabled:true
			,handler: this.onBtnViewAttachment,scope:this,stateManager:{name:"selected_one", dc:"atch" }	})	
							 	
		.addDcFilterFormView("prod",{ name:"prodFilter", xtype:"net.nan21.dnet.module.mm.md.dc.Product$Filter"})	 
		.addDcView("prod",{ name:"prodList", xtype:"net.nan21.dnet.module.mm.md.dc.Product$List"})	 
		.addDcFormView("prod",{ name:"prodEdit", xtype:"net.nan21.dnet.module.mm.md.dc.Product$Edit",height:150})	 
		.addDcView("attr",{ name:"attrEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttributeValue$EditList", frame:true,height:200,title:"Attributes"})	 
		.addDcView("atch",{ name:"atchEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttachment$EditList", frame:true,height:200,title:"Attachments",buttons:[ this._elems_.get("btnViewAttachment") ]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "prodDetailsTab", _wrapped_:true, layout:"fit",frame:"true" ,items:{ xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["prodFilter","prodList"] ,["north","center"])	
		.addChildrenTo("canvas2",["prodEdit","prodDetailsTab"] ,["center","south"])	
	 	.addChildrenTo("prodDetailsTab", ["attrEditList","atchEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbProdList")	  	
	 	.addToolbarTo("canvas2","tlbProdEdit")	  	
	 	.addToolbarTo("attrEditList","tlbAttrEditList")	  	
	 	.addToolbarTo("atchEditList","tlbAtchList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProdList", {dc:"prod"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbProdEdit", {dc:"prod"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbAttrEditList", {dc:"attr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbAtchList", {dc:"atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

	,onBtnViewAttachment: function() {	
		
		var url = this._getDc_("atch").getRecord().get("location");
		window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
});
Ext.reg("net.nan21.dnet.module.mm.md.frame.Product_UI", net.nan21.dnet.module.mm.md.frame.Product_UI);   
