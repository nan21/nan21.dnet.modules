
Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductAttributeCategory", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.lovs.ProductAttributeCategory",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.mm.prod.frame.ProductAttributeDefs_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasCateg"},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeCategoryLovDs",
	_dataProviderName_:"ProductAttributeCategoryLovDs"	 		
	
}); 
 
