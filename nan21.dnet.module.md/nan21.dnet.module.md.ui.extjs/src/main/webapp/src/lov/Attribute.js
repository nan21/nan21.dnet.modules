
Ext.define("net.nan21.dnet.module.md.base.attr.lovs.Attribute", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.attr.lovs.Attribute",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.attr.frame.AttributeDefs_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasAttr"},
	recordModel: "net.nan21.dnet.module.md.base.attr.ds.model.AttributeLovDs",
	_dataProviderName_:"AttributeLovDs"	 		
	
}); 
 
