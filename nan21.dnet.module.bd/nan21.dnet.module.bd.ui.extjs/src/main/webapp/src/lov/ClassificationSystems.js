
Ext.define("net.nan21.dnet.module.bd.standards.lovs.ClassificationSystems", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.standards.lovs.ClassificationSystems",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.standards.frame.Classifications_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasClasssys"},
	recordModel: "net.nan21.dnet.module.bd.standards.ds.model.ClassificationSystemLovDs",
	_dataProviderName_:"ClassificationSystemLovDs"	 		
	
}); 
 
