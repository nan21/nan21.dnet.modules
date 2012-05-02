
Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.mm.prod.frame.ProductBaseData_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasManufact"},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductManufacturerLovDs",
	_dataProviderName_:"ProductManufacturerLovDs"	 		
	
}); 
 
