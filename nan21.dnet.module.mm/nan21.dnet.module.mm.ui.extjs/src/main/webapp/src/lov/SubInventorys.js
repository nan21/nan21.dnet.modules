
Ext.define("net.nan21.dnet.module.mm.inventory.lovs.SubInventorys", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.inventory.lovs.SubInventorys",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {inventoryId}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.inventory.frame.SubInventories_UI",bundle:"nan21.dnet.module.mm.ui.extjs"},
	recordModel: "net.nan21.dnet.module.mm.inventory.ds.model.SubInventoryLovDs",
	_dataProviderName_:"SubInventoryLovDs"	 		
	
}); 
 
