
Ext.define("net.nan21.dnet.module.bd.uom.lovs.UomLength", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.uom.lovs.UomLength",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.uom.frame.UomMD_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomLengthLovDs",
	_dataProviderName_:"UomLengthLovDs"	 		
	
}); 
 
