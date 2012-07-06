
Ext.define("net.nan21.dnet.module.md.org.lovs.FinancialAccounts", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.org.lovs.FinancialAccounts",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}, {currency}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.org.frame.FinancialAccount_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountLovDs",
	_dataProviderName_:"FinancialAccountLovDs"	 		
	
}); 
 
