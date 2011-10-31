
Ext.define("net.nan21.dnet.module.ad.usr.lovs.Assignables", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.usr.lovs.Assignables",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.usr.frame.Assignables_UI",bundle:"nan21.dnet.module.ad.ui.extjs",tocElement: "canvasResource"},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.AssignableLovDs",
	_dataProviderName_:"AssignableLovDs"	 		
	
}); 
 
