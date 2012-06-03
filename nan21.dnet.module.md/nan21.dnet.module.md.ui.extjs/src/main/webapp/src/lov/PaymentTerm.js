
Ext.define("net.nan21.dnet.module.md.base.tx.lovs.PaymentTerm", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.tx.lovs.PaymentTerm",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.tx.frame.TxBaseData_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasPayTerm"},
	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.PaymentTermLovDs",
	_dataProviderName_:"PaymentTermLovDs"	 		
	
}); 
 
