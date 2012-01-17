
Ext.define("net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.inventory.lovs.InvTransactionSourceTypeS",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasTxsrctype"},
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionSourceTypeLovDs",
	_dataProviderName_:"InvTransactionSourceTypeLovDs"	 		
	
}); 
 
