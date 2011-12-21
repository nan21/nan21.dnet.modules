
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
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.price.frame.PriceList_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.mm.price.ds.model.PriceListTypeLovDs",
	_dataProviderName_:"PriceListTypeLovDs"	 		
	
}); 
 