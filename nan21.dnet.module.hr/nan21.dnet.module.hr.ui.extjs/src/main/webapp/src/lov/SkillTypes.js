
Ext.define("net.nan21.dnet.module.hr.skill.lovs.SkillTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.skill.lovs.SkillTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.skill.frame.SkillType_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.hr.skill.ds.model.SkillTypeLovDs",
	_dataProviderName_:"SkillTypeLovDs"	 		
	
}); 
 
