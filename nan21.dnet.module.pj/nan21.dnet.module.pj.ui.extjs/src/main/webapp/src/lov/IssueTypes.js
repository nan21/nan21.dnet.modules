
Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.IssueTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueTypeLovDs",
	_dataProviderName_:"IssueTypeLovDs"	 		
	
}); 
 
