
Ext.define("net.nan21.dnet.module.sd.order.lovs.SalesOrderStatus", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sd.order.lovs.SalesOrderStatus",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI",bundle:"nan21.dnet.module.sd.ui.extjs",tocElement: "canvasOrderStatus"},
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusLovDs",
	_dataProviderName_:"SalesOrderStatusLovDs"	 		
	
}); 
 
