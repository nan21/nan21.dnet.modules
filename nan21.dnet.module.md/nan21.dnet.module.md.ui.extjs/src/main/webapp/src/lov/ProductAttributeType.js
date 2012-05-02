
Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductAttributeType", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.lovs.ProductAttributeType",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.mm.prod.frame.ProductAttributeDefs_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeTypeLovDs",
	_dataProviderName_:"ProductAttributeTypeLovDs"	 		
	
}); 
 
