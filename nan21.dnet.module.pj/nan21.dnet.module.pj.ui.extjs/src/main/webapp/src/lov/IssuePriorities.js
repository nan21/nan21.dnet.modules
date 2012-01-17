
Ext.define("net.nan21.dnet.module.pj.base.lovs.IssuePriorities", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.IssuePriorities",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasPriority"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssuePriorityLovDs",
	_dataProviderName_:"IssuePriorityLovDs"	 		
	
}); 
 
