
Ext.define("net.nan21.dnet.module.mm.inventory.lovs.StockLocators", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.inventory.lovs.StockLocators",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {subInventoryId}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.inventory.frame.SubInventories_UI",bundle:"nan21.dnet.module.mm.ui.extjs"},
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorLovDs",
	_dataProviderName_:"StockLocatorLovDs"	 		
	
}); 
 
