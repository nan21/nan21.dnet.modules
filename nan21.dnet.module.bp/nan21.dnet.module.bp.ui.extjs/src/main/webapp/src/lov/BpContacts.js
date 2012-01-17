
Ext.define("net.nan21.dnet.module.bp.md.lovs.BpContacts", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.md.lovs.BpContacts",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.md.frame.Contact_UI",bundle:"nan21.dnet.module.bp.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bp.md.ds.model.BpContactLovDs",
	_dataProviderName_:"BpContactLovDs"	 		
	
}); 
 
