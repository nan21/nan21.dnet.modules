
Ext.define("net.nan21.dnet.module.md.bp.lovs.VendorsCode", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.bp.lovs.VendorsCode",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.bp.frame.BPartner_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.VendorLovDs",
	_dataProviderName_:"VendorLovDs"	 		
	
}); 
 
