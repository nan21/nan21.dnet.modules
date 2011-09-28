
Ext.define("net.nan21.dnet.module.mm.md.lovs.ProductAttributeType", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.md.lovs.ProductAttributeType",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeTypeLovDs",
	_dataProviderName_:"ProductAttributeTypeLovDs"	 		
	
}); 
 
