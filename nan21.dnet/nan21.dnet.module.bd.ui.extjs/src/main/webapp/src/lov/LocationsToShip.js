
Ext.define("net.nan21.dnet.module.bd.geo.lovs.LocationsToShip", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.geo.lovs.LocationsToShip",
 
	displayField:"asString",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{asString}</span>';
		},
		width:250
	},		 
	
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.LocationToShipLovDs",
	_dataProviderName_:"LocationToShipLovDs"	 		
	
}); 
 
