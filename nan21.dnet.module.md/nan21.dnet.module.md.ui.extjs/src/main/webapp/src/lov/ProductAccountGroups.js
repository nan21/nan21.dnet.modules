
Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductAccountGroups", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.lovs.ProductAccountGroups",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.mm.prod.frame.ProductAccountGroup_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountGroupLovDs",
	_dataProviderName_:"ProductAccountGroupLovDs"	 		
	
}); 
 
