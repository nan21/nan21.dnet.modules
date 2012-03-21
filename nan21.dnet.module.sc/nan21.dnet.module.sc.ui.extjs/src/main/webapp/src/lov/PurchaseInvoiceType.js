
Ext.define("net.nan21.dnet.module.sc.invoice.lovs.PurchaseInvoiceType", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sc.invoice.lovs.PurchaseInvoiceType",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoiceBaseData_UI",bundle:"nan21.dnet.module.sc.ui.extjs",tocElement: "canvasInvType"},
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceTypeLovDs",
	_dataProviderName_:"PurchaseInvoiceTypeLovDs"	 		
	
}); 
 
