
Ext.define("net.nan21.dnet.module.ad.impex.lovs.ImportJob", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.impex.lovs.ImportJob",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.impex.frame.ImportJob_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportJobLovDs",
	_dataProviderName_:"ImportJobLovDs"	 		
	
}); 
 
