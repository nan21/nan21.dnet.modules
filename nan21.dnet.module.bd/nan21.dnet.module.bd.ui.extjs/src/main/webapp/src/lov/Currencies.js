
Ext.define("net.nan21.dnet.module.bd.currency.lovs.Currencies", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.currency.lovs.Currencies",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.currency.frame.Currencies_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.currency.ds.model.CurrencyLovDs",
	_dataProviderName_:"CurrencyLovDs"	 		
	
}); 
 
