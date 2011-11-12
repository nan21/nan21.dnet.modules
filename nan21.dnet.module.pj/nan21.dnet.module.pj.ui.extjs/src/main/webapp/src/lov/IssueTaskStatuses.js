
Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasTaskstatus"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueTaskStatusLovDs",
	_dataProviderName_:"IssueTaskStatusLovDs"	 		
	
}); 
 
