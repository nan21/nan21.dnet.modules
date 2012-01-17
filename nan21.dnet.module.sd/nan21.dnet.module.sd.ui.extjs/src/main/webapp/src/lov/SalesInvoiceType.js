
Ext.define("net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceType", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sd.invoice.lovs.SalesInvoiceType",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceBaseData_UI",bundle:"nan21.dnet.module.sd.ui.extjs",tocElement: "canvasInvType"},
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTypeLovDs",
	_dataProviderName_:"SalesInvoiceTypeLovDs"	 		
	
}); 
 
