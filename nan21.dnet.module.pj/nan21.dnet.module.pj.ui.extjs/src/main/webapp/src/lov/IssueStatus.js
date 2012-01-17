
Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueStatus", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.IssueStatus",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasStatus"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueStatusLovDs",
	_dataProviderName_:"IssueStatusLovDs"	 		
	
}); 
 
