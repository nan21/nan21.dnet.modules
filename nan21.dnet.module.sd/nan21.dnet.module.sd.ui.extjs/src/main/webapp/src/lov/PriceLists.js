
Ext.define("net.nan21.dnet.module.sd.price.lovs.PriceLists", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.sd.price.lovs.PriceLists",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	
	recordModel: "net.nan21.dnet.module.sd.price.ds.model.PriceListLovDs",
	_dataProviderName_:"PriceListLovDs"	 		
	
}); 
 
