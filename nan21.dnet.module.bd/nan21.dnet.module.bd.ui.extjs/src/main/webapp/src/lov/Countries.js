
Ext.define("net.nan21.dnet.module.bd.geo.lovs.Countries", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.geo.lovs.Countries",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.geo.frame.CountryMD_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.CountryLovDs",
	_dataProviderName_:"CountryLovDs"	 		
	
}); 
 
