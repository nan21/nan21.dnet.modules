
Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueSeverities", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.IssueSeverities",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasSeverity"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueSeverityLovDs",
	_dataProviderName_:"IssueSeverityLovDs"	 		
	
}); 
 
