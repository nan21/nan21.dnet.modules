
Ext.define("net.nan21.dnet.module.bp.base.lovs.DeliveryMethods", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.base.lovs.DeliveryMethods",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.BP_BaseData_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasDelivMtd"},
	recordModel: "net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodLovDs",
	_dataProviderName_:"DeliveryMethodLovDs"	 		
	
}); 
 
