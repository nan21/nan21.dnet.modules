
Ext.define("net.nan21.dnet.module.mm.md.lovs.ProductManufacturers", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.md.lovs.ProductManufacturers",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasManufact"},
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductManufacturerLovDs",
	_dataProviderName_:"ProductManufacturerLovDs"	 		
	
}); 
 
