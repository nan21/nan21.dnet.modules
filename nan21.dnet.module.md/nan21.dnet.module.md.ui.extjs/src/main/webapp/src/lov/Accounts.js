
Ext.define("net.nan21.dnet.module.md.acc.lovs.Accounts", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.acc.lovs.Accounts",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.acc.frame.Account_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccountLovDs",
	_dataProviderName_:"AccountLovDs"	 		
	
}); 
 
