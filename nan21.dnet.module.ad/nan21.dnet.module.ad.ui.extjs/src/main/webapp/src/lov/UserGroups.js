
Ext.define("net.nan21.dnet.module.ad.usr.lovs.UserGroups", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.usr.lovs.UserGroups",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.usr.frame.UserGroups_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.UserGroupLovDs",
	_dataProviderName_:"UserGroupLovDs"	 		
	
}); 
 
