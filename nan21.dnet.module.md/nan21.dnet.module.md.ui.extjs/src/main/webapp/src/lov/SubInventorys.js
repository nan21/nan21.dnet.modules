
Ext.define("net.nan21.dnet.module.md.org.lovs.SubInventorys", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.org.lovs.SubInventorys",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.org.frame.SubInventories_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.org.ds.model.SubInventoryLovDs",
	_dataProviderName_:"SubInventoryLovDs"	 		
	
}); 
 
