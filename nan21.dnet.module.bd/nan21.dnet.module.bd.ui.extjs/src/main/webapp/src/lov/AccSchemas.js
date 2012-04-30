
Ext.define("net.nan21.dnet.module.bd.acc.lovs.AccSchemas", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.acc.lovs.AccSchemas",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.acc.frame.AccSchema_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.acc.ds.model.AccSchemaLovDs",
	_dataProviderName_:"AccSchemaLovDs"	 		
	
}); 
 
