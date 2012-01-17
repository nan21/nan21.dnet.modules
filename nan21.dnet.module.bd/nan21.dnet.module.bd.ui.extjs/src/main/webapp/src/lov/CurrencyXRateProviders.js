
Ext.define("net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderLovDs",
	_dataProviderName_:"CurrencyXRateProviderLovDs"	 		
	
}); 
 
