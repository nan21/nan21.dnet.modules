
Ext.define("net.nan21.dnet.module.ad.impex.lovs.ExportMaps", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.impex.lovs.ExportMaps",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.impex.frame.ExportMap_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportMapLovDs",
	_dataProviderName_:"ExportMapLovDs"	 		
	
}); 
 
