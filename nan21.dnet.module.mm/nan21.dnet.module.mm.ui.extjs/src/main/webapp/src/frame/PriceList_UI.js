Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/PriceListTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/PriceListType", "nan21.dnet.module.mm.ui.extjs/ds/PriceListDs", "nan21.dnet.module.mm.ui.extjs/dc/PriceList","nan21.dnet.module.mm.ui.extjs/ds/PriceListTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/PriceListTypes","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies"]);

Ext.define("net.nan21.dnet.module.mm.price.frame.PriceList_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.price.frame.PriceList_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.price.frame.PriceList_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("type", new net.nan21.dnet.module.mm.price.dc.PriceListType({}))
		.addDc("pricelist", new net.nan21.dnet.module.mm.price.dc.PriceList({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("type",{ name:"typeFilter", xtype:"net.nan21.dnet.module.mm.price.dc.PriceListType$Filter"})	 
		.addDcView("type",{ name:"typeEditList", xtype:"net.nan21.dnet.module.mm.price.dc.PriceListType$EditList", frame:true})	 
		.addDcFilterFormView("pricelist",{ name:"pricelistFilter", xtype:"net.nan21.dnet.module.mm.price.dc.PriceList$Filter"})	 
		.addDcView("pricelist",{ name:"pricelistEditList", xtype:"net.nan21.dnet.module.mm.price.dc.PriceList$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasPriceList", layout:"border", defaults:{split:true},title:"Price lists",preventHeader:true})  	 
		.addPanel({name: "canvasType", layout:"border", defaults:{split:true},title:"Price list types",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasPriceList","canvasType"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasPriceList","canvasType"]) 				 		
		.addChildrenTo("canvasPriceList",["pricelistFilter","pricelistEditList"] ,["north","center"])	
		.addChildrenTo("canvasType",["typeFilter","typeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasPriceList","tlbPricelistEditList")	  	
	 	.addToolbarTo("canvasType","tlbTypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPricelistEditList", {dc:"pricelist"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Price lists"}).end()
			.beginToolbar("tlbTypeEditList", {dc:"type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Price list types"}).end(); 	
	}

});  
