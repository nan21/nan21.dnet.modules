
Ext.define("net.nan21.dnet.module.md.base.tx.lovs.DeliveryMethods", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.tx.lovs.DeliveryMethods",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.tx.frame.TxBaseData_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasDelivMtd"},
	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.DeliveryMethodLovDs",
	_dataProviderName_:"DeliveryMethodLovDs"	 		
	
}); 
 
