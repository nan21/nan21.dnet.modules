
Ext.define("net.nan21.dnet.module.ad.usr.lovs.Roles", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.usr.lovs.Roles",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.usr.frame.Role_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.RoleLovDs",
	_dataProviderName_:"RoleLovDs"	 		
	
}); 
 
