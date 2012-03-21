Dnet.doImport(["", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseOrderTypeDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseOrderType", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseOrderStatusDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseOrderStatus"]);

Ext.define("net.nan21.dnet.module.sc.order.frame.PurchaseOrderBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sc.order.frame.PurchaseOrderBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.sc.order.frame.PurchaseOrderBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("orderType", new net.nan21.dnet.module.sc.order.dc.PurchaseOrderType({multiEdit:true}))
		.addDc("orderStatus", new net.nan21.dnet.module.sc.order.dc.PurchaseOrderStatus({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("orderType",{ name:"orderTypeFilter", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrderType$Filter",height:120})	 
		.addDcEditGridView("orderType",{ name:"orderTypeEditList", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrderType$EditList", frame:true})	 
		.addDcFilterFormView("orderStatus",{ name:"orderStatusFilter", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrderStatus$Filter",height:120})	 
		.addDcEditGridView("orderStatus",{ name:"orderStatusEditList", xtype:"net.nan21.dnet.module.sc.order.dc.PurchaseOrderStatus$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasOrderType", layout:"border", defaults:{split:true},title:"Purchase order type",preventHeader:true})  	 
		.addPanel({name: "canvasOrderStatus", layout:"border", defaults:{split:true},title:"Purchase order status",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasOrderType","canvasOrderStatus"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasOrderType","canvasOrderStatus"]) 				 		
		.addChildrenTo("canvasOrderType",["orderTypeFilter","orderTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasOrderStatus",["orderStatusFilter","orderStatusEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasOrderType","tlbOrderType")	  	
	 	.addToolbarTo("canvasOrderStatus","tlbOrderStatus")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrderType", {dc:"orderType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Purchase order type"}).end()
			.beginToolbar("tlbOrderStatus", {dc:"orderStatus"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Purchase order status"}).end(); 	
	}

});  
