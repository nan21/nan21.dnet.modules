
Ext.define("net.nan21.dnet.module.bp.base.lovs.Banks", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.base.lovs.Banks",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.base.frame.Bank_UI",bundle:"nan21.dnet.module.bp.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bp.base.ds.model.BankLovDs",
	_dataProviderName_:"BankLovDs"	 		
	
}); 
 
