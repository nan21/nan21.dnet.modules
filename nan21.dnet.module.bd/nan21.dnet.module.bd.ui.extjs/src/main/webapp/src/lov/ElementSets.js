
Ext.define("net.nan21.dnet.module.bd.elem.lovs.ElementSets", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.elem.lovs.ElementSets",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.elem.frame.ElementSet_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementSetLovDs",
	_dataProviderName_:"ElementSetLovDs"	 		
	
}); 
 
