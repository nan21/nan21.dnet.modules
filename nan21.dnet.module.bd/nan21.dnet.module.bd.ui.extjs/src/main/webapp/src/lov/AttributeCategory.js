
Ext.define("net.nan21.dnet.module.bd.attr.lovs.AttributeCategory", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.attr.lovs.AttributeCategory",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.attr.frame.AttributeBaseData_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasCateg"},
	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeCategoryLovDs",
	_dataProviderName_:"AttributeCategoryLovDs"	 		
	
}); 
 
