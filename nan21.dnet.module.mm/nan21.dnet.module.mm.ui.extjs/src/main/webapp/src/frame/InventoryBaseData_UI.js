Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/StockLocatorTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/StockLocatorType", "nan21.dnet.module.mm.ui.extjs/ds/InvTransactionTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/InvTransactionType","nan21.dnet.module.bd.ui.extjs/ds/FinDocTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/FinDocTypes","nan21.dnet.module.bd.ui.extjs/ds/FinDocTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/FinDocTypes"]);

Ext.define("net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("sloctype", new net.nan21.dnet.module.mm.inventory.dc.StockLocatorType({multiEdit:true}))
		.addDc("txtype", new net.nan21.dnet.module.mm.inventory.dc.InvTransactionType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("sloctype",{ name:"sloctypeFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.StockLocatorType$Filter",height:120})	 
		.addDcEditGridView("sloctype",{ name:"sloctypeEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.StockLocatorType$EditList", frame:true})	 
		.addDcFilterFormView("txtype",{ name:"txtypeFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$Filter",height:120})	 
		.addDcEditGridView("txtype",{ name:"txtypeEditList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvTransactionType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasSloctype", layout:"border", defaults:{split:true},title:"Locator types",preventHeader:true})  	 
		.addPanel({name: "canvasTxtype", layout:"border", defaults:{split:true},title:"Transaction type",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasSloctype","canvasTxtype"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasSloctype","canvasTxtype"]) 				 		
		.addChildrenTo("canvasSloctype",["sloctypeFilter","sloctypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasTxtype",["txtypeFilter","txtypeEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasSloctype","tlbSloctypeEditList")	  	
	 	.addToolbarTo("canvasTxtype","tlbTxtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSloctypeEditList", {dc:"sloctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Locator types"}).end()
			.beginToolbar("tlbTxtypeEditList", {dc:"txtype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Transaction type"}).end(); 	
	}

});  
