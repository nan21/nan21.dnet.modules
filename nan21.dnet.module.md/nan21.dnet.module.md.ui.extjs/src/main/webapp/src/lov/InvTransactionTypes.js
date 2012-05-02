
Ext.define("net.nan21.dnet.module.md.tx.inventory.lovs.InvTransactionTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.lovs.InvTransactionTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.tx.inventory.frame.InvTxTypes_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeLovDs",
	_dataProviderName_:"InvTransactionTypeLovDs"	 		
	
}); 
 
