Dnet.import(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrder", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderItemDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderItem","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderType","nan21.dnet.module.sd.ui.extjs/ds/PriceListLovDs","nan21.dnet.module.sd.ui.extjs/lov/PriceLists","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/Customers","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bd.ui.extjs/ds/LocationToBillLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToBill","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.bd.ui.extjs/ds/LocationToShipLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToShip","nan21.dnet.module.bp.ui.extjs/ds/DeliveryMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/DeliveryMethods","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/Customers","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesOrderType","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure"]);

Ext.ns("net.nan21.dnet.module.sd.order.frame");
net.nan21.dnet.module.sd.order.frame.SalesOrder_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.sd.order.frame.SalesOrder_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("order", new net.nan21.dnet.module.sd.order.dc.SalesOrder())
		.addDc("item", new net.nan21.dnet.module.sd.order.dc.SalesOrderItem({multiEdit:true}))		
		.linkDc("item", "order",{fields:[ {childField:"salesOrderId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcFilterFormView("order",{ name:"orderFilter", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter"})	 
		.addDcView("order",{ name:"orderList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$List"})	 
		.addDcFormView("order",{ name:"orderEdit", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrder$Edit",height:150})	 
		.addDcView("item",{ name:"itemEditList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderItem$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["orderFilter","orderList"] ,["north","center"])	
		.addChildrenTo("canvas2",["orderEdit","itemEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbOrderList")	  	
	 	.addToolbarTo("canvas2","tlbOrderEdit")	  	
	 	.addToolbarTo("itemEditList","tlbItemEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrderList", {dc:"order"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbOrderEdit", {dc:"order"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end()
			.beginToolbar("tlbItemEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
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
Ext.reg("net.nan21.dnet.module.sd.order.frame.SalesOrder_UI", net.nan21.dnet.module.sd.order.frame.SalesOrder_UI);   
