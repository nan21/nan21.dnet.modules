
Ext.define("net.nan21.dnet.module.pj.md.lovs.ProjectMembers", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.md.lovs.ProjectMembers",
 
	displayField:"member",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{member}, {role}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.Projects_UI",bundle:"nan21.dnet.module.pj.ui.extjs"},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectMemberLovDs",
	_dataProviderName_:"ProjectMemberLovDs"	 		
	
}); 
 
