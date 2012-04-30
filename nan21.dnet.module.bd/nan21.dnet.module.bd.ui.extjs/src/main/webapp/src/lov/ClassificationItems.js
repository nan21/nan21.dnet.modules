
Ext.define("net.nan21.dnet.module.bd.standards.lovs.ClassificationItems", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.standards.lovs.ClassificationItems",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.standards.frame.Classifications_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasClasscode"},
	recordModel: "net.nan21.dnet.module.bd.standards.ds.model.ClassificationItemLovDs",
	_dataProviderName_:"ClassificationItemLovDs"	 		
	
}); 
 
