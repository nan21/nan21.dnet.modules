
Ext.define("net.nan21.dnet.module.bd.contact.lovs.CommunicationChannelTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.contact.lovs.CommunicationChannelTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.contact.frame.CommunicationChannelTypes_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelTypeLovDs",
	_dataProviderName_:"CommunicationChannelTypeLovDs"	 		
	
}); 
 
