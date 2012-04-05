
Ext.define("net.nan21.dnet.module.bd.fin.lovs.PaymentTerm", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.fin.lovs.PaymentTerm",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.fin.frame.PaymentBaseData_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasPayTerm"},
	recordModel: "net.nan21.dnet.module.bd.fin.ds.model.PaymentTermLovDs",
	_dataProviderName_:"PaymentTermLovDs"	 		
	
}); 
 
