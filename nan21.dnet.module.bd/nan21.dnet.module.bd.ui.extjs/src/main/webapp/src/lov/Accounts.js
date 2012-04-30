
Ext.define("net.nan21.dnet.module.bd.acc.lovs.Accounts", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.acc.lovs.Accounts",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.acc.frame.Account_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.acc.ds.model.AccountLovDs",
	_dataProviderName_:"AccountLovDs"	 		
	
}); 
 
