
Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductAttributeGroup", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.lovs.ProductAttributeGroup",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.mm.prod.frame.ProductAttributeDefs_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasAttrGroup"},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeGroupLovDs",
	_dataProviderName_:"ProductAttributeGroupLovDs"	 		
	
}); 
 
