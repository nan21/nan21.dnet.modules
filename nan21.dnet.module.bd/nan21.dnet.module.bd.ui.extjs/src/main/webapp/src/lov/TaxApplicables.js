
Ext.define("net.nan21.dnet.module.bd.fin.lovs.TaxApplicables", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.fin.lovs.TaxApplicables",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.fin.frame.Tax_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.fin.ds.model.TaxApplicableLovDs",
	_dataProviderName_:"TaxApplicableLovDs"	 		
	
}); 
 