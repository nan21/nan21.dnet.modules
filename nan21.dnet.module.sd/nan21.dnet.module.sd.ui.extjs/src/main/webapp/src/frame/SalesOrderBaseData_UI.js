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
			
		this._mainViewName_  = "_main_with_toc_";
		this._getBuilder_()
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addPanel({ name:"_toc_",xtype: 'treepanel',collapsible: true, region:"west", title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
			,minWidth:150, maxWidth:500
			,root: new Ext.tree.AsyncTreeNode({expanded: true,
            children: [{ text:"Order type", leaf: true , name:"canvas1"},{ text:"Order status", leaf: true , name:"canvas2"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addDcView("orderType",{ name:"orderTypeFilter", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderType$Filter",height:35})	 
		.addDcView("orderType",{ name:"orderTypeEditList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderType$EditList", frame:true})	 
		.addDcView("orderStatus",{ name:"orderStatusFilter", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderStatus$Filter",height:30})	 
		.addDcView("orderStatus",{ name:"orderStatusEditList", xtype:"net.nan21.dnet.module.sd.order.dc.SalesOrderStatus$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Order type",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Order status",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["orderTypeFilter","orderTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvas2",["orderStatusFilter","orderStatusEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","tlbOrderType")	  	
	 	.addToolbarTo("canvas2","tlbOrderStatus")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrderType", {dc:"orderType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbOrderStatus", {dc:"orderStatus"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI", net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI);   
