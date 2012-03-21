
Ext.define("net.nan21.dnet.module.sc.order.lovs.PurchaseOrderType", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sc.order.lovs.PurchaseOrderType",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sc.order.frame.PurchaseOrderBaseData_UI",bundle:"nan21.dnet.module.sc.ui.extjs",tocElement: "canvasOrderType"},
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderTypeLovDs",
	_dataProviderName_:"PurchaseOrderTypeLovDs"	 		
	
}); 
 
