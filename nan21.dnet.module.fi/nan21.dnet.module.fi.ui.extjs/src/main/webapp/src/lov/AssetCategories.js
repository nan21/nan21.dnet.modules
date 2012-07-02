
Ext.define("net.nan21.dnet.module.fi.asset.lovs.AssetCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.fi.asset.lovs.AssetCategories",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.fi.asset.frame.AssetBaseData_UI",bundle:"nan21.dnet.module.fi.ui.extjs",tocElement: "canvasCateg"},
	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetCategoryLovDs",
	_dataProviderName_:"AssetCategoryLovDs"	 		
	
}); 
 
