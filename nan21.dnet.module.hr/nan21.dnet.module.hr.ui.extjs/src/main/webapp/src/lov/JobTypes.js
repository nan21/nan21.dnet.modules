
Ext.define("net.nan21.dnet.module.hr.job.lovs.JobTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.job.lovs.JobTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasJobType"},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.JobTypeLovDs",
	_dataProviderName_:"JobTypeLovDs"	 		
	
}); 
 
