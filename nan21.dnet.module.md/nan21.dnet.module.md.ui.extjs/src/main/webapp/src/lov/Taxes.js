
Ext.define("net.nan21.dnet.module.md.base.tax.lovs.Taxes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.tax.lovs.Taxes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.tax.frame.Tax_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.base.tax.ds.model.TaxLovDs",
	_dataProviderName_:"TaxLovDs"	 		
	
}); 
 
