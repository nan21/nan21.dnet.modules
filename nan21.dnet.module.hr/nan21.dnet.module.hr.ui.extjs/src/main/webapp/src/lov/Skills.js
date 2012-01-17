
Ext.define("net.nan21.dnet.module.hr.skill.lovs.Skills", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.skill.lovs.Skills",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.skill.frame.Skill_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillLovDs",
	_dataProviderName_:"SkillLovDs"	 		
	
}); 
 
