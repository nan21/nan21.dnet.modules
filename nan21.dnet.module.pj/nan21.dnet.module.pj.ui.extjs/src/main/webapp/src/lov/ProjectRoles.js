
Ext.define("net.nan21.dnet.module.pj.base.lovs.ProjectRoles", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.ProjectRoles",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasRole"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectRoleLovDs",
	_dataProviderName_:"ProjectRoleLovDs"	 		
	
}); 
 