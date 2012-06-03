
Ext.define("net.nan21.dnet.module.md.base.tx.lovs.TxDocTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.tx.lovs.TxDocTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.tx.frame.TxDocType_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasDocType"},
	recordModel: "net.nan21.dnet.module.md.base.tx.ds.model.TxDocTypeLovDs",
	_dataProviderName_:"TxDocTypeLovDs"	 		
	
}); 
 
