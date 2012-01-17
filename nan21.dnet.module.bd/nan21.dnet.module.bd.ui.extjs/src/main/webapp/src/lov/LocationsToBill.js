
Ext.define("net.nan21.dnet.module.bd.geo.lovs.LocationsToBill", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.geo.lovs.LocationsToBill",
 
	displayField:"asString",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{asString}</span>';
		},
		width:250
	},		 
	
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.LocationToBillLovDs",
	_dataProviderName_:"LocationToBillLovDs"	 		
	
}); 
 
