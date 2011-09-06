Dnet.import(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderTypeDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderType", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderStatusDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderStatus"]);

Ext.ns("net.nan21.dnet.module.sd.order.frame");
net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("orderType", new net.nan21.dnet.module.sd.order.dc.SalesOrderType({multiEdit:true}))
		.addDc("orderStatus", new net.nan21.dnet.module.sd.order.dc.SalesOrderStatus({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("orderType",{ name:"orderTypeFilter", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderType$Filter",height:35})	 
		.addDcView("orderType",{ name:"orderTypeEditList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderType$EditList", frame:true})	 
		.addDcFilterFormView("orderStatus",{ name:"orderStatusFilter", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderStatus$Filter",height:30})	 
		.addDcView("orderStatus",{ name:"orderStatusEditList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderStatus$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasOrderType", layout:"border", defaults:{split:true},title:"Order type",header:false})  	 
		.addPanel({name: "canvasOrderStatus", layout:"border", defaults:{split:true},title:"Order status",header:false})  	 
			
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
			.beginToolbar("tlbOrderType", {dc:"orderType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Order type"}).end()
			.beginToolbar("tlbOrderStatus", {dc:"orderStatus"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Order status"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI", net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI);   
