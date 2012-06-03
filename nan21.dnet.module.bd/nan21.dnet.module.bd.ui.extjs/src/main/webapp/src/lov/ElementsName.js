
Ext.define("net.nan21.dnet.module.bd.elem.lovs.ElementsName", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.elem.lovs.ElementsName",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.elem.frame.Element_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementLovDs",
	_dataProviderName_:"ElementLovDs"	 		
	
}); 
 
