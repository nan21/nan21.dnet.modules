
Ext.define("net.nan21.dnet.module.pj.md.lovs.ProjectMembers", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.md.lovs.ProjectMembers",
 
	displayField:"member",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{member}, {role}</span>';
		},
		width:250
	},		 
	
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectMemberLovDs",
	_dataProviderName_:"ProjectMemberLovDs"	 		
	
}); 
 
