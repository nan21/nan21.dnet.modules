
Ext.define("net.nan21.dnet.module.mm.md.lovs.ProductCategories", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.md.lovs.ProductCategories",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.ProductCategory_UI",bundle:"nan21.dnet.module.mm.ui.extjs"},
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductCategoryLovDs",
	_dataProviderName_:"ProductCategoryLovDs"	 		
	
}); 
 
