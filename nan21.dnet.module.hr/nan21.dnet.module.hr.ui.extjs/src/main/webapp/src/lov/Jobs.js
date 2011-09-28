
Ext.define("net.nan21.dnet.module.hr.job.lovs.Jobs", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.job.lovs.Jobs",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.job.frame.Job_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.JobLovDs",
	_dataProviderName_:"JobLovDs"	 		
	
}); 
 
