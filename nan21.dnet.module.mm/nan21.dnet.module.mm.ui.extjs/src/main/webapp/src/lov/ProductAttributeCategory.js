
Ext.define("net.nan21.dnet.module.mm.md.lovs.ProductAttributeCategory", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.md.lovs.ProductAttributeCategory",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasCateg"},
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeCategoryLovDs",
	_dataProviderName_:"ProductAttributeCategoryLovDs"	 		
	
}); 
 
