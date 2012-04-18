
Ext.define("net.nan21.dnet.module.bd.fin.lovs.FinDocTypePOInvIn", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.fin.lovs.FinDocTypePOInvIn",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.fin.frame.PaymentBaseData_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasDocType"},
	recordModel: "net.nan21.dnet.module.bd.fin.ds.model.FinDocTypePOInvInLovDs",
	_dataProviderName_:"FinDocTypePOInvInLovDs"	 		
	
}); 
 
