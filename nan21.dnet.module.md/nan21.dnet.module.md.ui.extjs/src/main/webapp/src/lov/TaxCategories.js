
Ext.define("net.nan21.dnet.module.md.base.tax.lovs.TaxCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.tax.lovs.TaxCategories",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.tax.frame.TaxCategories_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.base.tax.ds.model.TaxCategoryLovDs",
	_dataProviderName_:"TaxCategoryLovDs"	 		
	
}); 
 
