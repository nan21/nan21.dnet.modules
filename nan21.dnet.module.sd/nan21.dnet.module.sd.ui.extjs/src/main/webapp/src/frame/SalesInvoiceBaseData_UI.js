Dnet.import(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceTypeDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceType", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceStatusDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceStatus"]);

Ext.ns("net.nan21.dnet.module.sd.invoice.frame");
net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("invType", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType({multiEdit:true}))
		.addDc("invStatus", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus({multiEdit:true}))		;		
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
            children: [{ text:"Invoice type", leaf: true , name:"canvas1"},{ text:"Invoice status", leaf: true , name:"canvas2"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addDcView("invType",{ name:"invTypeFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType$Filter",height:30})	 
		.addDcView("invType",{ name:"invTypeEditList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType$EditList", frame:true})	 
		.addDcView("invStatus",{ name:"invStatusFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus$Filter",height:30})	 
		.addDcView("invStatus",{ name:"invStatusEditList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Invoice type",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Invoice status",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["invTypeFilter","invTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvas2",["invStatusFilter","invStatusEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","tlbInvType")	  	
	 	.addToolbarTo("canvas2","tlbInvStatus")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvType", {dc:"invType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
		this._getBuilder_()
			.beginToolbar("tlbInvStatus", {dc:"invStatus"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI", net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI);   
