
Ext.define("net.nan21.dnet.module.mm.price.lovs.PriceListVersion", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.price.lovs.PriceListVersion",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.price.frame.PriceList_UI",bundle:"nan21.dnet.module.mm.ui.extjs"},
	recordModel: "net.nan21.dnet.module.mm.price.ds.model.PriceListVersionLovDs",
	_dataProviderName_:"PriceListVersionLovDs"	 		
	
}); 
 