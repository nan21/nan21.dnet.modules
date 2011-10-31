
Ext.define("net.nan21.dnet.module.pj.md.lovs.Projects", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.md.lovs.Projects",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.Projects_UI",bundle:"nan21.dnet.module.pj.ui.extjs"},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectLovDs",
	_dataProviderName_:"ProjectLovDs"	 		
	
}); 
 
