
Ext.define("net.nan21.dnet.module.pj.md.lovs.ProjectComponents", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.md.lovs.ProjectComponents",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.Projects_UI",bundle:"nan21.dnet.module.pj.ui.extjs"},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectComponentLovDs",
	_dataProviderName_:"ProjectComponentLovDs"	 		
	
}); 
 
