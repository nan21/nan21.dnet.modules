
Ext.define("net.nan21.dnet.module.hr.job.lovs.WorkRequirementTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.job.lovs.WorkRequirementTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasWrType"},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.WorkRequirementTypeLovDs",
	_dataProviderName_:"WorkRequirementTypeLovDs"	 		
	
}); 
 
