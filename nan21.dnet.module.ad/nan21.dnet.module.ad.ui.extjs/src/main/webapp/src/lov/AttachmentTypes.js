
Ext.define("net.nan21.dnet.module.ad.data.lovs.AttachmentTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.data.lovs.AttachmentTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.data.frame.AttachmentType_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeLovDs",
	_dataProviderName_:"AttachmentTypeLovDs"	 		
	
}); 
 