
Ext.define("net.nan21.dnet.module.bd.elem.lovs.ElementCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.elem.lovs.ElementCategories",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.elem.frame.ElementBaseData_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasCateg"},
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementCategoryLovDs",
	_dataProviderName_:"ElementCategoryLovDs"	 		
	
}); 
 
