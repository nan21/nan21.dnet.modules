
Ext.define("net.nan21.dnet.module.bd.tx.lovs.DeliveryMethods", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.tx.lovs.DeliveryMethods",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.tx.frame.TxBaseData_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasDelivMtd"},
	recordModel: "net.nan21.dnet.module.bd.tx.ds.model.DeliveryMethodLovDs",
	_dataProviderName_:"DeliveryMethodLovDs"	 		
	
}); 
 
