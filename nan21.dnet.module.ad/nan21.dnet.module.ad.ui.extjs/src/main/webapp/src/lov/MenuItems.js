
Ext.define("net.nan21.dnet.module.ad.usr.lovs.MenuItems", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.usr.lovs.MenuItems",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.usr.frame.Menu_UI",bundle:"nan21.dnet.module.ad.ui.extjs",tocElement: "canvasItem"},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.MenuItemLovDs",
	_dataProviderName_:"MenuItemLovDs"	 		
	
}); 
 
