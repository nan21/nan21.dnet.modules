
Ext.define("net.nan21.dnet.module.hr.job.lovs.WorkRequirements", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.job.lovs.WorkRequirements",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasWr"},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.WorkRequirementLovDs",
	_dataProviderName_:"WorkRequirementLovDs"	 		
	
}); 
 
