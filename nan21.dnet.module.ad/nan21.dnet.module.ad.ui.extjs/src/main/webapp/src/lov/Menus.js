
Ext.define("net.nan21.dnet.module.ad.usr.lovs.Menus", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.usr.lovs.Menus",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.usr.frame.Menu_UI",bundle:"nan21.dnet.module.ad.ui.extjs",tocElement: "canvasMenu"},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.MenuLovDs",
	_dataProviderName_:"MenuLovDs"	 		
	
}); 
 
