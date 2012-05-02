
Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}, {uom}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.mm.prod.frame.Product_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductWithUomLovDs",
	_dataProviderName_:"ProductWithUomLovDs"	 		
	
}); 
 
