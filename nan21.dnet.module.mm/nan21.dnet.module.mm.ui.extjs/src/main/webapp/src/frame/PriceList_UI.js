Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/PriceListDs", "nan21.dnet.module.mm.ui.extjs/dc/PriceList", "nan21.dnet.module.mm.ui.extjs/ds/PriceListVersionDs", "nan21.dnet.module.mm.ui.extjs/dc/PriceListVersion", "nan21.dnet.module.mm.ui.extjs/ds/ProductPriceDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductPrice","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasureCode"]);

Ext.define("net.nan21.dnet.module.mm.price.frame.PriceList_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.price.frame.PriceList_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.price.frame.PriceList_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("pricelist", new net.nan21.dnet.module.mm.price.dc.PriceList({multiEdit:true}))
		.addDc("version", new net.nan21.dnet.module.mm.price.dc.PriceListVersion({multiEdit:true}))
		.addDc("price", new net.nan21.dnet.module.mm.price.dc.ProductPrice({multiEdit:true}))		
		.linkDc("version", "pricelist",{fields:[ {childField:"priceListId", parentField:"id"} ]} )
		.linkDc("price", "version",{fields:[ {childField:"priceListVersionId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnShowCanvas2",text:"Product prices", tooltip:"Product prices",disabled:true
			,handler: this.onShowCanvas2,scope:this,stateManager:{name:"selected_one_clean", dc:"version" }	})	
							 	
		.addButton({name:"btnAddProdByCateg",text:"Add from category ", tooltip:"Add products from product category",disabled:false
			,handler: this.onBtnAddProdByCateg,scope:this	})	
							 	
		.addButton({name:"btnAddProdByCategExec",text:"OK", tooltip:"Add products from the selected product category",disabled:false
			,handler: this.onBtnAddProdByCategExec,scope:this	})	
							 	
		.addDcFilterFormView("pricelist",{ name:"pricelistFilter", xtype:"net.nan21.dnet.module.mm.price.dc.PriceList$FilterH",height:80})	 
		.addDcView("pricelist",{ name:"pricelistEditList", xtype:"net.nan21.dnet.module.mm.price.dc.PriceList$EditList", frame:true})	 
		.addDcView("version",{ name:"versionEditList", xtype:"net.nan21.dnet.module.mm.price.dc.PriceListVersion$CtxEditList", frame:true,height:250,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnShowCanvas2") ]}]})	 
		.addDcFormView("version",{ name:"versionView", xtype:"net.nan21.dnet.module.mm.price.dc.PriceListVersion$CtxView",height:100,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAddProdByCateg") ]}]})	 
		.addDcFormView("version",{ name:"versionCopyProdFromCateg", xtype:"net.nan21.dnet.module.mm.price.dc.PriceListVersion$CopyProductsFromCategory",height:100})	 
		.addDcFilterFormView("price",{ name:"priceFilter", xtype:"net.nan21.dnet.module.mm.price.dc.ProductPrice$Filter",height:50})	 
		.addDcView("price",{ name:"priceEditList", xtype:"net.nan21.dnet.module.mm.price.dc.ProductPrice$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "pricePanel", layout:"border", defaults:{split:true}})  	 
		
		.addWindow({name:"wdwVersionCopyProdFromCateg", closable:true, closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("versionCopyProdFromCateg")]
,title:"Select product category",modal:true,width:400,height:100,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnAddProdByCategExec") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["pricelistFilter","pricelistEditList","versionEditList"] ,["north","center","south"])	
		.addChildrenTo("canvas2",["versionView","pricePanel"] ,["north","center"])	
		.addChildrenTo("pricePanel",["priceFilter","priceEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbPricelistEditList")	  	
	 	.addToolbarTo("versionEditList","tlbVersionEditList")	  	
	 	.addToolbarTo("canvas2","tlbVersionView")	  	
	 	.addToolbarTo("pricePanel","tlbPriceEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPricelistEditList", {dc:"pricelist"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbVersionEditList", {dc:"version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbVersionView", {dc:"version"}).addBack().addPrevRec().addNextRec().addSeparator().addAutoLoad().end()
			.beginToolbar("tlbPriceEditList", {dc:"price"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}


	,onBtnAddProdByCateg: function() {
this._getWindow_("wdwVersionCopyProdFromCateg").show();			 	
	}					 	

	,onBtnAddProdByCategExec: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 	this._getWindow_("wdwVersionCopyProdFromCateg").close();			 	
;	this._getDc_("price").doQuery();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("version").doService("addProductsFromCategory", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
	,onShowCanvas2: function() {	
		this._getElement_("main").getLayout().setActiveItem(1);
	}
});  
