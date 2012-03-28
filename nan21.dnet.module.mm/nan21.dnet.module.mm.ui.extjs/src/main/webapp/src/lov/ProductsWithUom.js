
Ext.define("net.nan21.dnet.module.mm.md.lovs.ProductsWithUom", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.md.lovs.ProductsWithUom",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}, {uom}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.Product_UI",bundle:"nan21.dnet.module.mm.ui.extjs"},
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductWithUomLovDs",
	_dataProviderName_:"ProductWithUomLovDs"	 		
	
}); 
 
