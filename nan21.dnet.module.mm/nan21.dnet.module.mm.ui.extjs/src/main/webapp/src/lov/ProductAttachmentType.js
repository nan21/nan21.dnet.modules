
Ext.define("net.nan21.dnet.module.mm.md.lovs.ProductAttachmentType", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.mm.md.lovs.ProductAttachmentType",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI",bundle:"nan21.dnet.module.mm.ui.extjs",tocElement: "canvasAttachType"},
	recordModel: "net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentTypeLovDs",
	_dataProviderName_:"ProductAttachmentTypeLovDs"	 		
	
}); 
 
