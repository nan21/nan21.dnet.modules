
Ext.define("net.nan21.dnet.module.sc.order.lovs.PurchaseOrderStatus", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sc.order.lovs.PurchaseOrderStatus",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sc.order.frame.PurchaseOrderBaseData_UI",bundle:"nan21.dnet.module.sc.ui.extjs",tocElement: "canvasOrderStatus"},
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderStatusLovDs",
	_dataProviderName_:"PurchaseOrderStatusLovDs"	 		
	
}); 
 
