
Ext.define("net.nan21.dnet.module.mm.md.lovs.ProductAttributeGroup", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.md.lovs.ProductAttributeGroup",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.ProductAttributeDefs_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasAttrGroup"},
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupLovDs",
	_dataProviderName_:"ProductAttributeGroupLovDs"	 		
	
}); 
 
