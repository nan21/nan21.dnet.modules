
Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.mm.prod.frame.ProductCategory_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductCategoryLovDs",
	_dataProviderName_:"ProductCategoryLovDs"	 		
	
}); 
 
