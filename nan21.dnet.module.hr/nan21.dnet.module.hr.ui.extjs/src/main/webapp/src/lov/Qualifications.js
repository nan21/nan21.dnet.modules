
Ext.define("net.nan21.dnet.module.hr.skill.lovs.Qualifications", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.skill.lovs.Qualifications",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.skill.frame.Qualification_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.QualificationLovDs",
	_dataProviderName_:"QualificationLovDs"	 		
	
}); 
 
