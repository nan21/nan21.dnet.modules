Dnet.doImport(["", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseInvoiceTypeDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseInvoiceType", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseInvoiceStatusDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseInvoiceStatus"]);

Ext.define("net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoiceBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoiceBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoiceBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("invType", new net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceType({multiEdit:true}))
		.addDc("invStatus", new net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceStatus({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("invType",{ name:"invTypeFilter", xtype:"net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceType$Filter",height:120})	 
		.addDcEditGridView("invType",{ name:"invTypeEditList", xtype:"net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceType$EditList", frame:true})	 
		.addDcFilterFormView("invStatus",{ name:"invStatusFilter", xtype:"net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceStatus$Filter",height:120})	 
		.addDcEditGridView("invStatus",{ name:"invStatusEditList", xtype:"net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceStatus$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasInvType", layout:"border", defaults:{split:true},title:"Purchase invoice type",preventHeader:true})  	 
		.addPanel({name: "canvasInvStatus", layout:"border", defaults:{split:true},title:"Purchase invoice status",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasInvType","canvasInvStatus"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasInvType","canvasInvStatus"]) 				 		
		.addChildrenTo("canvasInvType",["invTypeFilter","invTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasInvStatus",["invStatusFilter","invStatusEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasInvType","tlbInvType")	  	
	 	.addToolbarTo("canvasInvStatus","tlbInvStatus")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvType", {dc:"invType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Purchase invoice type"}).end()
			.beginToolbar("tlbInvStatus", {dc:"invStatus"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Purchase invoice status"}).end(); 	
	}

});  
