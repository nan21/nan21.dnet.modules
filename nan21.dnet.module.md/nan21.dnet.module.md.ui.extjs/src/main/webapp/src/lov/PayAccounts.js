
Ext.define("net.nan21.dnet.module.md.org.lovs.PayAccounts", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.org.lovs.PayAccounts",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {currency}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.org.frame.PayAccount_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.org.ds.model.PayAccountLovDs",
	_dataProviderName_:"PayAccountLovDs"	 		
	
}); 
 
