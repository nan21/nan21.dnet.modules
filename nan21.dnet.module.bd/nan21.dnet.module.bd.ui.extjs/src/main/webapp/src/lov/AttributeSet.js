
Ext.define("net.nan21.dnet.module.bd.attr.lovs.AttributeSet", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.attr.lovs.AttributeSet",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.attr.frame.AttributeSet_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeSetLovDs",
	_dataProviderName_:"AttributeSetLovDs"	 		
	
}); 
 
