Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceTypeDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceType", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceStatusDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceStatus"]);

Ext.define("net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("invType", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType({multiEdit:true}))
		.addDc("invStatus", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("invType",{ name:"invTypeFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType$Filter",height:120})	 
		.addDcView("invType",{ name:"invTypeEditList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceType$EditList", frame:true})	 
		.addDcFilterFormView("invStatus",{ name:"invStatusFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus$Filter",height:120})	 
		.addDcView("invStatus",{ name:"invStatusEditList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceStatus$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasInvType", layout:"border", defaults:{split:true},title:"Invoice type",preventHeader:true})  	 
		.addPanel({name: "canvasInvStatus", layout:"border", defaults:{split:true},title:"Invoice status",preventHeader:true})  	 
			
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
			.beginToolbar("tlbInvType", {dc:"invType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Invoice type"}).end()
			.beginToolbar("tlbInvStatus", {dc:"invStatus"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Invoice status"}).end(); 	
	}

});  
