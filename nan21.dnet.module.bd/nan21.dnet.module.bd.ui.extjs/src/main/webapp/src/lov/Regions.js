
Ext.define("net.nan21.dnet.module.bd.geo.lovs.Regions", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.geo.lovs.Regions",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.geo.frame.RegionMD_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.RegionLovDs",
	_dataProviderName_:"RegionLovDs"	 		
	
}); 
 
