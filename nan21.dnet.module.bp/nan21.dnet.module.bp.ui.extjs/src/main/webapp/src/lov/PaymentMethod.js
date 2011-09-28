
Ext.define("net.nan21.dnet.module.bp.base.lovs.PaymentMethod", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.base.lovs.PaymentMethod",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasPayMtd"},
	recordModel: "net.nan21.dnet.module.bp.base.ds.model.PaymentMethodLovDs",
	_dataProviderName_:"PaymentMethodLovDs"	 		
	
}); 
 
