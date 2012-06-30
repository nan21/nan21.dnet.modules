
Ext.define("net.nan21.dnet.module.bd.attr.lovs.Attribute", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.attr.lovs.Attribute",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.attr.frame.Attributes_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeLovDs",
	_dataProviderName_:"AttributeLovDs"	 		
	
}); 
 
