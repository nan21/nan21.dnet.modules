
Ext.define("net.nan21.dnet.module.mm.md.lovs.ProductAttribute", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.md.lovs.ProductAttribute",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasAttr"},
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeLovDs",
	_dataProviderName_:"ProductAttributeLovDs"	 		
	
}); 
 
