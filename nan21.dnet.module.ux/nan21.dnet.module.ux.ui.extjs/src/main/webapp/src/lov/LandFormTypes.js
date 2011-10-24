
Ext.define("net.nan21.dnet.module.ux.example.lovs.LandFormTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ux.example.lovs.LandFormTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.geo.frame.CountryMD_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ux.example.ds.model.LandFormTypeLovDs",
	_dataProviderName_:"LandFormTypeLovDs"	 		
	
}); 
 
