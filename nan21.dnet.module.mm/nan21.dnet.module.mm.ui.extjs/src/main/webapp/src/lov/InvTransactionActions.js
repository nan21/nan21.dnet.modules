
Ext.define("net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.inventory.lovs.InvTransactionActions",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.inventory.frame.InventoryBaseData_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasTxaction"},
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionActionLovDs",
	_dataProviderName_:"InvTransactionActionLovDs"	 		
	
}); 
 
