
Ext.define("net.nan21.dnet.module.md.base.attr.lovs.AttributeGroup", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.attr.lovs.AttributeGroup",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.attr.frame.AttributeDefs_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasAttrGroup"},
	recordModel: "net.nan21.dnet.module.md.base.attr.ds.model.AttributeGroupLovDs",
	_dataProviderName_:"AttributeGroupLovDs"	 		
	
}); 
 
