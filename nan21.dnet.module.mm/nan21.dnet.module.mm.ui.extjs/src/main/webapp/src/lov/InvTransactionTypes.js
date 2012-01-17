
Ext.define("net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.inventory.lovs.InvTransactionTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasTxtype"},
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeLovDs",
	_dataProviderName_:"InvTransactionTypeLovDs"	 		
	
}); 
 
