
Ext.define("net.nan21.dnet.module.bp.md.lovs.CustomersCode", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.md.lovs.CustomersCode",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.md.frame.BPartner_UI",bundle:"nan21.dnet.module.bp.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerLovDs",
	_dataProviderName_:"BusinessPartnerLovDs"	 		
	
}); 
 
