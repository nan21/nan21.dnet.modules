
Ext.define("net.nan21.dnet.module.ad.usr.lovs.AssignableTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.usr.lovs.AssignableTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.usr.frame.Assignables_UI",bundle:"nan21.dnet.module.ad.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.AssignableTypeLovDs",
	_dataProviderName_:"AssignableTypeLovDs"	 		
	
}); 
 
