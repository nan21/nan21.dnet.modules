
Ext.define("net.nan21.dnet.module.mm.price.lovs.PriceListTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.price.lovs.PriceListTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	
	recordModel: "net.nan21.dnet.module.mm.price.ds.model.PriceListTypeLovDs",
	_dataProviderName_:"PriceListTypeLovDs"	 		
	
}); 
 
