
Ext.define("net.nan21.dnet.module.bd.tx.lovs.TxDocTypesPI", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.tx.lovs.TxDocTypesPI",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.tx.frame.TxDocType_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasDocType"},
	recordModel: "net.nan21.dnet.module.bd.tx.ds.model.TxDocTypePILovDs",
	_dataProviderName_:"TxDocTypePILovDs"	 		
	
}); 
 
