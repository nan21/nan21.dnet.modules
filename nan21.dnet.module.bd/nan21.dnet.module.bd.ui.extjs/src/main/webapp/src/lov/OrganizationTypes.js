
Ext.define("net.nan21.dnet.module.bd.org.lovs.OrganizationTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.org.lovs.OrganizationTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.org.frame.Org_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasOrgType"},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeLovDs",
	_dataProviderName_:"OrganizationTypeLovDs"	 		
	
}); 
 
