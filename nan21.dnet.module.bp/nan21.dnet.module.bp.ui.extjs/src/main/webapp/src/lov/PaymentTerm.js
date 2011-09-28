
Ext.define("net.nan21.dnet.module.bp.base.lovs.PaymentTerm", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.base.lovs.PaymentTerm",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasPayTerm"},
	recordModel: "net.nan21.dnet.module.bp.base.ds.model.PaymentTermLovDs",
	_dataProviderName_:"PaymentTermLovDs"	 		
	
}); 
 
