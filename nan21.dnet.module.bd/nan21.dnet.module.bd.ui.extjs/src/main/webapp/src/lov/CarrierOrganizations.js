
Ext.define("net.nan21.dnet.module.bd.org.lovs.CarrierOrganizations", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.org.lovs.CarrierOrganizations",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.org.frame.Org_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasOrg"},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.CarrierOrganizationLovDs",
	_dataProviderName_:"CarrierOrganizationLovDs"	 		
	
}); 
 
