
Ext.define("net.nan21.dnet.module.pj.md.lovs.ProjectVersionsReleased", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.md.lovs.ProjectVersionsReleased",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.md.frame.Projects_UI",bundle:"nan21.dnet.module.pj.ui.extjs"},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectVersionReleasedLovDs",
	_dataProviderName_:"ProjectVersionReleasedLovDs"	 		
	
}); 
 
