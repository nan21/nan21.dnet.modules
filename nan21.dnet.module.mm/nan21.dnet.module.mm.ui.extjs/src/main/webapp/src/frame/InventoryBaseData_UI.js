Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/StockLocatorTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/StockLocatorType", "nan21.dnet.module.mm.ui.extjs/ds/InvTransactionSourceTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/InvTransactionSourceType", "nan21.dnet.module.mm.ui.extjs/ds/InvTransactionActionDs", "nan21.dnet.module.mm.ui.extjs/dc/InvTransactionAction", "nan21.dnet.module.mm.ui.extjs/ds/InvTransactionTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/InvTransactionType","nan21.dnet.module.mm.ui.extjs/ds/InvTransactionSourceTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/InvTransactionSourceTypeS","nan21.dnet.module.mm.ui.extjs/ds/InvTransactionActionLovDs","nan21.dnet.module.mm.ui.extjs/lov/InvTransactionActions","nan21.dnet.module.mm.ui.extjs/ds/InvTransactionSourceTypeLovDs","nan21.dnet.module.mm.ui.extjs/lov/InvTransactionSourceTypeS","nan21.dnet.module.mm.ui.extjs/ds/InvTransactionActionLovDs","nan21.dnet.module.mm.ui.extjs/lov/InvTransactionActions"]);

Ext.define("net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("sloctype", new net.nan21.dnet.module.mm.inventory.dc.StockLocatorType({multiEdit:true}))
		.addDc("txsrctype", new net.nan21.dnet.module.mm.inventory.dc.InvTransactionSourceType({multiEdit:true}))
		.addDc("txaction", new net.nan21.dnet.module.mm.inventory.dc.InvTransactionAction({multiEdit:true}))
		.addDc("txtype", new net.nan21.dnet.module.mm.inventory.dc.InvTransactionType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("sloctype",{ name:"sloctypeFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.StockLocatorType$Filter",height:40})	 
		.addDcView("sloctype",{ name:"sloctypeEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.StockLocatorType$EditList", frame:true})	 
		.addDcFilterFormView("txsrctype",{ name:"txsrctypeFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionSourceType$Filter",height:40})	 
		.addDcView("txsrctype",{ name:"txsrctypeEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionSourceType$EditList", frame:true})	 
		.addDcFilterFormView("txaction",{ name:"txactionFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionAction$Filter",height:40})	 
		.addDcView("txaction",{ name:"txactionEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionAction$EditList", frame:true})	 
		.addDcFilterFormView("txtype",{ name:"txtypeFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter",height:70})	 
		.addDcView("txtype",{ name:"txtypeEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasSloctype", layout:"border", defaults:{split:true},title:"Locator types",preventHeader:true})  	 
		.addPanel({name: "canvasTxsrctype", layout:"border", defaults:{split:true},title:"Transaction source type",preventHeader:true})  	 
		.addPanel({name: "canvasTxaction", layout:"border", defaults:{split:true},title:"Transaction action",preventHeader:true})  	 
		.addPanel({name: "canvasTxtype", layout:"border", defaults:{split:true},title:"Transaction type",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasSloctype","canvasTxsrctype","canvasTxaction","canvasTxtype"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasSloctype","canvasTxsrctype","canvasTxaction","canvasTxtype"]) 				 		
		.addChildrenTo("canvasSloctype",["sloctypeFilter","sloctypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasTxsrctype",["txsrctypeFilter","txsrctypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasTxaction",["txactionFilter","txactionEditList"] ,["north","center"])	
		.addChildrenTo("canvasTxtype",["txtypeFilter","txtypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasSloctype","tlbSloctypeEditList")	  	
	 	.addToolbarTo("canvasTxsrctype","tlbTxsrctypeEditList")	  	
	 	.addToolbarTo("canvasTxaction","tlbTxactionEditList")	  	
	 	.addToolbarTo("canvasTxtype","tlbTxtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSloctypeEditList", {dc:"sloctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Locator types"}).end()
			.beginToolbar("tlbTxsrctypeEditList", {dc:"txsrctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Transaction source type"}).end()
			.beginToolbar("tlbTxactionEditList", {dc:"txaction"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Transaction action"}).end()
			.beginToolbar("tlbTxtypeEditList", {dc:"txtype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Transaction type"}).end(); 	
	}

});  
