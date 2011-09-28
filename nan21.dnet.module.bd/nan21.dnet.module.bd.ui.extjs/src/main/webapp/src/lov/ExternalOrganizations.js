
Ext.define("net.nan21.dnet.module.bd.org.lovs.ExternalOrganizations", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.org.lovs.ExternalOrganizations",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.org.frame.Org_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasOrg"},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.ExternalOrganizationLovDs",
	_dataProviderName_:"ExternalOrganizationLovDs"	 		
	
}); 
 
