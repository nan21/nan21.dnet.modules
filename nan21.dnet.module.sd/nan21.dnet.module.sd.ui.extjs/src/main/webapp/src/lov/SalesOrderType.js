
Ext.define("net.nan21.dnet.module.sd.order.lovs.SalesOrderType", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sd.order.lovs.SalesOrderType",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.sd.order.frame.SalesOrderBaseData_UI",bundle:"nan21.dnet.module.sd.ui.extjs",tocElement: "canvasOrderType"},
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeLovDs",
	_dataProviderName_:"SalesOrderTypeLovDs"	 		
	
}); 
 
