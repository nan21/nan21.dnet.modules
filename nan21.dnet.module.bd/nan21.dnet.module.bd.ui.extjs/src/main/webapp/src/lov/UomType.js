
Ext.define("net.nan21.dnet.module.bd.uom.lovs.UomType", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.uom.lovs.UomType",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.uom.frame.UomType_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomTypeLovDs",
	_dataProviderName_:"UomTypeLovDs"	 		
	
}); 
 
