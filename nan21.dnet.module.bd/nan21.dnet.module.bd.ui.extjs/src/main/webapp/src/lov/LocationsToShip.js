
Ext.define("net.nan21.dnet.module.bd.geo.lovs.LocationsToShip", {
	extend: "dnet.base.AbstractCombo",
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
 
